package com.bbva.net.front.controller.impl;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
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

	private String sinceText, toText, selectDate = StringUtils.EMPTY, titleDateSince, titleDateTo, sinceDatestr,
			toDatestr, titleInOrExp;

	private Date sinceDate = null, toDate = null;

	private MovementCriteriaDto movementCriteria = new MovementCriteriaDto();

	private BalanceRangeDto balanceRange;

	private DateRangeDto dateRange;

	private transient StreamedContent exportExcel;

	private transient StreamedContent exportPdf;

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	@Resource(name = "movementsAccountFacade")
	private transient MovementsAccountFacade movementsFacade;

	private transient ComboCriteriaControllerImpl comboCriteriaControllerImpl = new ComboCriteriaControllerImpl();

	private List<MovementDto> movementsList;

	@Resource(name = "graphicLineDelegate")
	private transient GraphicLineDelegate graphicLineDelegate;

	private String RUTAEXCEL = "Movimientos.xls";

	private LineConfigUI graphicLineMovements;

	private MovementDetailDto movementDetail;

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
			// List<MultiCoordinates> coordenadas = this.multiValueGroupFacade.getMultiCoordinate(movementDetail
			// .getPlaza().getCode());
			// movementDetail.getPlaza().setLatitude(coordenadas.get(0).getLength());
			// movementDetail.getPlaza().setLength(coordenadas.get(0).getLatitude());
			// LOGGER.info("latitud..." + coordenadas.get(0).getLatitude() + "..longitud.."
			// + coordenadas.get(0).getLength() + "..");
			movementDetail.getPlaza().setLatitude("4.712036");
			movementDetail.getPlaza().setLength("-74.071831");
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
		LOGGER.info("MovementsAccountController nextPage");
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
		String rutaArchivo = RUTAEXCEL;
		int inicio = 9;

		File archivoXLS = new File(rutaArchivo);
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
				URL url = new URL("https://www.bbva.com.co/BBVA-home-theme/images/BBVA/logo_bbva.png");
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
			Cell celdaHeader = filaHeader.createCell(1);
			CellStyle cellStyleHeader = libro.createCellStyle();
			Font text = libro.createFont();
			text.setFontHeightInPoints((short)10);
			text.setFontName("Arial");
			text.setBold(true);
			text.setColor(HSSFColor.BLACK.index);
			cellStyleHeader.setFont(text);
			celdaHeader.setCellStyle(cellStyleHeader);
			celdaHeader.setCellValue("FECHA");

			celdaHeader = filaHeader.createCell(3);
			celdaHeader.setCellValue("CONCEPTO");

			celdaHeader = filaHeader.createCell(5);
			celdaHeader.setCellValue("VALOR");

			celdaHeader = filaHeader.createCell(7);
			celdaHeader.setCellValue("SALDO");

			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 2));
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 3, 4));
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 5, 6));
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 7, 8));
			inicio = inicio + 1;
			for (int f = 0; f < this.movementsList.size(); f++) {
				Row fila = hoja.createRow(f + inicio);
				for (int c = 1; c < 9; c = c + 2) {
					Cell celda = fila.createCell(c);

					if (c == 1) {
						CellStyle cellStyle = libro.createCellStyle();
						Font date = libro.createFont();
						date.setFontHeightInPoints((short)10);
						date.setFontName("Arial");
						date.setBold(true);
						date.setColor(HSSFColor.BLUE.index);
						cellStyle.setFont(date);
						celda.setCellStyle(cellStyle);

						celda.setCellValue(getdateString(this.movementsList.get(f).getMovementDate()));

					}
					if (c == 3) {
						celda.setCellValue(this.movementsList.get(f).getMovementConcept());

					}
					if (c == 5) {
						celda.setCellValue(this.movementsList.get(f).getMovementValue().toString());

					}
					if (c == 7) {
						celda.setCellValue(this.movementsList.get(f).getTotalBalance().toString());

					}
					hoja.addMergedRegion(new CellRangeAddress(f, f, 1, 2));
					hoja.addMergedRegion(new CellRangeAddress(f, f, 3, 4));
					hoja.addMergedRegion(new CellRangeAddress(f, f, 5, 6));
					hoja.addMergedRegion(new CellRangeAddress(f, f, 7, 8));
				}
			}
			inicio = inicio + this.movementsList.size() + 2;
			Row filaFooter = hoja.createRow(inicio);
			filaFooter.createCell(1).setCellValue("Cordial saludo,");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 8));
			inicio = inicio + 1;
			filaFooter = hoja.createRow(inicio);
			filaFooter.createCell(1).setCellValue("BBVA Adelante");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 8));
			inicio = inicio + 2;

			filaFooter = hoja.createRow(inicio);
			filaFooter
					.createCell(1)
					.setCellValue(
							"Nota: Si no eres el destinatario de este mensaje, por favor comunícate con nosotros con el fin de realizar la actualización correspondiente, al 4010000 en Bogotá, 4938300 en Medellín, 3503500 en Barranquilla, 8892020 en Cali, 6304000 en Bucaramanga o al 01800 912227 desde el resto del país. ");

			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 8));

			inicio = inicio + 2;
			filaFooter = hoja.createRow(inicio);
			filaFooter.createCell(1).setCellValue("********************* AVISO LEGAL **************************");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 8));

			inicio = inicio + 1;
			filaFooter = hoja.createRow(inicio);
			filaFooter
					.createCell(1)
					.setCellValue(
							"Este mensaje es solamente para la persona a la que va dirigido. Puede contener informacion  confidencial  o  legalmente  protegida.  No  hay  renuncia  a la confidencialidad o privilegio por cualquier transmision mala/erronea. Si usted ha recibido este mensaje por error,  le rogamos que borre de su sistema inmediatamente el mensaje asi como todas sus copias, destruya todas las copias del mismo de su disco duro y notifique al remitente.  No debe,  directa o indirectamente, usar, revelar, distribuir, imprimir o copiar ninguna de las partes de este mensaje si no es usted el destinatario. Cualquier opinion expresada en este mensaje proviene del remitente, excepto cuando el mensaje establezca lo contrario y el remitente este autorizado para establecer que dichas opiniones provienen de  BBVA. Notese que el correo electronico via Internet no permite asegurar ni la confidencialidad de los mensajes que se transmiten ni la correcta recepcion de los mismos. En el caso de que el destinatario de este mensaje no consintiera la utilizacion del correo electronico via Internet, rogamos lo ponga en nuestro conocimiento de manera inmediata.");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 8));

			inicio = inicio + 2;
			filaFooter = hoja.createRow(inicio);
			filaFooter.createCell(1).setCellValue("**************************  DISCLAIMER**********************");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 8));

			inicio = inicio + 1;
			filaFooter = hoja.createRow(inicio);
			filaFooter
					.createCell(1)
					.setCellValue(
							"This message is intended exclusively for the named person. It may contain confidential, propietary or legally privileged information. No confidentiality or privilege is waived or lost by any mistransmission. If you receive this message in error, please immediately delete it and all copies of it from your system, destroy any hard copies of it and notify the sender. Your must not, directly or indirectly, use, disclose, distribute, print, or copy any part of this message if you are not the intended recipient. Any views expressed in this message are those of the individual sender, except where the message states otherwise and the sender is authorised to state them to be the views of BBVA. Please note that internet e-mail neither guarantees the confidentiality nor the proper receipt of the message sent.If the addressee of this message does not consent to the use of internet e-mail, please communicate it to us immediately.");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 8));

			inicio = inicio + 1;
			filaFooter = hoja.createRow(inicio);
			filaFooter.createCell(1).setCellValue("************************************************************");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 8));

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

		LOGGER.info("iniciando exportar archivo pdf");

		String rutaArchivo = "Movimientos.pdf";

		try {

			FileOutputStream file = null;

			try {
				file = new FileOutputStream(rutaArchivo);
			} catch (FileNotFoundException e) {
				LOGGER.info("Excepción no se encuentra el archivo" + e.getMessage());
			}

			Document document = new Document();

			PdfWriter.getInstance(document, file).setInitialLeading(20);

			document.open();

			try {
				Image foto = Image.getInstance("https://www.bbva.com.co/BBVA-home-theme/images/BBVA/logo_bbva.png");
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
			tabla.addCell(dateTitle);

			PdfPCell concept = new PdfPCell(new Phrase("CONCEPTO", font));
			concept.setBackgroundColor(new BaseColor(229, 229, 229));
			tabla.addCell(concept);

			PdfPCell value = new PdfPCell(new Phrase("VALOR", font));
			value.setBackgroundColor(new BaseColor(229, 229, 229));
			tabla.addCell(value);

			PdfPCell sald = new PdfPCell(new Phrase("SALDO", font));
			sald.setBackgroundColor(new BaseColor(229, 229, 229));
			tabla.addCell(sald);

			for (int i = 0; i < movementsList.size(); i++) {

				String date = getdateString(movementsList.get(i).getMovementDate());

				tabla.addCell(new Phrase(date, fontBlue));
				tabla.addCell(new Phrase(movementsList.get(i).getMovementConcept(), fontNormal));
				tabla.addCell(new Phrase(movementsList.get(i).getMovementValue() + "", font));
				tabla.addCell(new Phrase(movementsList.get(i).getTotalBalance() + "", font));
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

	public String getdateString(Date date) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat(
				MessagesHelper.INSTANCE.getStringI18("date.pattner.dd-mm-yyyy"));
		if (date != null) {
			return dateFormat.format(date);
		}
		return "N/A";
	}

	@Override
	public void printFile() {
		File pdfFile = new File("Movimientos.pdf");

		if (pdfFile.exists()) {
			if (pdfFile.delete()) {
				LOGGER.info("borró el archivo");
				exportDocumentPdf();
			} else
				LOGGER.info("No lo borró");
		} else {
			exportDocumentPdf();
		}
		// try {
		// Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler Movimientos.pdf");
		// p.waitFor();
		//
		// LOGGER.info("Abrió el archivo");
		//
		// } catch (Exception ex) {
		// LOGGER.info("No pudo abrir el archivo" + ex.getMessage());
		// }

		String s = System.getProperty("os.name").toLowerCase();
		if (s.contains("win")) {
			createCommand("explorer", "%s", pdfFile.getPath());
		}

		if (s.contains("mac")) {
			createCommand("open", "%s", pdfFile.getPath());
		}

		if (s.contains("linux") || s.contains("unix")) {
			createCommand("kde-open", "%s", pdfFile.getPath());
			createCommand("gnome-open", "%s", pdfFile.getPath());
			createCommand("xdg-open", "%s", pdfFile.getPath());
		}

		// try {
		// if (Desktop.isDesktopSupported()) {
		//
		// Desktop.getDesktop().open(pdfFile);
		// // myFile.delete();
		// }
		// } catch (IOException ex) {
		// LOGGER.info("Error al abrir archivo " + ex.getMessage());
		// }
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
			if (p == null) return false;

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
				LOGGER.info("Proceso esta corriendo " + itse.getMessage());
				return true;
			}
		} catch (IOException e) {
			LOGGER.info("Error ejecutando el comando " + e.getMessage());
			return false;
		}
	}

	@Override
	public void sendMail() {
		try {

			Properties props = new Properties();
			props.put("mail.smtp.auth", "false");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.user", "BBVA@bbvanet.com.co");
			props.put("mail.smtp.host", "172.16.9.53");
			props.put("mail.smtp.port", "24");
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
				htmlTable += "<tr><th role=\"gridcell\" tabindex=\"0\"><span style=\"color:blue\">"
						+ getdateString(this.movementsList.get(i).getMovementDate())
						+ "</span><span></span></th><th role=\"gridcell\" tabindex=\"0\"><span style=\"font-weight:normal\">"
						+ this.movementsList.get(i).getMovementConcept()
						+ "</span><span></span></th><th role=\"gridcell\" tabindex=\"0\"><span >"
						+ this.movementsList.get(i).getMovementValue()
						+ "</span><span ></span></th><th role=\"gridcell\" tabindex=\"0\"><span >"
						+ this.movementsList.get(i).getTotalBalance() + "</span><span ></span></th></tr>";
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
			message.setFrom(new InternetAddress("BBVA@bbvanet.com.co"));
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
		}
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
			stream = new BufferedInputStream(new FileInputStream(RUTAEXCEL));
			exportExcel = new DefaultStreamedContent(stream, "application/xls", "Movimientos.xls");
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
			stream = new BufferedInputStream(new FileInputStream("Movimientos.pdf"));
			exportPdf = new DefaultStreamedContent(stream, "application/pdf", "Movimientos.pdf");
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

}