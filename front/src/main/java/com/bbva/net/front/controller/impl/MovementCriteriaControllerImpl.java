package com.bbva.net.front.controller.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.tools.ant.util.DateUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.bbva.net.back.facade.MovementsAccountFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.predicate.BalanceRangeMovementPredicate;
import com.bbva.net.back.predicate.ConceptMovementPredicate;
import com.bbva.net.back.predicate.ExpensesPredicate;
import com.bbva.net.back.predicate.IncomesPredicate;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.controller.MovementCriteriaController;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.helper.MessagesHelper;
import com.bbva.net.front.ui.line.LineConfigUI;

/**
 * @author Entelgy
 */
public class MovementCriteriaControllerImpl extends MovementPaginatedController implements MovementCriteriaController {

	private static final long serialVersionUID = 1L;

	private static final String CONCRETE_DATE = MessagesHelper.INSTANCE.getString("select.radio.concret.date"),
			BALANCE_TITLE = MessagesHelper.INSTANCE.getString("msg.message.balance"),
			SINCE_TITLE = MessagesHelper.INSTANCE.getString("text.since"), TO_TITLE = MessagesHelper.INSTANCE
					.getString("text.to");

	private StringBuilder messageBalance;

	private String sinceText, toText, selectDate = StringUtils.EMPTY, titleDateSince, titleDateTo, sinceDatestr,
			toDatestr, titleInOrExp;

	private Date sinceDate = null, toDate = null;

	private MovementCriteriaDto movementCriteria = new MovementCriteriaDto();

	private BalanceRangeDto balanceRange;

	private DateRangeDto dateRange;

	private transient StreamedContent exportFile;

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	@Resource(name = "movementsAccountFacade")
	private transient MovementsAccountFacade movementsFacade;

	private List<MovementDto> movementsList;

	@Resource(name = "graphicLineDelegate")
	private transient GraphicLineDelegate graphicLineDelegate;

	private LineConfigUI graphicLineMovements;

	private MovementDetailDto movementDetail;

	@Override
	public void init() {
		super.init();
		LOGGER.info("Initialize MovementsAccountController");
	}

	@Override
	public List<MovementDto> getAllMovements() {
		LOGGER.info("MovementsAccountController getAllMovements");
		this.movementsList = new ArrayList<MovementDto>();
		dateRange = calculateDate(MessagesHelper.INSTANCE.getString("select.radio.last.month"));
		setDateRangePc(dateRange);
		setBalanceRangePc(null);
		// TODO oroductId
		setProductTypePc(getSelectedProduct().getSubTypeProd());
		LOGGER.info("MovementsAccountController getAllMovements productId:  " + getSelectedProduct().getProductId());
		super.setMovementsFacade(movementsFacade);
		next();
		this.movementsList = getCurrentList();
		this.graphicLineMovements = graphicLineDelegate.getMovementAccount(this.movementsList);
		return this.movementsList;
	}

	@Override
	public void onMovementSelected(SelectEvent selectEvent) {
		LOGGER.info("MovementsAccountController onMovementSelected");
		super.onMovementSelected(selectEvent);
		movementDetail = new MovementDetailDto();
		try {
			LOGGER.info("MovementsAccountController onMovementSelected movementId:  "
					+ getSelectedMovements().getMovementId());
			movementDetail = this.movementsFacade.getMovement(getSelectedProduct().getProductId(), getSelectedProduct()
					.getTypeProd().value(), getSelectedMovements().getMovementId());
		} catch (Exception e) {
			// FacesContext ctx = FacesContext.getCurrentInstance();
			// ctx.addMessage("movementDetail", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
		}
	}

	public void criteriaSearch() {
		LOGGER.info("MovementsAccountController criteriaSearch");
		if (getRenderComponents().get(RenderAttributes.FILTERDATE.toString())) {
			setDateRangePc(this.dateRange);
		}
		setProductTypePc(getSelectedProduct().getSubTypeProd());
		LOGGER.info("MovementsAccountController criteriaSearch productType:  " + getSelectedProduct().getSubTypeProd());
		LOGGER.info("MovementsAccountController criteriaSearch productId:  " + getSelectedProduct().getProductId());
		super.init();
		super.setMovementsFacade(movementsFacade);
		search();
		this.movementsList = getCurrentList();
		setShowMoreStatus();
		RequestContext.getCurrentInstance().update("detailAccounts:tableMovements:formMovesDetail:movAccount");
	}

