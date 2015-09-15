package com.bbva.net.front.controller.impl;

import java.awt.print.PrinterJob;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.tools.ant.util.DateUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.bbva.net.back.entity.MultiCoordinates;
import com.bbva.net.back.entity.MultiValueGroup;
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
import com.bbva.net.back.predicate.CityOfficePredicate;
import com.bbva.net.back.predicate.ConceptMovementPredicate;
import com.bbva.net.back.predicate.ExpensesPredicate;
import com.bbva.net.back.predicate.IncomesPredicate;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.controller.HeaderController;
import com.bbva.net.front.controller.MovementCriteriaController;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.helper.MessagesHelper;
import com.bbva.net.front.ui.line.LineConfigUI;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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

	private String sinceText, toText, statusText = StringUtils.EMPTY, statusLabel = StringUtils.EMPTY,
			selectDate = StringUtils.EMPTY, titleDateSince, titleDateTo, sinceDatestr, toDatestr, titleInOrExp,
			status = StringUtils.EMPTY;

	private Date sinceDate = null, toDate = null;

	private MovementCriteriaDto movementCriteria = new MovementCriteriaDto();

	private BalanceRangeDto balanceRange;

	private DateRangeDto dateRange;

	private transient StreamedContent exportExcel;

	private transient StreamedContent exportPdf;

	private transient StreamedContent exportDetailPdf;

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	@Resource(name = "movementsAccountFacade")
	private transient MovementsAccountFacade movementsFacade;

	private List<MovementDto> movementsList, movementsListGen;

	@Resource(name = "graphicLineDelegate")
	private transient GraphicLineDelegate graphicLineDelegate;

	private LineConfigUI graphicLineMovements;

	private MovementDetailDto movementDetail;

	private MovementDto movementAction;

	private List<MultiValueGroup> conceptMovements;

	private String rutaMoveExcel;

	private String rutaMovePdf;

	private String rutaMoveDetailPdf;

	protected String RUTA_ICONO_BBVA = MessagesHelper.INSTANCE.getString("ruta.iconobbva");

	protected String IP_IRONPORT = MessagesHelper.INSTANCE.getString("ruta.ipironport");

	protected String PUERTO_IRONPORT = MessagesHelper.INSTANCE.getString("ruta.puertoironport");

	protected String REMITENTE = MessagesHelper.INSTANCE.getString("ruta.remitente");

	@Resource(name = "headerController")
	private transient HeaderController headerController;

	@Override
	public void init() {
		super.init();
		LOGGER.info("Initialize MovementsAccountController");
	}

	public void resetData() {
		final HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		session.setAttribute("operationsAccount", "false");
	}

	@Override
	public List<MovementDto> getAllMovements() {
		LOGGER.info("MovementsAccountController getAllMovements");
		this.movementsList = new ArrayList<MovementDto>();
		dateRange = calculateDate(MessagesHelper.INSTANCE.getString("select.radio.45.days"));
		setDateRangePc(dateRange);
		setBalanceRangePc(null);
		// TODO oroductId
		setProductTypePc(getSelectedProduct().getSubTypeProd());
		if (getSelectedProduct() != null && getSelectedProduct().getProductId() != null
				&& getSelectedProduct().isVisible() != null) {
			if (getSelectedProduct().isVisible()) {
				LOGGER.info("MovementsAccountController getAllMovements productId:  "
						+ getSelectedProduct().getProductId());
				super.setMovementsFacade(movementsFacade);
				next();
				this.movementsList = getCurrentList();
			}
		}
		this.movementsListGen = this.movementsList;
		this.graphicLineMovements = graphicLineDelegate.getMovementAccount(this.movementsList);
		return this.movementsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onMovementSelected(SelectEvent selectEvent) {
		this.movementAction = new MovementDto();
		super.onMovementSelected(selectEvent);
		this.movementAction = super.getSelectedMovements();
		this.movementDetail = null;

		try {
			LOGGER.info("Control MovementsAccountController onMovementSelected movementId:  "
					+ getSelectedMovements().getMovementId());
			LOGGER.info("Antes de llamar al servicio ...");
			movementDetail = this.movementsFacade.getMovement(getSelectedProduct().getProductId(), getSelectedProduct()
					.getTypeProd().value(), getSelectedMovements().getMovementId());
			LOGGER.info("Despues de llamar al servicio ...");

			List<MultiCoordinates> coordenadas = new ArrayList<MultiCoordinates>();
			if (movementDetail.getPlaza().getCode() != null && !movementDetail.getPlaza().getCode().isEmpty()) {
				LOGGER.info("Antes del obtener el codigo ..." + movementDetail.getPlaza().getCode());
				coordenadas = this.multiValueGroupFacade.getMultiCoordinate(movementDetail.getPlaza().getCode());
				LOGGER.info("coordenadas por codigo size " + coordenadas.size());
				LOGGER.info("coordenadas por codigo" + coordenadas.get(0).getLatitude() + " "
						+ coordenadas.get(0).getLength());
			} else {
				LOGGER.info("plaza " + movementDetail.getPlaza().getPostalAddress().substring(0, 4));
				coordenadas = this.multiValueGroupFacade.getMultiCoordinate(movementDetail.getPlaza()
						.getPostalAddress().substring(0, 4));
				LOGGER.info("coordenadas por postalAddres" + coordenadas.get(0).getLatitude() + " "
						+ coordenadas.get(0).getLength());

			}
			LOGGER.info("Despues de llamar a la BDD ...");
			if (coordenadas.size() >= 2) {
				LOGGER.info("Entra al if de llamar a la BDD ... te que se encontro 2 coordenadas mas");
				coordenadas = (List<MultiCoordinates>)CollectionUtils.select(coordenadas, new CityOfficePredicate(
						movementDetail.getPlaza().getCity()));
			}
			LOGGER.info("Sale del if de llamar a la BDD ...");
			movementDetail.getPlaza().setLatitude(coordenadas.get(0).getLatitude());
			LOGGER.info("asigna latitude .." + coordenadas.get(0).getLatitude());
			movementDetail.getPlaza().setLength(coordenadas.get(0).getLength());
			LOGGER.info("asigna longitud .." + coordenadas.get(0).getLength());
			LOGGER.info("latitud..." + coordenadas.get(0).getLatitude() + "..longitud.."
					+ coordenadas.get(0).getLength() + "..");
		} catch (Exception e) {
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage("movementDetail", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"No es posible ubicar la oficina en el mapa"));
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
		LOGGER.info("MovementsAccountController nextPage");
		getRenderComponents().put(RenderAttributes.TITLEMOVES.name(), true);
		getRenderComponents().put(RenderAttributes.MOVEMENTSTABLE.name(), true);
		setFalseCheckBookComponents();
		setFalseCheckComponents();
		super.setMovementsFacade(movementsFacade);
		next();
		this.movementsList = getCurrentList();
		this.movementsListGen = this.movementsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void searchMovementByFilter(final AjaxBehaviorEvent event) {
		LOGGER.info("MovementsAccountController searchMovementByFilter");
		setFalseCheckComponents();
		setFalseCheckBookComponents();
		getRenderComponents().put(RenderAttributes.TITLEMOVES.name(), true);
		getRenderComponents().put(RenderAttributes.MOVEMENTSTABLE.toString(), true);
		this.movementsList = this.movementsListGen;
		if (getRenderComponents().get(RenderAttributes.FILTERDATE.toString())) {
			// Get movements by date
			LOGGER.info("MovementsAccountController searchMovementByFilterDate");
			this.dateRange = calculateDate(this.getSelectDate());
			criteriaSearch();
		} else {
			this.dateRange = null;
			setDateRangePc(dateRange);
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
			// setShowMoreStatus();
			getRenderComponents().put(RenderAttributes.MOVEMENTSTABLE.toString(), true);
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
				// setShowMoreStatus();
			}

			if (movementCriteria.getIncomesOrExpenses() != null && movementCriteria.getIncomesOrExpenses().equals("2")) {
				// Expense Movements
				LOGGER.info("MovementsAccountController searchMovementByIncomeOrExpensesFilter expensesMovements");
				final List<MovementDto> expensesMovements = (List<MovementDto>)CollectionUtils.select(
						this.movementsList, new ExpensesPredicate());
				this.movementsList = expensesMovements;
				// setShowMoreStatus();
			}
			RequestContext.getCurrentInstance().update(":detailAccounts:tableMovements:formMovesDetail:movAccount");
		}

		if (getRenderComponents().get(RenderAttributes.MOVEMENTSFILTER.toString())
				&& movementCriteria.getMovement() != null) {
			LOGGER.info("MovementsAccountController searchMovementByMovementFilter" + movementCriteria.getMovement()
					+ "--");
			// Get only movements by concept
			if (status.equals(MessagesHelper.INSTANCE.getString("mov.all"))) status = null;
			final List<MovementDto> movementsByConcept = (List<MovementDto>)CollectionUtils.select(this.movementsList,
					new ConceptMovementPredicate(movementCriteria.getMovement(), status));
			this.movementsList = movementsByConcept;
			// setShowMoreStatus();
			getRenderComponents().put(RenderAttributes.MOVEMENTSTABLE.toString(), true);

		}
		getRenderComponents().put(RenderAttributes.FOOTERTABLEMOVEMENT.name(), false);
		// clean();
	}

	public boolean selectFilterMove() {
		Boolean estado = false;
		List<String> values = new ArrayList<String>();
		values.add("Pago de facturas PSE");
		values.add("Pago de facturas");
		values.add("Remesas");
		statusText = StringUtils.EMPTY;
		statusLabel = StringUtils.EMPTY;
		LOGGER.info("--- " + movementCriteria.getMovement());
		if (movementCriteria.getMovement() != null) {
			if (movementCriteria.getMovement().equals(values.get(0))) {
				statusText = "Estado";
				status = MessagesHelper.INSTANCE.getString("mov.all");
				statusLabel = status;
				estado = true;
				conceptMovements = multiValueGroupFacade.getMultiValueTypes(13);
			}
			if (movementCriteria.getMovement().equals(values.get(1))) {
				statusText = "Estado";
				status = MessagesHelper.INSTANCE.getString("mov.all");
				statusLabel = status;
				estado = true;
				conceptMovements = multiValueGroupFacade.getMultiValueTypes(14);
			}
			if (movementCriteria.getMovement().equals(values.get(2))) {
				statusText = "Estado";
				status = MessagesHelper.INSTANCE.getString("mov.all");
				statusLabel = status;
				estado = true;
				conceptMovements = multiValueGroupFacade.getMultiValueTypes(15);
			}
		}
		return estado;
	}

	public List<String> completeMovement(String filter) {
		List<String> values = new ArrayList<String>();
		values.add("Pago de facturas PSE");
		values.add("Pago de facturas");
		values.add("Remesas");
		statusText = StringUtils.EMPTY;
		List<String> results = new ArrayList<String>();
		if (!filter.isEmpty()) {
			for (int i = 0; i < values.size(); i++) {
				if (values.get(i).toLowerCase().startsWith(filter.toLowerCase())) {
					results.add(values.get(i));
				}
			}

		}
		return results;
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
	public void setBalanceRange(final AjaxBehaviorEvent event) {
		LOGGER.info("MovementsAccountController setBalanceRange");
		getRenderComponents().put(RenderAttributes.BALANCEFILTER.toString(), true);
		setSinceText(SINCE_TITLE + ": ");
		setToText(TO_TITLE + ": ");
	}

	@Override
	public void setIncomeExpensesFilter(final AjaxBehaviorEvent event) {
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
	public void setMovementConcept(final AjaxBehaviorEvent event) {
		LOGGER.info("MovementsAccountController setMovementConcept");
		if (statusText.isEmpty()) {
			statusLabel = StringUtils.EMPTY;
		}
		getRenderComponents().put(RenderAttributes.MOVEMENTSFILTER.toString(), true);

	}

	@Override
	public void balanceValidator() {
		LOGGER.info("MovementsAccountController balanceValidator");
		if ((movementCriteria.getBalanceRange().getBalanceSince() != (null) && movementCriteria.getBalanceRange()
				.getBalanceTo() != (null))) {

			if (movementCriteria.getBalanceRange().getBalanceSince()
					.compareTo(movementCriteria.getBalanceRange().getBalanceTo()) == -1) {
				messageBalance = new StringBuilder("Se mostrarán los resultados mayores de $ "
						+ movementCriteria.getBalanceRange().getBalanceSince() + " y menores de $ "
						+ movementCriteria.getBalanceRange().getBalanceTo());

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

	public void setLabelConcept() {
		statusLabel = status;
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
	public void setCustomDate(final AjaxBehaviorEvent event) {
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
	public void cleanFilters(AjaxBehaviorEvent event) {
		LOGGER.info("MovementsAccountController clean Filters");
		getAllMovements();
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
		statusText = StringUtils.EMPTY;
		status = StringUtils.EMPTY;
		statusLabel = StringUtils.EMPTY;

	}

	// Export Excel
	@SuppressWarnings("deprecation")
	@Override
	public void exportDocumentExcel() {
		LOGGER.info("iniciando exportar archivo excel");
		File miDir = new File(".");
		try {
			LOGGER.info("Directorio actual: " + miDir.getCanonicalPath());
		} catch (Exception e) {
			LOGGER.info("No encontró directorio actual " + e.getMessage());
		}
		rutaMoveExcel = "movimientos" + getSelectedProduct().getProductNumber() + ".xls";
		headerController.setLastDownload(rutaMoveExcel);
		List<Cell> cellSheet = new ArrayList<Cell>();

		int inicio = 10;

		File archivoXLS = new File(rutaMoveExcel);
		if (archivoXLS.exists()) archivoXLS.delete();

		try {
			archivoXLS.createNewFile();
		} catch (IOException e) {
			LOGGER.info("Excepción al crear el archivo" + e.getMessage());
		}
		Workbook libro = new HSSFWorkbook();

		try {
			FileOutputStream archivo = new FileOutputStream(archivoXLS);
			Sheet hoja = libro.createSheet("Movimientos de cuenta");
			try {
				URL url = new URL(RUTA_ICONO_BBVA);
				InputStream is = url.openStream();
				// InputStream inputStream = new FileInputStream(
				// "https://www.bbva.com.co/BBVA-home-theme/images/BBVA/logo_bbva.png");
				ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
				int b;
				while ((b = is.read()) != -1)
					img_bytes.write(b);
				is.close();

				int pictureIdx = libro.addPicture(img_bytes.toByteArray(), Workbook.PICTURE_TYPE_PNG);

				CreationHelper helper = libro.getCreationHelper();

				Drawing drawing = hoja.createDrawingPatriarch();

				ClientAnchor anchor = helper.createClientAnchor();
				anchor.setCol1(1);
				anchor.setRow1(1);

				Picture pict = drawing.createPicture(anchor, pictureIdx);
				pict.resize();
			} catch (Exception e) {
				LOGGER.info("Excepción al cargar imagen bbva" + e.getMessage());
			}

			Row filaHeader = hoja.createRow(inicio);
			filaHeader.createCell(1).setCellValue("Estimado(a) cliente:");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 2));

			inicio = inicio + 4;

			filaHeader = hoja.createRow(inicio);

			Font text = libro.createFont();
			text.setFontHeightInPoints((short)10);
			text.setFontName("Arial");
			text.setBold(true);
			text.setColor(HSSFColor.BLACK.index);

			CellStyle cellStyleHeader = libro.createCellStyle();
			cellStyleHeader.setFont(text);
			cellStyleHeader.setBorderBottom((short)0);
			cellStyleHeader.setWrapText(true);
			cellStyleHeader.setBorderBottom((short)1);
			cellStyleHeader.setBorderLeft((short)1);
			cellStyleHeader.setBorderRight((short)1);
			cellStyleHeader.setBorderTop((short)1);
			cellStyleHeader.setAlignment(CellStyle.ALIGN_CENTER);

			if (movementsList != null && (this.movementsList.size() != 0 || !this.movementsList.isEmpty())) {

				Cell dateMove = filaHeader.createCell(1);
				dateMove.setCellType(Cell.CELL_TYPE_STRING);
				dateMove.setCellStyle(cellStyleHeader);
				dateMove.setCellValue("FECHA");
				cellSheet.add(dateMove);

				Cell concept = filaHeader.createCell(2);
				concept.setCellType(Cell.CELL_TYPE_STRING);
				concept.setCellStyle(cellStyleHeader);
				concept.setCellValue("CONCEPTO");
				cellSheet.add(concept);

				Cell value = filaHeader.createCell(3);
				value.setCellType(Cell.CELL_TYPE_STRING);
				value.setCellStyle(cellStyleHeader);
				value.setCellValue("VALOR");
				cellSheet.add(value);

				Cell saldValue = filaHeader.createCell(4);
				saldValue.setCellType(Cell.CELL_TYPE_STRING);
				saldValue.setCellStyle(cellStyleHeader);
				saldValue.setCellValue("SALDO");
				cellSheet.add(saldValue);

				hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 1));
				hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 2, 2));
				hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 3, 3));
				hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 4, 4));

			} else {

				Cell numberCheck = filaHeader.createCell(1);
				numberCheck.setCellType(Cell.CELL_TYPE_STRING);
				numberCheck.setCellStyle(cellStyleHeader);
				numberCheck.setCellValue("FECHA");
				hoja.autoSizeColumn(1);

				Cell dateRea = filaHeader.createCell(2);
				dateRea.setCellType(Cell.CELL_TYPE_STRING);
				dateRea.setCellStyle(cellStyleHeader);
				dateRea.setCellValue("CONCEPTO");
				hoja.autoSizeColumn(2);

				Cell valueCheck = filaHeader.createCell(3);
				valueCheck.setCellType(Cell.CELL_TYPE_STRING);
				valueCheck.setCellStyle(cellStyleHeader);
				valueCheck.setCellValue("VALOR");
				hoja.autoSizeColumn(3);

				Cell state = filaHeader.createCell(4);
				state.setCellType(Cell.CELL_TYPE_STRING);
				state.setCellStyle(cellStyleHeader);
				state.setCellValue("SALDO");
				hoja.autoSizeColumn(4);

				hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 1));
				hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 2, 2));
				hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 3, 3));
				hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 4, 4));
			}

			inicio = inicio + 1;

			if (movementsList != null && (this.movementsList.size() != 0 || !this.movementsList.isEmpty())) {
				for (int f = 0; f < this.movementsList.size(); f++) {
					Row fila = hoja.createRow(f + inicio);
					for (int c = 1; c < 5; c++) {

						Font check = libro.createFont();
						check.setFontHeightInPoints((short)10);
						check.setFontName("Arial");
						check.setBold(true);
						check.setColor(HSSFColor.BLUE.index);

						Cell celda = fila.createCell(c);
						celda.setCellType(Cell.CELL_TYPE_STRING);
						CellStyle cellStyle = libro.createCellStyle();

						cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
						cellStyle.setBorderBottom((short)1);
						cellStyle.setBorderLeft((short)1);
						cellStyle.setBorderRight((short)1);
						cellStyle.setBorderTop((short)1);
						cellStyle.setWrapText(true);

						if (c == 1) {
							String dateData = super.getdateString(this.movementsList.get(f).getMovementDate());
							cellStyle.setFont(check);
							super.createCell(celda, dateData, cellStyle);
							cellSheet.add(celda);
						}
						if (c == 2) {
							super.createCell(celda, this.movementsList.get(f).getMovementConcept(), cellStyle);
							cellSheet.add(celda);
						}
						if (c == 3) {
							super.createCellMoney(celda, this.movementsList.get(f).getMovementValue(), cellStyle);
							cellSheet.add(celda);
						}
						if (c == 4) {
							super.createCellMoney(celda, this.movementsList.get(f).getTotalBalance(), cellStyle);
							cellSheet.add(celda);
						}
						hoja.addMergedRegion(new CellRangeAddress(f, f, 1, 1));
						hoja.addMergedRegion(new CellRangeAddress(f, f, 2, 2));
						hoja.addMergedRegion(new CellRangeAddress(f, f, 3, 3));
						hoja.addMergedRegion(new CellRangeAddress(f, f, 4, 4));
					}
				}

				super.maxSize(cellSheet, hoja, 4);

				inicio = inicio + this.movementsList.size() + 3;

			} else if (movementsList != null && (this.movementsList.size() == 0 || this.movementsList.isEmpty())) {

				Row filaOter = hoja.createRow(inicio);

				Cell celda = filaOter.createCell(1);
				Cell celda1 = filaOter.createCell(2);
				Cell celda2 = filaOter.createCell(3);
				Cell celda3 = filaOter.createCell(4);

				celda.setCellType(Cell.CELL_TYPE_STRING);
				CellStyle cellStyle = libro.createCellStyle();

				cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
				cellStyle.setBorderBottom((short)1);
				cellStyle.setBorderLeft((short)1);
				cellStyle.setBorderRight((short)1);
				cellStyle.setBorderTop((short)1);
				cellStyle.setWrapText(true);

				celda.setCellStyle(cellStyle);
				celda1.setCellStyle(cellStyle);
				celda2.setCellStyle(cellStyle);
				celda3.setCellStyle(cellStyle);
				celda.setCellValue("No hay registros");

				hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 4));

				inicio = inicio + this.movementsList.size() + 3;
			}

			Row filaFooter = hoja.createRow(inicio);
			filaFooter.createCell(1).setCellValue("Cordial saludo,");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 4));

			Font bbvaAde = libro.createFont();
			bbvaAde.setColor(HSSFColor.BLUE.index);

			CellStyle bbvaStyle = libro.createCellStyle();
			bbvaStyle.setFont(bbvaAde);

			inicio = inicio + 1;

			filaFooter = hoja.createRow(inicio);
			Cell bbva = filaFooter.createCell(1);
			bbva.setCellStyle(bbvaStyle);
			bbva.setCellValue("BBVA Adelante");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 4));

			inicio = inicio + 2;

			Font notaFont = libro.createFont();
			notaFont.setBold(true);

			CellStyle cellNotaStyle = libro.createCellStyle();
			cellNotaStyle.setVerticalAlignment(CellStyle.VERTICAL_JUSTIFY);
			cellNotaStyle.setFont(notaFont);

			filaFooter = hoja.createRow(inicio);
			Cell nota = filaFooter.createCell(1);
			nota.setCellStyle(cellNotaStyle);
			nota.setCellValue("Nota: Si no eres el destinatario de este mensaje, por favor comunícate con nosotros con el fin de realizar la actualización correspondiente, al 4010000 en Bogotá, 4938300 en Medellín, 3503500 en Barranquilla, 8892020 en Cali, 6304000 en Bucaramanga o al 01800 912227 desde el resto del país. ");
			filaFooter.setHeight((short)2600);
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 4));

			inicio = inicio + 2;

			CellStyle cellFooterStyle = libro.createCellStyle();
			cellFooterStyle.setVerticalAlignment(CellStyle.VERTICAL_JUSTIFY);

			filaFooter = hoja.createRow(inicio);
			filaFooter.createCell(1).setCellValue("********************* AVISO LEGAL **************************");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 4));

			inicio = inicio + 1;
			filaFooter = hoja.createRow(inicio);
			Cell message = filaFooter.createCell(1);
			message.setCellStyle(cellFooterStyle);
			message.setCellValue("Este mensaje es solamente para la persona a la que va dirigido. Puede contener informacion  confidencial  o  legalmente  protegida.  No  hay  renuncia  a la confidencialidad o privilegio por cualquier transmision mala/erronea. Si usted ha recibido este mensaje por error,  le rogamos que borre de su sistema inmediatamente el mensaje asi como todas sus copias, destruya todas las copias del mismo de su disco duro y notifique al remitente.  No debe,  directa o indirectamente, usar, revelar, distribuir, imprimir o copiar ninguna de las partes de este mensaje si no es usted el destinatario. Cualquier opinion expresada en este mensaje proviene del remitente, excepto cuando el mensaje establezca lo contrario y el remitente este autorizado para establecer que dichas opiniones provienen de  BBVA. Notese que el correo electronico via Internet no permite asegurar ni la confidencialidad de los mensajes que se transmiten ni la correcta recepcion de los mismos. En el caso de que el destinatario de este mensaje no consintiera la utilizacion del correo electronico via Internet, rogamos lo ponga en nuestro conocimiento de manera inmediata.");
			filaFooter.setHeight((short)8000);
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 4));

			inicio = inicio + 2;

			filaFooter = hoja.createRow(inicio);
			filaFooter.createCell(1).setCellValue("**************************  DISCLAIMER**********************");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 4));

			inicio = inicio + 1;

			filaFooter = hoja.createRow(inicio);
			Cell messEng = filaFooter.createCell(1);
			messEng.setCellStyle(cellFooterStyle);
			messEng.setCellValue("This message is intended exclusively for the named person. It may contain confidential, propietary or legally privileged information. No confidentiality or privilege is waived or lost by any mistransmission. If you receive this message in error, please immediately delete it and all copies of it from your system, destroy any hard copies of it and notify the sender. Your must not, directly or indirectly, use, disclose, distribute, print, or copy any part of this message if you are not the intended recipient. Any views expressed in this message are those of the individual sender, except where the message states otherwise and the sender is authorised to state them to be the views of BBVA. Please note that internet e-mail neither guarantees the confidentiality nor the proper receipt of the message sent.If the addressee of this message does not consent to the use of internet e-mail, please communicate it to us immediately.");
			filaFooter.setHeight((short)7300);
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 4));

			inicio = inicio + 1;

			filaFooter = hoja.createRow(inicio);
			filaFooter.createCell(1).setCellValue("************************************************************");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 4));

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

	// Export Pdf
	@Override
	public void exportDocumentPdf() {

		LOGGER.info("iniciando exportar archivo pdf " + "Movimientos" + getSelectedProduct().getProductNumber()
				+ ".pdf");

		rutaMovePdf = "Movimientos" + getSelectedProduct().getProductNumber() + ".pdf";

		try {

			FileOutputStream file = null;

			try {
				file = new FileOutputStream(rutaMovePdf);
			} catch (FileNotFoundException e) {
				LOGGER.info("Excepción no se encuentra el archivo " + RUTA_ICONO_BBVA + "------" + e.getMessage());
			}

			headerController.setLastDownload(rutaMovePdf);
			Document document = new Document();

			PdfWriter.getInstance(document, file).setInitialLeading(20);

			document.open();

			try {
				Image foto = Image.getInstance(RUTA_ICONO_BBVA);
				foto.scaleToFit(100, 100);
				document.add(foto);
			} catch (Exception e) {
				LOGGER.info("Excepción no se encuentra el archivo de imagen" + e.getMessage());
			}

			Paragraph initial = new Paragraph("Estimado(a) cliente: ",
					FontFactory.getFont("arial", 12, BaseColor.BLACK));
			initial.setAlignment(Element.ALIGN_LEFT);
			initial.setSpacingBefore(20);

			document.add(initial);

			PdfPTable tabla = new PdfPTable(4);
			com.itextpdf.text.Font font = new com.itextpdf.text.Font(FontFamily.HELVETICA, 10,
					com.itextpdf.text.Font.BOLD, BaseColor.BLACK);
			com.itextpdf.text.Font fontNormal = new com.itextpdf.text.Font(FontFamily.HELVETICA, 10,
					com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
			com.itextpdf.text.Font fontBlue = new com.itextpdf.text.Font(FontFamily.HELVETICA, 10,
					com.itextpdf.text.Font.BOLD, new BaseColor(0, 80, 152));
			tabla.setSpacingBefore(20);
			tabla.setSpacingAfter(20);

			PdfPCell dateTitle = new PdfPCell(new Phrase("FECHA", font));
			dateTitle.setBackgroundColor(new BaseColor(229, 229, 229));
			dateTitle.setHorizontalAlignment(Element.ALIGN_CENTER);
			dateTitle.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tabla.addCell(dateTitle);

			PdfPCell concept = new PdfPCell(new Phrase("CONCEPTO", font));
			concept.setBackgroundColor(new BaseColor(229, 229, 229));
			concept.setHorizontalAlignment(Element.ALIGN_CENTER);
			concept.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tabla.addCell(concept);

			PdfPCell value = new PdfPCell(new Phrase("VALOR", font));
			value.setBackgroundColor(new BaseColor(229, 229, 229));
			value.setHorizontalAlignment(Element.ALIGN_CENTER);
			value.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tabla.addCell(value);

			PdfPCell sald = new PdfPCell(new Phrase("SALDO", font));
			sald.setBackgroundColor(new BaseColor(229, 229, 229));
			sald.setHorizontalAlignment(Element.ALIGN_CENTER);
			sald.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tabla.addCell(sald);

			if (movementsList != null && movementsList.size() != 0) {
				for (int i = 0; i < movementsList.size(); i++) {

					String date = super.getdateString(movementsList.get(i).getMovementDate());
					PdfPCell dateData = new PdfPCell(new Phrase(date, fontBlue));
					dateData.setHorizontalAlignment(Element.ALIGN_CENTER);
					dateData.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tabla.addCell(dateData);

					PdfPCell conceptData = new PdfPCell(new Phrase(movementsList.get(i).getMovementConcept(),
							fontNormal));
					conceptData.setHorizontalAlignment(Element.ALIGN_CENTER);
					conceptData.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tabla.addCell(conceptData);

					if (movementsList.get(i).getMovementValue() != null) {

						PdfPCell valueData = new PdfPCell(new Phrase(
								movementsList.get(i).getMovementValue().toString(), font));
						valueData.setHorizontalAlignment(Element.ALIGN_CENTER);
						valueData.setVerticalAlignment(Element.ALIGN_MIDDLE);
						tabla.addCell(valueData);

					} else {
						tabla.addCell(" ");
					}

					if (movementsList.get(i).getTotalBalance() != null) {

						PdfPCell balanceData = new PdfPCell(new Phrase(movementsList.get(i).getTotalBalance()
								.toString(), font));
						balanceData.setHorizontalAlignment(Element.ALIGN_CENTER);
						balanceData.setVerticalAlignment(Element.ALIGN_MIDDLE);
						tabla.addCell(balanceData);

					} else {
						tabla.addCell(" ");
					}
				}
			} else if (movementsList == null || movementsList.size() == 0) {

				PdfPCell nonee = new PdfPCell(new Phrase("No hay registros", font));
				nonee.setHorizontalAlignment(Element.ALIGN_CENTER);
				nonee.setVerticalAlignment(Element.ALIGN_MIDDLE);
				nonee.setBorder(Rectangle.BOX);
				nonee.setColspan(4);
				tabla.addCell(nonee);

			}

			document.add(tabla);

			Paragraph att = new Paragraph("Cordial saludo, ", FontFactory.getFont("arial", 12, BaseColor.BLACK));
			att.setAlignment(Element.ALIGN_JUSTIFIED);
			att.setSpacingBefore(20);
			document.add(att);

			Paragraph bbva = new Paragraph("BBVA Adelante ",
					FontFactory.getFont("arial", 12, new BaseColor(0, 80, 152)));
			bbva.setAlignment(Element.ALIGN_JUSTIFIED);
			bbva.setSpacingAfter(20);
			document.add(bbva);

			Paragraph note = new Paragraph(
					"Nota: Si no eres el destinatario de este mensaje, por favor comunícate con nosotros con el fin de realizar la actualización correspondiente, al 4010000 en Bogotá, 4938300 en Medellín, 3503500 en Barranquilla, 8892020 en Cali, 6304000 en Bucaramanga o al 01800 912227 desde el resto del país. ",
					FontFactory.getFont("arial", 9, com.itextpdf.text.Font.BOLD));
			note.setAlignment(Element.ALIGN_JUSTIFIED);
			note.setSpacingAfter(20);
			document.add(note);

			String ast = "*********************";

			Paragraph post = new Paragraph(ast + " AVISO LEGAL " + ast,
					FontFactory.getFont("arial", 9, BaseColor.BLACK));
			post.setAlignment(Element.ALIGN_LEFT);
			document.add(post);

			Paragraph postCont = new Paragraph(
					"Este mensaje es solamente para la persona a la que va dirigido. Puede contener informacion  confidencial  o  legalmente  protegida.  No  hay  renuncia  a la confidencialidad o privilegio por cualquier transmision mala/erronea. Si usted ha recibido este mensaje por error,  le rogamos que borre de su sistema inmediatamente el mensaje asi como todas sus copias, destruya todas las copias del mismo de su disco duro y notifique al remitente.  No debe,  directa o indirectamente, usar, revelar, distribuir, imprimir o copiar ninguna de las partes de este mensaje si no es usted el destinatario. Cualquier opinion expresada en este mensaje proviene del remitente, excepto cuando el mensaje establezca lo contrario y el remitente este autorizado para establecer que dichas opiniones provienen de  BBVA. Notese que el correo electronico via Internet no permite asegurar ni la confidencialidad de los mensajes que se transmiten ni la correcta recepcion de los mismos. En el caso de que el destinatario de este mensaje no consintiera la utilizacion del correo electronico via Internet, rogamos lo ponga en nuestro conocimiento de manera inmediata.",
					FontFactory.getFont("arial", 9, BaseColor.BLACK));
			postCont.setAlignment(Element.ALIGN_JUSTIFIED);
			postCont.setSpacingAfter(20);
			document.add(postCont);

			Paragraph post2 = new Paragraph(ast + " DISCLAIMER " + ast,
					FontFactory.getFont("arial", 9, BaseColor.BLACK));
			post2.setAlignment(Element.ALIGN_LEFT);
			document.add(post2);

			Paragraph post2Content = new Paragraph(
					"This message is intended exclusively for the named person. It may contain confidential, propietary or legally privileged information. No confidentiality or privilege is waived or lost by any mistransmission. If you receive this message in error, please immediately delete it and all copies of it from your system, destroy any hard copies of it and notify the sender. Your must not, directly or indirectly, use, disclose, distribute, print, or copy any part of this message if you are not the intended recipient. Any views expressed in this message are those of the individual sender, except where the message states otherwise and the sender is authorised to state them to be the views of BBVA. Please note that internet e-mail neither guarantees the confidentiality nor the proper receipt of the message sent. If the addressee of this message does not consent to the use of internet e-mail, please communicate it to us immediately.",
					FontFactory.getFont("arial", 9, BaseColor.BLACK));
			post2Content.setAlignment(Element.ALIGN_JUSTIFIED);
			post2Content.setSpacingAfter(20);
			document.add(post2Content);

			Paragraph asty = new Paragraph(ast, FontFactory.getFont("arial", 9, BaseColor.BLACK));
			asty.setAlignment(Element.ALIGN_LEFT);
			asty.setSpacingAfter(20);
			document.add(asty);

			document.close();

		} catch (DocumentException e) {
			LOGGER.info("Excepción no se encuentra el archivo" + e.getMessage());
		}
	}

	// Export Pdf
	@Override
	public void exportDocumentDetailPdf() {

		if (movementDetail != null) {
			rutaMoveDetailPdf = "DetailMove" + this.movementDetail.getId() + ".pdf";
			LOGGER.info("iniciando exportar archivo pdf " + "DetailMove" + this.movementDetail.getId() + ".pdf");
		} else {
			rutaMoveDetailPdf = "DetailMoveEmpty.pdf";
		}
		headerController.setLastDownload(rutaMoveDetailPdf);

		try {

			FileOutputStream file = null;

			try {
				file = new FileOutputStream(rutaMoveDetailPdf);
			} catch (FileNotFoundException e) {
				LOGGER.info("Excepción no se encuentra el archivo" + e.getMessage());
			}

			Document document = new Document();

			PdfWriter.getInstance(document, file).setInitialLeading(20);

			document.open();

			try {
				Image foto = Image.getInstance(RUTA_ICONO_BBVA);
				foto.scaleToFit(100, 100);
				document.add(foto);
			} catch (Exception e) {
				LOGGER.info("Excepción no se encuentra el archivo de imagen" + e.getMessage());
			}

			Paragraph initial = new Paragraph("Estimado(a) cliente: ",
					FontFactory.getFont("arial", 12, BaseColor.BLACK));
			initial.setAlignment(Element.ALIGN_LEFT);
			initial.setSpacingBefore(20);

			document.add(initial);

			com.itextpdf.text.Font font = new com.itextpdf.text.Font(FontFamily.HELVETICA, 10,
					com.itextpdf.text.Font.BOLD, new BaseColor(102, 102, 102));
			com.itextpdf.text.Font fontNormal = new com.itextpdf.text.Font(FontFamily.HELVETICA, 10,
					com.itextpdf.text.Font.NORMAL, new BaseColor(102, 102, 102));
			com.itextpdf.text.Font fontBlue = new com.itextpdf.text.Font(FontFamily.HELVETICA, 10,
					com.itextpdf.text.Font.BOLD, new BaseColor(0, 80, 152));

			PdfPTable header = new PdfPTable(4);

			header.setSpacingBefore(20);
			header.setSpacingAfter(20);
			header.setHorizontalAlignment(Element.ALIGN_LEFT);
			header.getDefaultCell().setBorder(0);

			PdfPCell datesP = new PdfPCell(new Phrase("Fecha", fontBlue));
			datesP.setHorizontalAlignment(Element.ALIGN_LEFT);
			datesP.setVerticalAlignment(Element.ALIGN_MIDDLE);
			datesP.setBorder(0);
			header.addCell(datesP);

			PdfPCell concep = new PdfPCell(new Phrase("Concepto", fontBlue));
			concep.setHorizontalAlignment(Element.ALIGN_LEFT);
			concep.setVerticalAlignment(Element.ALIGN_MIDDLE);
			concep.setBorder(0);
			header.addCell(concep);

			PdfPCell value = new PdfPCell(new Phrase("Valor", fontBlue));
			value.setHorizontalAlignment(Element.ALIGN_LEFT);
			value.setVerticalAlignment(Element.ALIGN_MIDDLE);
			value.setBorder(0);
			header.addCell(value);

			PdfPCell sald = new PdfPCell(new Phrase("Saldo", fontBlue));
			sald.setHorizontalAlignment(Element.ALIGN_LEFT);
			sald.setVerticalAlignment(Element.ALIGN_MIDDLE);
			sald.setBorder(0);
			header.addCell(sald);

			String date = super.getdateString(movementAction.getMovementDate());
			PdfPCell dataDates = new PdfPCell(new Phrase(date, fontNormal));
			dataDates.setHorizontalAlignment(Element.ALIGN_LEFT);
			dataDates.setVerticalAlignment(Element.ALIGN_MIDDLE);
			dataDates.setBorder(0);
			header.addCell(dataDates);

			PdfPCell dataConcep = new PdfPCell(new Phrase(movementAction.getMovementConcept(), fontNormal));
			dataConcep.setHorizontalAlignment(Element.ALIGN_LEFT);
			dataConcep.setVerticalAlignment(Element.ALIGN_MIDDLE);
			dataConcep.setBorder(0);
			header.addCell(dataConcep);
			if (movementDetail != null) {
				if (movementAction.getMovementValue() != null) {
					PdfPCell datavalue = new PdfPCell(new Phrase(movementAction.getMovementValue().toString(),
							fontNormal));
					datavalue.setHorizontalAlignment(Element.ALIGN_LEFT);
					datavalue.setVerticalAlignment(Element.ALIGN_MIDDLE);
					datavalue.setBorder(0);
					header.addCell(datavalue);
				} else {
					header.addCell(" ");
				}

				if (movementAction.getTotalBalance() != null) {
					PdfPCell dataBalance = new PdfPCell(new Phrase(movementAction.getTotalBalance().toString(),
							fontNormal));
					dataBalance.setHorizontalAlignment(Element.ALIGN_LEFT);
					dataBalance.setVerticalAlignment(Element.ALIGN_MIDDLE);
					dataBalance.setBorder(0);
					header.addCell(dataBalance);
				} else {
					header.addCell(" ");
				}

				document.add(header);

				Paragraph title = new Paragraph("Información del movimiento", FontFactory.getFont("helvetica", 11,
						new BaseColor(51, 51, 51)));
				title.setSpacingBefore(20);

				document.add(title);

				PdfPTable tabla = new PdfPTable(2);

				tabla.setSpacingBefore(20);
				tabla.setSpacingAfter(20);
				tabla.setHorizontalAlignment(Element.ALIGN_LEFT);
				tabla.getDefaultCell().setBorder(0);

				PdfPCell moveNumber = new PdfPCell(new Phrase("N° Movimiento", font));
				moveNumber.setHorizontalAlignment(Element.ALIGN_LEFT);
				moveNumber.setVerticalAlignment(Element.ALIGN_MIDDLE);
				moveNumber.setBorder(0);
				tabla.addCell(moveNumber);

				PdfPCell idMove = new PdfPCell(new Phrase(this.movementDetail.getId(), fontNormal));
				idMove.setHorizontalAlignment(Element.ALIGN_LEFT);
				idMove.setVerticalAlignment(Element.ALIGN_MIDDLE);
				idMove.setBorder(0);
				tabla.addCell(idMove);

				PdfPCell operDate = new PdfPCell(new Phrase("Fecha de operación", font));
				operDate.setHorizontalAlignment(Element.ALIGN_LEFT);
				operDate.setVerticalAlignment(Element.ALIGN_MIDDLE);
				operDate.setBorder(0);
				tabla.addCell(operDate);

				if (movementDetail.getOperationCode() != null) {
					PdfPCell operDat = new PdfPCell(new Phrase(
							this.movementDetail.getOperationCode().replace("/", "-"), fontNormal));
					operDat.setHorizontalAlignment(Element.ALIGN_LEFT);
					operDat.setVerticalAlignment(Element.ALIGN_MIDDLE);
					operDat.setBorder(0);
					tabla.addCell(operDat);
				} else {
					tabla.addCell(" ");
				}

				PdfPCell dateValue = new PdfPCell(new Phrase("Fecha valor", font));
				dateValue.setHorizontalAlignment(Element.ALIGN_LEFT);
				dateValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
				dateValue.setBorder(0);
				tabla.addCell(dateValue);

				String daVD = super.getdateString(this.movementDetail.getTransactionDate());
				PdfPCell dateVData = new PdfPCell(new Phrase(daVD, fontNormal));
				dateVData.setHorizontalAlignment(Element.ALIGN_LEFT);
				dateVData.setVerticalAlignment(Element.ALIGN_MIDDLE);
				dateVData.setBorder(0);
				tabla.addCell(dateVData);

				PdfPCell hourValue = new PdfPCell(new Phrase("Hora operación", font));
				hourValue.setHorizontalAlignment(Element.ALIGN_LEFT);
				hourValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
				hourValue.setBorder(0);
				tabla.addCell(hourValue);

				String horesdDta = super.getdateString(this.movementDetail.getOperationHour());
				PdfPCell horeDta = new PdfPCell(new Phrase(horesdDta, fontNormal));
				horeDta.setHorizontalAlignment(Element.ALIGN_LEFT);
				horeDta.setVerticalAlignment(Element.ALIGN_MIDDLE);
				horeDta.setBorder(0);
				tabla.addCell(horeDta);

				PdfPCell valueDta = new PdfPCell(new Phrase("Valor", font));
				valueDta.setHorizontalAlignment(Element.ALIGN_LEFT);
				valueDta.setVerticalAlignment(Element.ALIGN_MIDDLE);
				valueDta.setBorder(0);
				tabla.addCell(valueDta);

				if (movementDetail.getOperationValue() != null) {
					PdfPCell valeuDt = new PdfPCell(new Phrase(this.movementDetail.getOperationValue().toString(),
							fontNormal));
					valeuDt.setHorizontalAlignment(Element.ALIGN_LEFT);
					valeuDt.setVerticalAlignment(Element.ALIGN_MIDDLE);
					valeuDt.setBorder(0);
					tabla.addCell(valeuDt);
				} else {
					tabla.addCell(" ");
				}

				PdfPCell saAfter = new PdfPCell(new Phrase("Saldo después del movimiento", font));
				saAfter.setHorizontalAlignment(Element.ALIGN_LEFT);
				saAfter.setVerticalAlignment(Element.ALIGN_MIDDLE);
				saAfter.setBorder(0);
				tabla.addCell(saAfter);

				if (movementDetail.getValueslope() != null) {
					PdfPCell saldaDat = new PdfPCell(new Phrase(this.movementDetail.getValueslope().toString(),
							fontNormal));
					saldaDat.setHorizontalAlignment(Element.ALIGN_LEFT);
					saldaDat.setVerticalAlignment(Element.ALIGN_MIDDLE);
					saldaDat.setBorder(0);
					tabla.addCell(saldaDat);
				} else {
					tabla.addCell(" ");
				}

				PdfPCell codOpera = new PdfPCell(new Phrase("Código de operación", font));
				codOpera.setHorizontalAlignment(Element.ALIGN_LEFT);
				codOpera.setVerticalAlignment(Element.ALIGN_MIDDLE);
				codOpera.setBorder(0);
				tabla.addCell(codOpera);

				PdfPCell codDOpe = new PdfPCell(new Phrase(this.movementDetail.getOperationCode(), fontNormal));
				codDOpe.setHorizontalAlignment(Element.ALIGN_LEFT);
				codDOpe.setVerticalAlignment(Element.ALIGN_MIDDLE);
				codDOpe.setBorder(0);
				tabla.addCell(codDOpe);

				PdfPCell descripOper = new PdfPCell(new Phrase("Descripción de la operación", font));
				descripOper.setHorizontalAlignment(Element.ALIGN_LEFT);
				descripOper.setVerticalAlignment(Element.ALIGN_MIDDLE);
				descripOper.setBorder(0);
				tabla.addCell(descripOper);

				PdfPCell destDtaOpe = new PdfPCell(
						new Phrase(this.movementDetail.getOperationDescription(), fontNormal));
				destDtaOpe.setHorizontalAlignment(Element.ALIGN_LEFT);
				destDtaOpe.setVerticalAlignment(Element.ALIGN_MIDDLE);
				destDtaOpe.setBorder(0);
				tabla.addCell(destDtaOpe);

				PdfPCell place = new PdfPCell(new Phrase("Plaza", font));
				place.setHorizontalAlignment(Element.ALIGN_LEFT);
				place.setVerticalAlignment(Element.ALIGN_MIDDLE);
				place.setBorder(0);
				tabla.addCell(place);

				PdfPCell placeDta = new PdfPCell(new Phrase(this.movementDetail.getPlaza().getPostalAddress(),
						fontNormal));
				placeDta.setHorizontalAlignment(Element.ALIGN_LEFT);
				placeDta.setVerticalAlignment(Element.ALIGN_MIDDLE);
				placeDta.setBorder(0);
				tabla.addCell(placeDta);

				PdfPCell cenMove = new PdfPCell(new Phrase("Centro origen del movimiento", font));
				cenMove.setHorizontalAlignment(Element.ALIGN_LEFT);
				cenMove.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cenMove.setBorder(0);
				tabla.addCell(cenMove);

				PdfPCell oriDtaCent = new PdfPCell(
						new Phrase(this.movementDetail.getOriginCenterMovement(), fontNormal));
				oriDtaCent.setHorizontalAlignment(Element.ALIGN_LEFT);
				oriDtaCent.setVerticalAlignment(Element.ALIGN_MIDDLE);
				oriDtaCent.setBorder(0);
				tabla.addCell(oriDtaCent);

				if (movementDetail.getState() != null) {
					PdfPCell stateMove = new PdfPCell(new Phrase("Estado", font));
					stateMove.setHorizontalAlignment(Element.ALIGN_LEFT);
					stateMove.setVerticalAlignment(Element.ALIGN_MIDDLE);
					stateMove.setBorder(0);
					tabla.addCell(stateMove);

					PdfPCell StateCDat = new PdfPCell(new Phrase(this.movementDetail.getState(), fontNormal));
					StateCDat.setHorizontalAlignment(Element.ALIGN_LEFT);
					StateCDat.setVerticalAlignment(Element.ALIGN_MIDDLE);
					StateCDat.setBorder(0);
					tabla.addCell(StateCDat);
				}

				document.add(tabla);

				Paragraph att = new Paragraph("Cordial saludo, ", FontFactory.getFont("arial", 12, BaseColor.BLACK));
				att.setAlignment(Element.ALIGN_JUSTIFIED);
				att.setSpacingBefore(20);
				document.add(att);

				Paragraph bbva = new Paragraph("BBVA Adelante ", FontFactory.getFont("arial", 12, new BaseColor(0, 80,
						152)));
				bbva.setAlignment(Element.ALIGN_JUSTIFIED);
				bbva.setSpacingAfter(20);
				document.add(bbva);
			}
			Paragraph note = new Paragraph(
					"Nota: Si no eres el destinatario de este mensaje, por favor comunícate con nosotros con el fin de realizar la actualización correspondiente, al 4010000 en Bogotá, 4938300 en Medellín, 3503500 en Barranquilla, 8892020 en Cali, 6304000 en Bucaramanga o al 01800 912227 desde el resto del país. ",
					FontFactory.getFont("arial", 9, com.itextpdf.text.Font.BOLD));
			note.setAlignment(Element.ALIGN_JUSTIFIED);
			note.setSpacingAfter(20);
			document.add(note);

			String ast = "*********************";

			Paragraph post = new Paragraph(ast + " AVISO LEGAL " + ast,
					FontFactory.getFont("arial", 9, BaseColor.BLACK));
			post.setAlignment(Element.ALIGN_LEFT);
			document.add(post);

			Paragraph postCont = new Paragraph(
					"Este mensaje es solamente para la persona a la que va dirigido. Puede contener informacion  confidencial  o  legalmente  protegida.  No  hay  renuncia  a la confidencialidad o privilegio por cualquier transmision mala/erronea. Si usted ha recibido este mensaje por error,  le rogamos que borre de su sistema inmediatamente el mensaje asi como todas sus copias, destruya todas las copias del mismo de su disco duro y notifique al remitente.  No debe,  directa o indirectamente, usar, revelar, distribuir, imprimir o copiar ninguna de las partes de este mensaje si no es usted el destinatario. Cualquier opinion expresada en este mensaje proviene del remitente, excepto cuando el mensaje establezca lo contrario y el remitente este autorizado para establecer que dichas opiniones provienen de  BBVA. Notese que el correo electronico via Internet no permite asegurar ni la confidencialidad de los mensajes que se transmiten ni la correcta recepcion de los mismos. En el caso de que el destinatario de este mensaje no consintiera la utilizacion del correo electronico via Internet, rogamos lo ponga en nuestro conocimiento de manera inmediata.",
					FontFactory.getFont("arial", 9, BaseColor.BLACK));
			postCont.setAlignment(Element.ALIGN_JUSTIFIED);
			postCont.setSpacingAfter(20);
			document.add(postCont);

			Paragraph post2 = new Paragraph(ast + " DISCLAIMER " + ast,
					FontFactory.getFont("arial", 9, BaseColor.BLACK));
			post2.setAlignment(Element.ALIGN_LEFT);
			document.add(post2);

			Paragraph post2Content = new Paragraph(
					"This message is intended exclusively for the named person. It may contain confidential, propietary or legally privileged information. No confidentiality or privilege is waived or lost by any mistransmission. If you receive this message in error, please immediately delete it and all copies of it from your system, destroy any hard copies of it and notify the sender. Your must not, directly or indirectly, use, disclose, distribute, print, or copy any part of this message if you are not the intended recipient. Any views expressed in this message are those of the individual sender, except where the message states otherwise and the sender is authorised to state them to be the views of BBVA. Please note that internet e-mail neither guarantees the confidentiality nor the proper receipt of the message sent. If the addressee of this message does not consent to the use of internet e-mail, please communicate it to us immediately.",
					FontFactory.getFont("arial", 9, BaseColor.BLACK));
			post2Content.setAlignment(Element.ALIGN_JUSTIFIED);
			post2Content.setSpacingAfter(20);
			document.add(post2Content);

			Paragraph asty = new Paragraph(ast, FontFactory.getFont("arial", 9, BaseColor.BLACK));
			asty.setAlignment(Element.ALIGN_LEFT);
			asty.setSpacingAfter(20);
			document.add(asty);

			document.close();

		} catch (DocumentException e) {
			LOGGER.info("Excepción no se encuentra el archivo" + e.getMessage());
		}
	}

	@Override
	public void printMoves() {
		printFile("Movements");
	}

	@Override
	public void printMoveDetail() {
		printFile("DetailMovement");
	}

	public void printFile(String typeDoc) {
		File pdfFile = null;
		if (typeDoc.equals("Movements")) {
			pdfFile = new File("Movimientos" + getSelectedProduct().getProductNumber() + ".pdf");
		}
		if (typeDoc.equals("DetailMovement")) {
			pdfFile = new File("DetailMove" + this.movementDetail.getId() + ".pdf");
		}
		LOGGER.info("printFile ruta de archivo " + pdfFile.getAbsolutePath());
		if (pdfFile.exists()) {
			if (pdfFile.delete()) {
				LOGGER.info("borró el archivo " + pdfFile.getAbsolutePath());
				if (typeDoc.equals("Movements")) {
					exportDocumentPdf();
				}
				if (typeDoc.equals("DetailMovement")) {
					exportDocumentDetailPdf();
				}
			} else
				LOGGER.info("No lo borró");
		} else {
			LOGGER.info("crea el archivo " + pdfFile.getAbsolutePath());
			if (typeDoc.equals("Movements")) {
				exportDocumentPdf();
			}
			if (typeDoc.equals("DetailMovement")) {
				exportDocumentDetailPdf();
			}

		}

		FileInputStream inputFile = null;
		try {
			inputFile = new FileInputStream(pdfFile.getPath());
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

		PrinterJob printerJob = PrinterJob.getPrinterJob();
		if (printerJob.printDialog()) {
			DocPrintJob docprintJob = defaultPrintService.createPrintJob();
			try {
				docprintJob.print(document, attributeSet);

			} catch (Exception e) {
				LOGGER.info("Erro al imprimir " + e.getMessage());
			}
		}

		try {
			inputFile.close();
		} catch (IOException e) {
			LOGGER.info("Erro al cerrar el archivo de impresión " + e.getMessage());
		}
		/*
		 * String s = System.getProperty("os.name").toLowerCase(); if (s.contains("win")) { createCommand("explorer", "%s",
		 * pdfFile.getAbsolutePath()); } if (s.contains("mac")) { createCommand("open", "%s", pdfFile.getAbsolutePath()); }
		 * if (s.contains("linux") || s.contains("unix")) { createCommand("kde-open", "%s", pdfFile.getAbsolutePath());
		 * createCommand("gnome-open", "%s", pdfFile.getAbsolutePath()); createCommand("xdg-open", "%s",
		 * pdfFile.getAbsolutePath()); }
		 */

	}

	private boolean createCommand(String command, String args, String file) {

		LOGGER.info("Probando comando exec:\n   cmd = " + command + "\n   args = " + args + "\n   %s = " + file);

		List<String> parts = new ArrayList<String>();
		parts.add(command);

		if (args != null) {
			for (String s : args.split(" ")) {
				s = String.format(s, file);
				parts.add(s.trim());
			}
		}

		String[] sParts = parts.toArray(new String[parts.size()]);

		try {
			Process p = Runtime.getRuntime().exec(sParts);
			LOGGER.info(" Proceso input " + p.toString());
			if (p == null) return false;

			LOGGER.info("Inicia la terminación de proceso");
			try {
				int retval = p.exitValue();
				if (retval == 0) {
					LOGGER.info("Proceso terminó inmediatamente.");
					return false;
				} else {
					LOGGER.info("Proceso colapso");
					return false;
				}
			} catch (IllegalThreadStateException itse) {
				LOGGER.info("Ruta archivo*** " + file + "***Proceso esta corriendo mensaje " + itse.getMessage()
						+ "---causa---" + itse.getCause());
				return true;
			}
		} catch (IOException e) {
			LOGGER.info("Error ejecutando el comando Mensaje " + e.getMessage() + " Ruta archivo*** " + file
					+ "*** Causa" + e.getCause());
			return false;
		}
	}

	@Override
	public void sendMail() {
		try {

			Properties props = new Properties();
			props.put("mail.smtp.auth", "false");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.user", REMITENTE);
			props.put("mail.smtp.host", IP_IRONPORT);
			props.put("mail.smtp.port", PUERTO_IRONPORT);

			Session session = Session.getDefaultInstance(props, null);
			BodyPart header = new MimeBodyPart();
			String htmlText = "<img src=\"https://ci3.googleusercontent.com/proxy/riFpqgLCyTit6KJRJ18o9l7IUkTjZEPxeh0gj_-ghcRMq5l5tJu-OyAExex95MjbTbd4wCqTGQ-tkooIlpHeuP5CR_rV4XThdoA8dA=s0-d-e1-ft#https://www.bbva.com.co/documents/10180/84494/bbva.gif\">";
			header.setContent(htmlText, "text/html");

			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(header);

			BodyPart content = new MimeBodyPart();
			String htmlHeader = "<br></br><br></br><strong>Estimado(a) cliente: </strong><br></br><br></br>";

			String htmlTable = "<table width=100% rules=\"all\" border=\"1\"><thead><tr role=\"row\" style=\"background-color: gainsboro;\"><th role=\"columnheader\" tabindex=\"0\"><span >FECHA</span><span></span></th><th role=\"columnheader\" tabindex=\"0\"><span >CONCEPTO</span><span></span></th><th role=\"columnheader\" tabindex=\"0\"><span >VALOR</span><span ></span></th><th role=\"columnheader\" tabindex=\"0\"><span >SALDO</span><span ></span></th></tr></thead>";
			for (int i = 0; i < this.movementsList.size(); i++) {
				String value = "";
				String balance = "";

				if (this.movementsList.get(i).getMovementValue() != null) {
					value = this.movementsList.get(i).getMovementValue().toString();
				}

				if (this.movementsList.get(i).getTotalBalance() != null) {
					balance = this.movementsList.get(i).getTotalBalance().toString();
				}

				htmlTable += "<tr><th role=\"gridcell\" tabindex=\"0\"><span style=\"color:blue\">"
						+ super.getdateString(this.movementsList.get(i).getMovementDate())
						+ "</span><span></span></th><th role=\"gridcell\" tabindex=\"0\"><span style=\"font-weight:normal\">"
						+ this.movementsList.get(i).getMovementConcept()
						+ "</span><span></span></th><th role=\"gridcell\" tabindex=\"0\"><span >" + value
						+ "</span><span ></span></th><th role=\"gridcell\" tabindex=\"0\"><span >" + balance
						+ "</span><span ></span></th></tr>";
			}

			htmlTable += "</table>";

			String htmlContent = "<br></br><br></br><div align=\"justify\" style=\"font-weight:bold;width:80%;font-size:90%;border-spacing:2px;border-collapse:separate\">Nota: Si no eres el destinatario de este mensaje, por favor comunícate con nosotros con el fin de realizar la actualización correspondiente, al 4010000 en Bogotá, 4938300 en Medellín, 3503500 en Barranquilla, 8892020 en Cali, 6304000 en Bucaramanga o al 01800 912227 desde el resto del país.</div>";
			String htmlFooter = "<br></br><br></br>********************* AVISO LEGAL **************************<br></br>";
			htmlFooter += "Este mensaje es solamente para la persona a la que va dirigido. Puede contener informacion  confidencial  o  legalmente  protegida.  No  hay  renuncia  a la confidencialidad o privilegio por cualquier transmision mala/erronea. Si usted ha recibido este mensaje por error,  le rogamos que borre de su sistema inmediatamente el mensaje asi como todas sus copias, destruya todas las copias del mismo de su disco duro y notifique al remitente.  No debe,  directa o indirectamente, usar, revelar, distribuir, imprimir o copiar ninguna de las partes de este mensaje si no es usted el destinatario. Cualquier opinion expresada en este mensaje proviene del remitente, excepto cuando el mensaje establezca lo contrario y el remitente este autorizado para establecer que dichas opiniones provienen de  BBVA. Notese que el correo electronico via Internet no permite asegurar ni la confidencialidad de los mensajes que se transmiten ni la correcta recepcion de los mismos. En el caso de que el destinatario de este mensaje no consintiera la utilizacion del correo electronico via Internet, rogamos lo ponga en nuestro conocimiento de manera inmediata.";
			htmlFooter += "<br></br><br></br>**************************  DISCLAIMER**********************<br></br>";
			htmlFooter += "This message is intended exclusively for the named person. It may contain confidential, propietary or legally privileged information. No confidentiality or privilege is waived or lost by any mistransmission. If you receive this message in error, please immediately delete it and all copies of it from your system, destroy any hard copies of it and notify the sender. Your must not, directly or indirectly, use, disclose, distribute, print, or copy any part of this message if you are not the intended recipient. Any views expressed in this message are those of the individual sender, except where the message states otherwise and the sender is authorised to state them to be the views of BBVA. Please note that internet e-mail neither guarantees the confidentiality nor the proper receipt of the message sent.If the addressee of this message does not consent to the use of internet e-mail, please communicate it to us immediately.";
			htmlFooter += "<br></br><br></br>************************************************************<br></br>";

			content.setContent(htmlHeader + htmlTable + htmlContent + htmlFooter, "text/html");

			multiParte.addBodyPart(content);

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(REMITENTE));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("luferupa@gmail.com"));
			message.setSubject("Movimientos");
			message.setContent(multiParte);

			Transport t = session.getTransport("smtp");
			t.connect();
			// t.connect("nerlyzaa@gmail.com", "prueba");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		} catch (Exception e) {
			LOGGER.info("Error enviando mail " + e.getMessage());
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage("movementDetail", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"No es posible enviar el correo electrónico, por favor intente más tarde"));
		}
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

	public StreamedContent getExportExcel() {
		exportDocumentExcel();
		InputStream stream;
		try {
			stream = new BufferedInputStream(new FileInputStream(rutaMoveExcel));
			exportExcel = new DefaultStreamedContent(stream, "application/xls", rutaMoveExcel);
		} catch (FileNotFoundException e) {
			LOGGER.info("Error al descargar el Excel " + e.getMessage());
		}

		return exportExcel;
	}

	public void setExportExcel(StreamedContent exportExcel) {
		this.exportExcel = exportExcel;
	}

	/**
	 * @return the exportPdf
	 */
	public StreamedContent getExportPdf() {
		exportDocumentPdf();
		InputStream stream;
		try {
			stream = new BufferedInputStream(new FileInputStream(rutaMovePdf));
			exportPdf = new DefaultStreamedContent(stream, "application/pdf", rutaMovePdf);
		} catch (FileNotFoundException e) {
			LOGGER.info("Error al descargar el pdf " + e.getMessage());
		}
		return exportPdf;
	}

	/**
	 * @param exportPdf the exportPdf to set
	 */
	public void setExportPdf(StreamedContent exportPdf) {
		this.exportPdf = exportPdf;
	}

	/**
	 * @return the exportPdf
	 */
	public StreamedContent getExportDetailPdf() {
		exportDocumentDetailPdf();
		InputStream stream;
		try {
			stream = new BufferedInputStream(new FileInputStream(rutaMoveDetailPdf));
			exportDetailPdf = new DefaultStreamedContent(stream, "application/pdf", rutaMoveDetailPdf);
		} catch (FileNotFoundException e) {
			LOGGER.info("Error al descargar el pdf " + e.getMessage());
		}
		return exportDetailPdf;
	}

	/**
	 * @param exportPdf the exportPdf to set
	 */
	public void setExportDetailPdf(StreamedContent exportDetailPdf) {
		this.exportDetailPdf = exportDetailPdf;
	}

	public List<MultiValueGroup> getConceptMovements() {
		return conceptMovements;
	}

	public void setConceptMovements(List<MultiValueGroup> conceptMovements) {
		this.conceptMovements = conceptMovements;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean statusMovement() {
		if (movementCriteria.getMovement() != null) {
			return false;
		} else {
			return true;
		}
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getStatusLabel() {
		return statusLabel;
	}

	public void setStatusLabel(String statusLabel) {
		this.statusLabel = statusLabel;
	}

	/**
	 * @return the movementAction
	 */
	public MovementDto getMovementAction() {
		return movementAction;
	}

	/**
	 * @param movementAction the movementAction to set
	 */
	public void setMovementAction(MovementDto movementAction) {
		this.movementAction = movementAction;
	}

	public List<MovementDto> getMovementsListGen() {
		return movementsListGen;
	}

	public void setMovementsListGen(List<MovementDto> movementsListGen) {
		this.movementsListGen = movementsListGen;
	}

}