	public void nextPage(ActionEvent event) {
		getRenderComponents().put(RenderAttributes.TITLEMOVES.name(), true);
		getRenderComponents().put(RenderAttributes.MOVEMENTSTABLE.name(), true);
		setFalseCheckBookComponents();
		setFalseCheckComponents();
		super.setMovementsFacade(movementsFacade);
		next();
		this.movementsList = getCurrentList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void searchMovementByFilter(final ActionEvent event) {
		LOGGER.info("MovementsAccountController searchMovementByFilter");
		setFalseCheckComponents();
		setFalseCheckBookComponents();
		getRenderComponents().put(RenderAttributes.TITLEMOVES.name(), true);
		getRenderComponents().put(RenderAttributes.MOVEMENTSTABLE.toString(), true);

		if (getRenderComponents().get(RenderAttributes.FILTERDATE.toString())) {
			// Get movements by date
			LOGGER.info("MovementsAccountController searchMovementByFilterDate");
			this.dateRange = calculateDate(this.getSelectDate());
			criteriaSearch();
			resetMapResults();

		}
		if (getRenderComponents().get(RenderAttributes.BALANCEFILTER.toString())) {
			// Get movements by balance
			LOGGER.info("MovementsAccountController searchMovementByBalanceFilter");
			this.balanceRange = new BalanceRangeDto();
			this.balanceRange.setBalanceSince(movementCriteria.getBalanceRange().getBalanceSince());
			this.balanceRange.setBalanceTo(movementCriteria.getBalanceRange().getBalanceTo());

			// Get only movements by concept
			final List<MovementDto> movementsByBalance = (List<MovementDto>)CollectionUtils.select(this.movementsList,
					new BalanceRangeMovementPredicate(balanceRange));
			this.movementsList = movementsByBalance;
			setShowMoreStatus();
			getRenderComponents().put(RenderAttributes.MOVEMENTSTABLE.toString(), true);
			resetMapResults();
		}

		if (getRenderComponents().get(RenderAttributes.INCOMEOREXPENSESFILTER.toString())) {
			// Get only movements by income or expenses
			LOGGER.info("MovementsAccountController searchMovementByIncomeOrExpensesFilter");
			getRenderComponents().put(RenderAttributes.MOVEMENTSTABLE.toString(), true);

			if (movementCriteria.getIncomesOrExpenses() != null && movementCriteria.getIncomesOrExpenses().equals("1")) {
				// Income Movements
				LOGGER.info("MovementsAccountController searchMovementByIncomeOrExpensesFilter incomeMovements");
				final List<MovementDto> incomeMovements = (List<MovementDto>)CollectionUtils.select(this.movementsList,
						new IncomesPredicate());
				this.movementsList = incomeMovements;
				setShowMoreStatus();
			}

			if (movementCriteria.getIncomesOrExpenses() != null && movementCriteria.getIncomesOrExpenses().equals("2")) {
				// Expense Movements
				LOGGER.info("MovementsAccountController searchMovementByIncomeOrExpensesFilter expensesMovements");
				final List<MovementDto> expensesMovements = (List<MovementDto>)CollectionUtils.select(
						this.movementsList, new ExpensesPredicate());
				this.movementsList = expensesMovements;
				setShowMoreStatus();
			}
			RequestContext.getCurrentInstance().update(":detailAccounts:tableMovements:formMovesDetail:movAccount");
			resetMapResults();
		}

		if (getRenderComponents().get(RenderAttributes.MOVEMENTSFILTER.toString())) {
			LOGGER.info("MovementsAccountController searchMovementByMovementFilter");
			// Get only movements by concept
			final List<MovementDto> movementsByConcept = (List<MovementDto>)CollectionUtils.select(this.movementsList,
					new ConceptMovementPredicate(movementCriteria.getMovement()));
			this.movementsList = movementsByConcept;
			setShowMoreStatus();
			getRenderComponents().put(RenderAttributes.MOVEMENTSTABLE.toString(), true);
			resetMapResults();
		}
		clean();
	}

	@Override
	public void oneSelectDate() {
		LOGGER.info("MovementsAccountController oneSelectDate");
		getRenderComponents().put(RenderAttributes.FILTERDATE.toString(), true);
		if (getSelectDate().equals(CONCRETE_DATE)) {
			getRenderComponents().put(RenderAttributes.CALENDAR.toString(), false);
			getRenderComponents().put(RenderAttributes.BUTTONDATE.toString(), false);
		} else {
			getRenderComponents().put(RenderAttributes.CALENDAR.toString(), true);
			getRenderComponents().put(RenderAttributes.BUTTONDATE.toString(), false);
		}
	}

	@Override
	public void setBalanceRange(final ActionEvent event) {
		LOGGER.info("MovementsAccountController setBalanceRange");
		getRenderComponents().put(RenderAttributes.BALANCEFILTER.toString(), true);
		setSinceText(SINCE_TITLE + ": ");
		setToText(TO_TITLE + ": ");
	}

	@Override
	public void setIncomeExpensesFilter(final ActionEvent event) {
		LOGGER.info("MovementsAccountController setIncomeExpensesFilter");
		getRenderComponents().put(RenderAttributes.INCOMEOREXPENSESFILTER.toString(), true);
		if (movementCriteria.getIncomesOrExpenses().equals("1"))
			setTitleInOrExp(MessagesHelper.INSTANCE.getString("select.radio.in"));
		else if (movementCriteria.getIncomesOrExpenses().equals("2"))
			setTitleInOrExp(MessagesHelper.INSTANCE.getString("select.radio.out"));
		else
			setTitleInOrExp(MessagesHelper.INSTANCE.getString("select.radio.in.out"));
		System.out.println(movementCriteria.getIncomesOrExpenses());
	}

	@Override
	public void setMovementConcept(final ActionEvent event) {
		LOGGER.info("MovementsAccountController setMovementConcept");
		getRenderComponents().put(RenderAttributes.MOVEMENTSFILTER.toString(), true);
	}

	@Override
	public void balanceValidator() {
		LOGGER.info("MovementsAccountController balanceValidator");
		if ((movementCriteria.getBalanceRange().getBalanceSince() != (null) && movementCriteria.getBalanceRange()
				.getBalanceTo() != (null))) {

			if (movementCriteria.getBalanceRange().getBalanceSince()
					.compareTo(movementCriteria.getBalanceRange().getBalanceTo()) == -1) {
				messageBalance = new StringBuilder("Se mostrarán los resultados mayores de "
						+ movementCriteria.getBalanceRange().getBalanceSince() + "$" + " y menores de "
						+ movementCriteria.getBalanceRange().getBalanceTo() + "$");

			}
		} else {
			messageBalance = new StringBuilder();
		}
	}

	@Override
	public void buildMessage() {
		LOGGER.info("MovementsAccountController buildMessage");
		messageBalance = new StringBuilder(BALANCE_TITLE);
		messageBalance.append(movementCriteria.getBalanceRange().getBalanceSince() + "$");
	}

	public DateRangeDto calculateDate(String date) {
		LOGGER.info("MovementsAccountController calculateDate ");

		EnumPeriodType periodType = EnumPeriodType.valueOfLabel(date);
		if (!(periodType == (null))) {
			this.dateRange = new DateRangeDto();
			this.dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
		}
		return dateRange;
	}

	@Override
	public void setCustomDate(final ActionEvent event) {
		LOGGER.info("MovementsAccountController setCustomDate");
		getRenderComponents().put(RenderAttributes.FILTERDATE.toString(), true);
		this.dateRange = new DateRangeDto();
		this.dateRange.setDateSince(getSinceDate());
		this.dateRange.setDateTo(getToDate());
		if (!(getSinceDate() == (null)) && !(getToDate() == (null)) && getSelectDate().equals(CONCRETE_DATE)) {
			titleDateSince = SINCE_TITLE + ":";
			titleDateTo = TO_TITLE + ":";
			sinceDatestr = DateUtils.format(getSinceDate(), "dd/MM/yyyy");
			toDatestr = DateUtils.format(getToDate(), "dd/MM/yyyy");
		} else {
			titleDateSince = "";
			titleDateTo = "";
			sinceDatestr = getSelectDate();
			toDatestr = "";
			setSinceDate(null);
			setToDate(null);

		}
	}

	@Override
	public void cleanFilters(ActionEvent event) {
		LOGGER.info("MovementsAccountController clean Filters");
		clean();
	}

	@Override
	public void clean() {

		movementCriteria = new MovementCriteriaDto();
		balanceRange = new BalanceRangeDto();
		movementCriteria.setBalanceRange(balanceRange);
		movementCriteria.setDateRange(null);
		setSinceText(new String());
		setToText(new String());
		setSinceDatestr(new String());
		setToDatestr(new String());
		setTitleInOrExp(new String());
		messageBalance = new StringBuilder();
		sinceDate = null;
		toDate = null;
		titleDateSince = "";
		titleDateTo = "";
		selectDate = StringUtils.EMPTY;
		dateRange = null;

	}

	/**
	 * Method to evaluate if the list has more elements
	 * 
	 * @param movementsList
	 */
	public void setShowMoreStatus() {
		if (this.movementsList.size() >= 10)
			getRenderComponents().put(RenderAttributes.FOOTERTABLEMOVEMENT.name(), true);
		else
			getRenderComponents().put(RenderAttributes.FOOTERTABLEMOVEMENT.name(), false);
	}

	public void setFalseCheckComponents() {
		getRenderComponents().put(RenderAttributes.TITLECHECKS.name(), false);
		getRenderComponents().put(RenderAttributes.CHECKTABLE.toString(), false);
		getRenderComponents().put(RenderAttributes.FOOTERTABLECHEKS.toString(), false);
	}

	public void setFalseCheckBookComponents() {
		getRenderComponents().put(RenderAttributes.TITLECHECKBOOKS.name(), false);
		getRenderComponents().put(RenderAttributes.CHECKBOOKTABLE.name(), false);
		getRenderComponents().put(RenderAttributes.FOOTERTABLECHECKBOOK.name(), false);
	}

	public void resetMapResults() {
		getRenderComponents().put(RenderAttributes.MOVEMENTSFILTER.toString(), false);
		getRenderComponents().put(RenderAttributes.INCOMEOREXPENSESFILTER.toString(), false);
		getRenderComponents().put(RenderAttributes.BALANCEFILTER.toString(), false);
		getRenderComponents().put(RenderAttributes.FILTERDATE.toString(), false);
	}

	@Override
	public void exportExcel() {
		LOGGER.info("iniciando exportar archivo excel");

		String rutaArchivo = "src/main/webapp/assets/img/Movimientos.xls";

		File archivoXLS = new File(rutaArchivo);
		if (archivoXLS.exists()) archivoXLS.delete();

		try {
			archivoXLS.createNewFile();
		} catch (IOException e) {
			LOGGER.info("Excepción al crear el archivo" + e.getMessage());
		}
		Workbook libro = new HSSFWorkbook();

		// Create a new font and alter it.

		try {
			FileOutputStream archivo = new FileOutputStream(archivoXLS);
			Sheet hoja = libro.createSheet("Movimientos de cuenta");
			// try {

			// InputStream inputStream = new FileInputStream("src/main/webapp/assets/img/bbva.png");

			// byte[] bytes = IOUtils.toByteArray(inputStream);

			// int pictureIdx = libro.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);

			// inputStream.close();
			//

			// CreationHelper helper = libro.getCreationHelper();
			//

			// Drawing drawing = hoja.createDrawingPatriarch();
			//

			// ClientAnchor anchor = helper.createClientAnchor();

			// anchor.setCol1(0);
			// anchor.setRow1(0);
			//

			// Picture pict = drawing.createPicture(anchor, pictureIdx);

			// pict.resize();
			// } catch (Exception e) {
			// LOGGER.info("Excepción al cargar imagen bbva" + e.getMessage());
			// }
			Row filaHeader = hoja.createRow(0);

			filaHeader.createCell(0).setCellValue("Fecha");

			filaHeader.createCell(2).setCellValue("Concepto");

			filaHeader.createCell(4).setCellValue("Valor");

			filaHeader.createCell(6).setCellValue("Saldo");

			hoja.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
			hoja.addMergedRegion(new CellRangeAddress(0, 0, 2, 3));
			hoja.addMergedRegion(new CellRangeAddress(0, 0, 4, 5));
			hoja.addMergedRegion(new CellRangeAddress(0, 0, 6, 7));
			for (int f = 0; f < this.movementsList.size(); f++) {
				Row fila = hoja.createRow(f + 1);
				for (int c = 0; c < 8; c = c + 2) {
					Cell celda = fila.createCell(c);

					if (c == 0) {
						CellStyle cellStyle = libro.createCellStyle();
						Font date = libro.createFont();
						date.setFontHeightInPoints((short)10);
						date.setFontName("Arial");
						date.setBold(true);
						date.setColor(HSSFColor.BLUE.index);
						cellStyle.setFont(date);
						celda.setCellStyle(cellStyle);

						celda.setCellValue(getdateString(this.movementsList.get(f).getOperationDate()));

					}
					if (c == 2) {
						celda.setCellValue(this.movementsList.get(f).getMovementConcept());

					}
					if (c == 4) {
						celda.setCellValue(this.movementsList.get(f).getMovementValue().toString());

					}
					if (c == 6) {
						celda.setCellValue(this.movementsList.get(f).getTotalBalance().toString());

					}
					hoja.addMergedRegion(new CellRangeAddress(f, f, 0, 1));
					hoja.addMergedRegion(new CellRangeAddress(f, f, 2, 3));
					hoja.addMergedRegion(new CellRangeAddress(f, f, 4, 5));
					hoja.addMergedRegion(new CellRangeAddress(f, f, 6, 7));
				}
			}
			try {
				libro.write(archivo);
				archivo.close();
			} catch (IOException e) {
				LOGGER.info("Excepción al leer y cerrar el archivo" + e.getMessage());
			}

		} catch (FileNotFoundException e) {
			LOGGER.info("Excepción no se encuentra el archivo" + e.getMessage());
		}
	}

	public String getdateString(Date date) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat(
				MessagesHelper.INSTANCE.getStringI18("date.pattner.dd-mm-yyyy"));
		return dateFormat.format(date);
	}

	@Override
	public void printFile() {
		FileInputStream inputFile = null;
		try {
			inputFile = new FileInputStream("src/main/webapp/assets/img/Movimientos.pdf");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (inputFile == null) {
			return;
		}

		DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
		Doc document = new SimpleDoc(inputFile, docFormat, null);

		PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

		PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

		if (defaultPrintService != null) {
			DocPrintJob printJob = defaultPrintService.createPrintJob();
			try {
				printJob.print(document, attributeSet);

			} catch (Exception e) {
				LOGGER.info("Erro al imrpimir " + e.getMessage());
			}
		} else {
			System.err.println("No existen impresoras instaladas");
		}
		try {
			inputFile.close();
		} catch (IOException e) {
			LOGGER.info("Erro al cerrar el archivo de impresión " + e.getMessage());
		}
	}

	@Override
	public void emailFile() {

	};

	@Override
	public ProductDto getSelectedProduct() {
		return super.getSelectedProduct();
	}

	// Getters And Setters

	/**
	 * @return the messageBalance
	 */
	public StringBuilder getMessageBalance() {
		return messageBalance;
	}

	/**
	 * @param messageBalance the messageBalance to set
	 */
	public void setMessageBalance(StringBuilder messageBalance) {
		this.messageBalance = messageBalance;
	}

	/**
	 * @return the sinceText
	 */
	public String getSinceText() {
		return sinceText;
	}

	/**
	 * @param sinceText the sinceText to set
	 */
	public void setSinceText(final String sinceText) {
		this.sinceText = sinceText;
	}

	/**
	 * @return the toText
	 */
	public String getToText() {
		return toText;
	}

	/**
	 * @param toText the toText to set
	 */
	public void setToText(String toText) {
		this.toText = toText;
	}

	/**
	 * @return the selectDate
	 */
	public String getSelectDate() {
		return selectDate;
	}

	/**
	 * @param selectDate the selectDate to set
	 */
	public void setSelectDate(String selectDate) {
		this.selectDate = selectDate;
	}

	/**
	 * @return the sinceDatestr
	 */
	public String getSinceDatestr() {
		return sinceDatestr;
	}

	/**
	 * @param sinceDatestr the sinceDatestr to set
	 */
	public void setSinceDatestr(String sinceDatestr) {
		this.sinceDatestr = sinceDatestr;
	}

	public List<MovementDto> getMovementsList() {
		return movementsList;
	}

	/**
	 * @return the toDatestr
	 */
	public String getToDatestr() {
		return toDatestr;
	}

	/**
	 * @param toDatestr the toDatestr to set
	 */
	public void setToDatestr(final String toDatestr) {
		this.toDatestr = toDatestr;
	}

	/**
	 * @return the titleInOrExp
	 */
	public String getTitleInOrExp() {
		return titleInOrExp;
	}

	/**
	 * @param titleInOrExp the titleInOrExp to set
	 */
	public void setTitleInOrExp(String titleInOrExp) {
		this.titleInOrExp = titleInOrExp;
	}

	/**
	 * @return the sinceDate
	 */
	public Date getSinceDate() {
		return sinceDate;
	}

	/**
	 * @param sinceDate the sinceDate to set
	 */
	public void setSinceDate(Date sinceDate) {
		this.sinceDate = sinceDate;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the movementCriteria
	 */
	public MovementCriteriaDto getMovementCriteria() {
		return movementCriteria;
	}

	/**
	 * @param movementCriteria the movementCriteria to set
	 */
	public void setMovementCriteria(MovementCriteriaDto movementCriteria) {
		this.movementCriteria = movementCriteria;
	}

	/**
	 * @return the balanceRange
	 */
	public BalanceRangeDto getBalanceRange() {
		return balanceRange;
	}

	/**
	 * @param balanceRange the balanceRange to set
	 */
	public void setBalanceRange(BalanceRangeDto balanceRange) {
		this.balanceRange = balanceRange;
	}

	/**
	 * @return the dateRange
	 */
	public DateRangeDto getDateRange() {
		return dateRange;
	}

	/**
	 * @param dateRange the dateRange to set
	 */
	public void setDateRange(DateRangeDto dateRange) {
		this.dateRange = dateRange;
	}

	/**
	 * @return the multiValueGroupFacade
	 */
	public MultiValueGroupFacade getMultiValueGroupFacade() {
		return multiValueGroupFacade;
	}

	/**
	 * @param multiValueGroupFacade the multiValueGroupFacade to set
	 */
	public void setMultiValueGroupFacade(MultiValueGroupFacade multiValueGroupFacade) {
		this.multiValueGroupFacade = multiValueGroupFacade;
	}

	public GraphicLineDelegate getGraphicLineDelegate() {
		return graphicLineDelegate;
	}

	public LineConfigUI getGraphicLineMovements() {
		return graphicLineMovements;
	}

	/**
	 * @return the renderComponents
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Boolean> getRenderComponents() {
		return (Map<String, Boolean>)getViewVarView("renderComponents");
	}

	/**
	 * @return the movementDetail
	 */
	public MovementDetailDto getMovementDetail() {
		return movementDetail;
	}

	/**
	 * @param movementDetail the movementDetail to set
	 */
	public void setMovementDetail(MovementDetailDto movementDetail) {
		this.movementDetail = movementDetail;
	}

	/**
	 * @return the titleDateSince
	 */
	public String getTitleDateSince() {
		return titleDateSince;
	}

	/**
	 * @param titleDateSince the titleDateSince to set
	 */
	public void setTitleDateSince(String titleDateSince) {
		this.titleDateSince = titleDateSince;
	}

	/**
	 * @return the titleDateTo
	 */
	public String getTitleDateTo() {
		return titleDateTo;
	}

	/**
	 * @param titleDateTo the titleDateTo to set
	 */
	public void setTitleDateTo(String titleDateTo) {
		this.titleDateTo = titleDateTo;
	}

	/**
	 * @param movementsFacade the movementsFacade to set
	 */
	@Override
	public void setMovementsFacade(MovementsAccountFacade movementsFacade) {
		this.movementsFacade = movementsFacade;
	}

	/**
	 * @param movementsList the movementsList to set
	 */
	public void setMovementsList(List<MovementDto> movementsList) {
		this.movementsList = movementsList;
	}

	/**
	 * @param graphicLineDelegate the graphicLineDelegate to set
	 */
	public void setGraphicLineDelegate(GraphicLineDelegate graphicLineDelegate) {
		this.graphicLineDelegate = graphicLineDelegate;
	}

	/**
	 * @param graphicLineMovements the graphicLineMovements to set
	 */
	public void setGraphicLineMovements(LineConfigUI graphicLineMovements) {
		this.graphicLineMovements = graphicLineMovements;
	}

	public StreamedContent getExportFile() {
		exportExcel();
		InputStream stream;
		try {
			stream = new BufferedInputStream(new FileInputStream("src/main/webapp/assets/img/Movimientos.xls"));
			exportFile = new DefaultStreamedContent(stream, "application/xls", "Movimientos.xls");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return exportFile;
	}

	public void setExportFile(StreamedContent exportFile) {
		this.exportFile = exportFile;
	}

}