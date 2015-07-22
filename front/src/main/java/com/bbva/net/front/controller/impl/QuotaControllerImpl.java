/**
 * 
 */
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
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
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.controller.QuotaController;
import com.bbva.net.front.helper.MessagesHelper;
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
 * @author User
 */

public class QuotaControllerImpl extends QuotaPaginatedController implements QuotaController {

	private static final long serialVersionUID = 1L;

	private QuotaDetailDto quotaDetailDto;

	private MovementDetailDto quotaMoveDetailDto;

	private MovementDto quotaMove;

	private ProductDto productDto;

	private DateRangeDto dateRange;

	private List<MovementDto> quotamovenDtos;

	private MovementCriteriaDto movementCriteria;

	private Map<String, Boolean> renderComponents;

	private Date sinceDate = null, toDate = null;

	private String sinceText, toText, sinceDatestr, toDatestr, selectDate = StringUtils.EMPTY;

	private static final String CONCRETE_DATE = MessagesHelper.INSTANCE.getString("select.radio.concret.date");

	private static final String SINCE_TITLE = MessagesHelper.INSTANCE.getString("text.since");

	private static final String TO_TITLE = MessagesHelper.INSTANCE.getString("text.to");

	private transient StreamedContent exportExcel;

	private transient StreamedContent exportPdf;

	private transient StreamedContent exportDetailPdf;

	private String rutaExcelCupo;

	private String rutaPdfCupo;

	private String rutaPdfMove;

	protected String RUTA_ICONO_BBVA = MessagesHelper.INSTANCE.getString("ruta.iconobbva");

	protected String IP_IRONPORT = MessagesHelper.INSTANCE.getString("ruta.ipironport");

	protected String PUERTO_IRONPORT = MessagesHelper.INSTANCE.getString("ruta.puertoironport");

	protected String REMITENTE = MessagesHelper.INSTANCE.getString("ruta.remitente");

	@Resource(name = "quotaDetailFacade")
	private transient QuotaDetailFacade quotaDetailFacade;

	@Override
	public void init() {
		LOGGER.info("QuotaControllerImpl Super Initialize");
		super.init();
		LOGGER.info("QuotaControllerImpl Initialize QuotaController");
		// inicializar variables
		this.quotaDetailDto = new QuotaDetailDto();
		this.quotaMoveDetailDto = new MovementDetailDto();
		this.productDto = new ProductDto();
		this.dateRange = new DateRangeDto();
		this.movementCriteria = new MovementCriteriaDto();
		this.renderComponents = new HashMap<String, Boolean>();
		// obtener el producto
		this.productDto = super.getSelectedProduct();
		if (productDto != null && productDto.getProductId() != null) {
			try {
				LOGGER.info("Datos del producto Seleccionado Terminado " + " Product Id: " + productDto.getProductId());
				this.quotaDetailDto = this.quotaDetailFacade.getDetailRotaryQuota(this.productDto.getProductId());
				LOGGER.info("Datos del quotaDetailDto Terminados" + " Product Id: " + quotaDetailDto.getId());
			} catch (Exception e) {
				FacesContext ctx = FacesContext.getCurrentInstance();
				ctx.addMessage("quotaDetailDto", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
			}
		} else {
			LOGGER.info("Datos del producto Seleccionado Vacio (null)");
			this.productDto = new ProductDto();
		}
		cleanFilters();
	}

	public void resetData() {
		final HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		session.setAttribute("operationsRotary", "false");
	}

	@Override
	public ProductDto getSelectedProduct() {
		return super.getSelectedProduct();
	}

	@Override
	public void cleanFilters() {
		LOGGER.info(" QuotaControllerImpl cleanFilters");
		renderComponents.put(RenderAttributes.CALENDAR.toString(), true);
		renderComponents.put(RenderAttributes.BUTTONDATE.toString(), true);
		// Filtros
		renderComponents.put(RenderAttributes.FILTERDATE.toString(), false);
		// Atr
		this.movementCriteria = new MovementCriteriaDto();
		this.movementCriteria.setDateRange(new DateRangeDto());
		setSinceText(new String());
		setToText(new String());
		setSinceDatestr(new String());
		setToDatestr(new String());
		setSinceDate(null);
		setToDate(null);
		setSelectDate(new String());
	}

	@Override
	public void cleanFilters(ActionEvent event) {
		LOGGER.info(" QuotaControllerImpl cleanFilters ActionEvent");
		cleanFilters();
	}

	private void calculateDate(final String date) {
		LOGGER.info("QuotaControllerImpl calculateDate ");
		EnumPeriodType periodType = EnumPeriodType.valueOfLabel(date);
		if (!(periodType == (null))) {
			this.dateRange = new DateRangeDto();
			this.dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
		}
	}

	private void setShowMoreStatus() {
		LOGGER.info("QuotaControllerImpl setShowMoreStatus ");
		if (this.quotamovenDtos.size() >= 10)
			getRenderComponents().put(RenderAttributes.FOOTERTABLEQUOTA.toString(), true);
		else
			getRenderComponents().put(RenderAttributes.FOOTERTABLEQUOTA.toString(), false);
	}

	@Override
	public List<MovementDto> getAllQuotamovenDtos() {
		LOGGER.info("QuotaControllerImpl getAllQuotamovenDtos ");
		this.quotamovenDtos = new ArrayList<MovementDto>();
		calculateDate(MessagesHelper.INSTANCE.getString("select.radio.last.month"));
		setDateRangePControl(this.dateRange);
		if (getSelectedProduct().isVisible()) {
			super.setQuotaDetailFacade(quotaDetailFacade);
			next();
			this.quotamovenDtos = getCurrentList();
			LOGGER.info("Datos de los movimientos llenos ");
		}
		setShowMoreStatus();
		return quotamovenDtos;
	}

	@Override
	public void setSelectedProduct(final ProductDto selectedProduct) {
		super.setSelectedProduct(selectedProduct);
	}

	public void onRowToggle(final SelectEvent event) {
		LOGGER.info("QuotaControllerImpl onRowToggle");
		this.quotaMove = new MovementDto();
		super.onMovementSelected(event);
		this.quotaMove = super.getSelectedMovements();
		String identify = String.format("%06d", Integer.valueOf(quotaMove.getMovementId())) + ""
				+ String.format("%04d", Integer.valueOf(quotaMove.getExtractNumber()));
		try {
			this.quotaMoveDetailDto = this.quotaDetailFacade.getRotaryQuotaMovement(this.productDto.getProductId(),
					identify);
			LOGGER.info("Movimiento Seleccionado " + quotaMoveDetailDto.getId());
		} catch (Exception e) {
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage("quotaMoveDetailDto", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
		}
	}

	@Override
	public void oneSelectDate() {
		LOGGER.info("Method oneSelectDate");
		renderComponents.put(RenderAttributes.FILTERDATE.toString(), true);
		if (getSelectDate().equals(CONCRETE_DATE)) {
			renderComponents.put(RenderAttributes.CALENDAR.toString(), false);
			renderComponents.put(RenderAttributes.BUTTONDATE.toString(), false);
			LOGGER.info("Fecha Concreta: " + " Calendar: " + renderComponents.get(RenderAttributes.CALENDAR.toString())
					+ " Boton: " + renderComponents.get(RenderAttributes.BUTTONDATE.toString()));
		} else {
			renderComponents.put(RenderAttributes.CALENDAR.toString(), true);
			renderComponents.put(RenderAttributes.BUTTONDATE.toString(), false);
			LOGGER.info("Radio Button: " + " Calendar: " + renderComponents.get(RenderAttributes.CALENDAR.toString())
					+ " Boton: " + renderComponents.get(RenderAttributes.BUTTONDATE.toString()));
		}
	}

	@Override
	public void setCustomDate(final ActionEvent event) {
		LOGGER.info("MovementsAccountController setCustomDate");
		getRenderComponents().put(RenderAttributes.FILTERDATE.toString(), true);
		this.dateRange = new DateRangeDto();
		this.dateRange.setDateSince(getSinceDate());
		this.dateRange.setDateTo(getToDate());
		if (!(getSinceDate() == (null)) && !(getToDate() == (null)) && getSelectDate().equals(CONCRETE_DATE)) {
			this.sinceText = SINCE_TITLE + ": ";
			this.toText = TO_TITLE + ": ";
			sinceDatestr = DateUtils.format(getSinceDate(), "dd/MM/yyyy");
			toDatestr = DateUtils.format(getToDate(), "dd/MM/yyyy");
		} else {
			this.sinceText = "";
			this.toText = "";
			this.sinceDatestr = getSelectDate();
			this.toDatestr = "";
			setSinceDate(null);
			setToDate(null);
		}
	}

	@Override
	public void searchQuotaByFilter(final ActionEvent event) {
		LOGGER.info("QuotaControllerImpl searchQuotaByFilter ");
		if (renderComponents.get(RenderAttributes.FILTERDATE.toString())) {
			calculateDate(this.getSelectDate());
			criteriaSearch();
			LOGGER.info("Mostrando resultados de filtros " + "Date Since: " + dateRange.getDateSince() + "Date To: "
					+ dateRange.getDateTo());
		}
	}

	@Override
	public void nextPage(final ActionEvent event) {
		LOGGER.info("QuotaControllerImpl nextPage ");
		super.setQuotaDetailFacade(quotaDetailFacade);
		next();
		this.quotamovenDtos = getCurrentList();
	}

	@Override
	public void criteriaSearch() {
		LOGGER.info("QuotaControllerImpl criteriaSearch ");
		if (renderComponents.get(RenderAttributes.FILTERDATE.toString())) {
			setDateRangePControl(this.dateRange);
			LOGGER.info("date Range: " + " sinceDate: " + this.dateRange.getDateSince() + " toDate: "
					+ this.dateRange.getDateTo());
		}
		super.init();
		super.setQuotaDetailFacade(quotaDetailFacade);
		search();
		this.quotamovenDtos = getCurrentList();
		setShowMoreStatus();
		cleanFilters();
	}

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

		rutaExcelCupo = "MovimientosCupo" + getSelectedProduct().getProductNumber() + ".xls";

		List<Cell> cellSheet = new ArrayList<Cell>();

		int inicio = 10;

		File archivoXLS = new File(rutaExcelCupo);
		if (archivoXLS.exists()) archivoXLS.delete();

		try {
			archivoXLS.createNewFile();
		} catch (IOException e) {
			LOGGER.info("Excepción al crear el archivo" + e.getMessage());
		}
		Workbook libro = new HSSFWorkbook();

		try {
			FileOutputStream archivo = new FileOutputStream(archivoXLS);
			Sheet hoja = libro.createSheet("Movimientos de cupo rotativo");
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
				pict.resize(2.05, 7.0);
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

			if (quotamovenDtos != null && (this.quotamovenDtos.size() != 0 || !this.quotamovenDtos.isEmpty())) {

				Cell dateHeader = filaHeader.createCell(1);
				dateHeader.setCellType(Cell.CELL_TYPE_STRING);
				dateHeader.setCellStyle(cellStyleHeader);
				dateHeader.setCellValue("FECHA");
				cellSheet.add(dateHeader);

				Cell concep = filaHeader.createCell(2);
				concep.setCellType(Cell.CELL_TYPE_STRING);
				concep.setCellStyle(cellStyleHeader);
				concep.setCellValue("CONCEPTO");
				cellSheet.add(concep);

				Cell pend = filaHeader.createCell(3);
				pend.setCellType(Cell.CELL_TYPE_STRING);
				pend.setCellStyle(cellStyleHeader);
				pend.setCellValue("PENDIENTE");
				cellSheet.add(pend);

				hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 1));
				hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 2, 2));
				hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 3, 3));

			} else {

				Cell dateHeader = filaHeader.createCell(1);
				dateHeader.setCellType(Cell.CELL_TYPE_STRING);
				dateHeader.setCellStyle(cellStyleHeader);
				dateHeader.setCellValue("FECHA");
				hoja.autoSizeColumn(1);

				Cell concep = filaHeader.createCell(2);
				concep.setCellType(Cell.CELL_TYPE_STRING);
				concep.setCellStyle(cellStyleHeader);
				concep.setCellValue("CONCEPTO");
				hoja.autoSizeColumn(2);

				Cell pend = filaHeader.createCell(3);
				pend.setCellType(Cell.CELL_TYPE_STRING);
				pend.setCellStyle(cellStyleHeader);
				pend.setCellValue("PENDIENTE");
				hoja.autoSizeColumn(3);

				hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 1));
				hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 2, 2));
				hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 3, 3));

			}

			inicio = inicio + 1;

			if (quotamovenDtos != null && (this.quotamovenDtos.size() != 0 || !this.quotamovenDtos.isEmpty())) {
				for (int f = 0; f < this.quotamovenDtos.size(); f++) {
					Row fila = hoja.createRow(f + inicio);
					for (int c = 1; c < 4; c++) {

						Font fontad = libro.createFont();
						fontad.setFontHeightInPoints((short)10);
						fontad.setFontName("Arial");
						fontad.setBold(true);
						fontad.setColor(HSSFColor.BLUE.index);

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
							cellStyle.setFont(fontad);
							String DateString = super.getdateString(this.quotamovenDtos.get(f).getMovementDate());
							super.createCell(celda, DateString, cellStyle);
							cellSheet.add(celda);
						}

						if (c == 2) {
							super.createCell(celda, this.quotamovenDtos.get(f).getMovementConcept(), cellStyle);
							cellSheet.add(celda);
						}

						if (c == 3) {
							super.createCellMoney(celda, this.quotamovenDtos.get(f).getMovementValue(), cellStyle);
							cellSheet.add(celda);
						}

						hoja.addMergedRegion(new CellRangeAddress(f, f, 1, 1));
						hoja.addMergedRegion(new CellRangeAddress(f, f, 2, 2));
						hoja.addMergedRegion(new CellRangeAddress(f, f, 3, 3));
					}
				}

				super.maxSize(cellSheet, hoja, 3);

				inicio = inicio + this.quotamovenDtos.size() + 2;

			} else if (quotamovenDtos != null && (this.quotamovenDtos.size() == 0 || this.quotamovenDtos.isEmpty())) {

				Row filaOter = hoja.createRow(inicio);

				Cell celda = filaOter.createCell(1);
				Cell celda1 = filaOter.createCell(2);
				Cell celda2 = filaOter.createCell(3);

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

				celda.setCellValue("No hay registros");

				hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 3));

				inicio = inicio + this.quotamovenDtos.size() + 3;
			}

			Row filaFooter = hoja.createRow(inicio);
			filaFooter.createCell(1).setCellValue("Cordial saludo,");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 3));

			Font bbvaAde = libro.createFont();
			bbvaAde.setColor(HSSFColor.BLUE.index);

			CellStyle bbvaStyle = libro.createCellStyle();
			bbvaStyle.setFont(bbvaAde);

			inicio = inicio + 1;

			filaFooter = hoja.createRow(inicio);
			Cell bbva = filaFooter.createCell(1);
			bbva.setCellStyle(bbvaStyle);
			bbva.setCellValue("BBVA Adelante");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 3));

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
			filaFooter.setHeight((short)1100);
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 3));

			inicio = inicio + 2;

			CellStyle cellFooterStyle = libro.createCellStyle();
			cellFooterStyle.setVerticalAlignment(CellStyle.VERTICAL_JUSTIFY);

			filaFooter = hoja.createRow(inicio);
			filaFooter.createCell(1).setCellValue("********************* AVISO LEGAL **************************");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 3));

			inicio = inicio + 1;
			filaFooter = hoja.createRow(inicio);
			Cell message = filaFooter.createCell(1);
			message.setCellStyle(cellFooterStyle);
			message.setCellValue("Este mensaje es solamente para la persona a la que va dirigido. Puede contener informacion  confidencial  o  legalmente  protegida.  No  hay  renuncia  a la confidencialidad o privilegio por cualquier transmision mala/erronea. Si usted ha recibido este mensaje por error,  le rogamos que borre de su sistema inmediatamente el mensaje asi como todas sus copias, destruya todas las copias del mismo de su disco duro y notifique al remitente.  No debe,  directa o indirectamente, usar, revelar, distribuir, imprimir o copiar ninguna de las partes de este mensaje si no es usted el destinatario. Cualquier opinion expresada en este mensaje proviene del remitente, excepto cuando el mensaje establezca lo contrario y el remitente este autorizado para establecer que dichas opiniones provienen de  BBVA. Notese que el correo electronico via Internet no permite asegurar ni la confidencialidad de los mensajes que se transmiten ni la correcta recepcion de los mismos. En el caso de que el destinatario de este mensaje no consintiera la utilizacion del correo electronico via Internet, rogamos lo ponga en nuestro conocimiento de manera inmediata.");
			filaFooter.setHeight((short)3500);
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 3));

			inicio = inicio + 2;

			filaFooter = hoja.createRow(inicio);
			filaFooter.createCell(1).setCellValue("**************************  DISCLAIMER**********************");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 3));

			inicio = inicio + 1;

			filaFooter = hoja.createRow(inicio);
			Cell messEng = filaFooter.createCell(1);
			messEng.setCellStyle(cellFooterStyle);
			messEng.setCellValue("This message is intended exclusively for the named person. It may contain confidential, propietary or legally privileged information. No confidentiality or privilege is waived or lost by any mistransmission. If you receive this message in error, please immediately delete it and all copies of it from your system, destroy any hard copies of it and notify the sender. Your must not, directly or indirectly, use, disclose, distribute, print, or copy any part of this message if you are not the intended recipient. Any views expressed in this message are those of the individual sender, except where the message states otherwise and the sender is authorised to state them to be the views of BBVA. Please note that internet e-mail neither guarantees the confidentiality nor the proper receipt of the message sent.If the addressee of this message does not consent to the use of internet e-mail, please communicate it to us immediately.");
			filaFooter.setHeight((short)2900);
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 3));

			inicio = inicio + 1;

			filaFooter = hoja.createRow(inicio);
			filaFooter.createCell(1).setCellValue("************************************************************");
			hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 3));

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

		rutaPdfCupo = "MovimientosCupo" + getSelectedProduct().getProductNumber() + ".pdf";

		try {

			FileOutputStream file = null;

			try {
				file = new FileOutputStream(rutaPdfCupo);
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

			PdfPTable tabla = new PdfPTable(3);
			com.itextpdf.text.Font font = new com.itextpdf.text.Font(FontFamily.HELVETICA, 10,
					com.itextpdf.text.Font.BOLD, BaseColor.BLACK);
			com.itextpdf.text.Font fontNormal = new com.itextpdf.text.Font(FontFamily.HELVETICA, 10,
					com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
			com.itextpdf.text.Font fontBlue = new com.itextpdf.text.Font(FontFamily.HELVETICA, 10,
					com.itextpdf.text.Font.BOLD, new BaseColor(0, 80, 152));
			tabla.setSpacingBefore(20);
			tabla.setSpacingAfter(20);

			PdfPCell dateTitle = new PdfPCell(new Phrase("FECHA", font));
			dateTitle.setHorizontalAlignment(Element.ALIGN_CENTER);
			dateTitle.setVerticalAlignment(Element.ALIGN_MIDDLE);
			dateTitle.setBackgroundColor(new BaseColor(229, 229, 229));
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

			if (quotamovenDtos != null && quotamovenDtos.size() != 0) {
				for (int i = 0; i < quotamovenDtos.size(); i++) {
					String date = super.getdateString(quotamovenDtos.get(i).getMovementDate());
					PdfPCell dateData = new PdfPCell(new Phrase(date, fontBlue));
					dateData.setHorizontalAlignment(Element.ALIGN_CENTER);
					dateData.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tabla.addCell(dateData);

					PdfPCell dataconcept = new PdfPCell(new Phrase(quotamovenDtos.get(i).getMovementConcept(),
							fontNormal));
					dataconcept.setHorizontalAlignment(Element.ALIGN_CENTER);
					dataconcept.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tabla.addCell(dataconcept);

					if (quotamovenDtos.get(i).getMovementValue() != null) {
						PdfPCell dataValue = new PdfPCell(new Phrase(quotamovenDtos.get(i).getMovementValue()
								.toString(), font));
						dataValue.setHorizontalAlignment(Element.ALIGN_CENTER);
						dataValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
						tabla.addCell(dataValue);
					} else {
						tabla.addCell(" ");
					}
				}
			} else if (quotamovenDtos == null || quotamovenDtos.size() == 0) {

				PdfPCell nonee = new PdfPCell(new Phrase("No hay registros", font));
				nonee.setHorizontalAlignment(Element.ALIGN_CENTER);
				nonee.setVerticalAlignment(Element.ALIGN_MIDDLE);
				nonee.setBorder(Rectangle.BOX);
				nonee.setColspan(3);
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

	@Override
	public void exportDocDetailPdf() {
		LOGGER.info("iniciando exportar archivo pdf");

		rutaPdfMove = "MovDetalleCupo" + quotaMoveDetailDto.getId() + ".pdf";

		try {

			FileOutputStream file = null;

			try {
				file = new FileOutputStream(rutaPdfMove);
			} catch (FileNotFoundException e) {
				LOGGER.info("Excepción no se encuentra el archivo" + e.getMessage());
			}

			Document document = new Document();

			PdfWriter writer = PdfWriter.getInstance(document, file);
			writer.setInitialLeading(20);

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

			PdfPTable header = new PdfPTable(3);

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

			PdfPCell pends = new PdfPCell(new Phrase("Pendiente", fontBlue));
			pends.setHorizontalAlignment(Element.ALIGN_LEFT);
			pends.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pends.setBorder(0);
			header.addCell(pends);

			String date = super.getdateString(quotaMove.getMovementDate());
			PdfPCell dataDates = new PdfPCell(new Phrase(date, fontNormal));
			dataDates.setHorizontalAlignment(Element.ALIGN_LEFT);
			dataDates.setVerticalAlignment(Element.ALIGN_MIDDLE);
			dataDates.setBorder(0);
			header.addCell(dataDates);

			PdfPCell dataConcep = new PdfPCell(new Phrase(quotaMove.getMovementConcept(), fontNormal));
			dataConcep.setHorizontalAlignment(Element.ALIGN_LEFT);
			dataConcep.setVerticalAlignment(Element.ALIGN_MIDDLE);
			dataConcep.setBorder(0);
			header.addCell(dataConcep);

			if (quotaMove.getMovementValue() != null) {
				PdfPCell dataPends = new PdfPCell(new Phrase(quotaMove.getMovementValue().toString(), fontNormal));
				dataPends.setHorizontalAlignment(Element.ALIGN_LEFT);
				dataPends.setVerticalAlignment(Element.ALIGN_MIDDLE);
				dataPends.setBorder(0);
				header.addCell(dataPends);
			} else {
				header.addCell(" ");
			}

			document.add(header);

			Paragraph title = new Paragraph("Información del movimiento", FontFactory.getFont("helvetica", 11,
					new BaseColor(51, 51, 51)));
			title.setSpacingBefore(20);
			document.add(title);

			PdfPTable tabla = new PdfPTable(5);

			tabla.setSpacingBefore(20);
			tabla.setSpacingAfter(20);
			tabla.setHorizontalAlignment(Element.ALIGN_LEFT);
			tabla.getDefaultCell().setBorder(0);

			PdfPCell quota = new PdfPCell(new Phrase("N° de cuota", font));
			quota.setHorizontalAlignment(Element.ALIGN_CENTER);
			quota.setVerticalAlignment(Element.ALIGN_MIDDLE);
			quota.setBorder(0);
			tabla.addCell(quota);

			if (this.quotaMoveDetailDto.getRemainingQuotas() != null) {
				PdfPCell dataQuota = new PdfPCell(new Phrase(this.quotaMoveDetailDto.getRemainingQuotas(), fontNormal));
				dataQuota.setHorizontalAlignment(Element.ALIGN_CENTER);
				dataQuota.setVerticalAlignment(Element.ALIGN_MIDDLE);
				dataQuota.setBorder(0);
				tabla.addCell(dataQuota);
			} else {
				tabla.addCell("");
			}

			if (quotaMoveDetailDto.getNumbersOfQuota() != null) {
				PdfPCell data2Quota = new PdfPCell(new Phrase(" de " + quotaMoveDetailDto.getNumbersOfQuota(),
						fontNormal));
				data2Quota.setHorizontalAlignment(Element.ALIGN_CENTER);
				data2Quota.setVerticalAlignment(Element.ALIGN_MIDDLE);
				data2Quota.setBorder(0);
				tabla.addCell(data2Quota);
			} else {
				tabla.addCell("");
			}

			PdfPCell fool = new PdfPCell(new Phrase("Pendiente", font));
			fool.setHorizontalAlignment(Element.ALIGN_CENTER);
			fool.setVerticalAlignment(Element.ALIGN_MIDDLE);
			fool.setBorder(0);
			tabla.addCell(fool);

			if (quotaMoveDetailDto.getValueslope() != null) {
				PdfPCell dataFool = new PdfPCell(new Phrase(quotaMoveDetailDto.getValueslope().toString(), fontNormal));
				dataFool.setHorizontalAlignment(Element.ALIGN_CENTER);
				dataFool.setVerticalAlignment(Element.ALIGN_MIDDLE);
				dataFool.setBorder(0);
				tabla.addCell(dataFool);
			} else {
				tabla.addCell(" ");
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

	@Override
	public void printMovesQuota() {
		printFile("MovementsQuota");
	}

	@Override
	public void printMoveDetailQuota() {
		printFile("DetailMoveQuota");
	}

	public void printFile(String typeDoc) {
		File pdfFile = null;
		if (typeDoc.equals("MovementsQuota")) {
			pdfFile = new File("MovDetalleCupo" + quotaMoveDetailDto.getId() + ".pdf");
		}
		if (typeDoc.equals("DetailMoveQuota")) {
			pdfFile = new File("MovimientosDetail" + getSelectedProduct().getProductNumber() + ".pdf");
		}
		LOGGER.info("printFile ruta de archivo " + pdfFile.getAbsolutePath());
		if (pdfFile.exists()) {
			if (pdfFile.delete()) {
				LOGGER.info("borró el archivo " + pdfFile.getAbsolutePath());
				if (typeDoc.equals("MovementsQuota")) {
					exportDocumentPdf();
				}
				if (typeDoc.equals("DetailMoveQuota")) {
					exportDocDetailPdf();
				}
			} else
				LOGGER.info("No lo borró");
		} else {
			LOGGER.info("crea el archivo " + pdfFile.getAbsolutePath());
			if (typeDoc.equals("MovementsQuota")) {
				exportDocumentPdf();
			}
			if (typeDoc.equals("DetailMoveQuota")) {
				exportDocDetailPdf();
			}

		}

		String s = System.getProperty("os.name").toLowerCase();
		if (s.contains("win")) {
			createCommand("explorer", "%s", pdfFile.getAbsolutePath());
		}

		if (s.contains("mac")) {
			createCommand("open", "%s", pdfFile.getAbsolutePath());
		}

		if (s.contains("linux") || s.contains("unix")) {
			createCommand("kde-open", "%s", pdfFile.getAbsolutePath());
			createCommand("gnome-open", "%s", pdfFile.getAbsolutePath());
			createCommand("xdg-open", "%s", pdfFile.getAbsolutePath());
		}

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
			if (quotamovenDtos != null) {
				for (int i = 0; i < this.quotamovenDtos.size(); i++) {
					String value = "";
					if (this.quotamovenDtos.get(i).getMovementValue() != null) {
						value = this.quotamovenDtos.get(i).getMovementValue().toString();
					}
					htmlTable += "<tr><th role=\"gridcell\" tabindex=\"0\"><span style=\"color:blue\">"
							+ super.getdateString(this.quotamovenDtos.get(i).getMovementDate())
							+ "</span><span></span></th><th role=\"gridcell\" tabindex=\"0\"><span style=\"font-weight:normal\">"
							+ this.quotamovenDtos.get(i).getMovementConcept()
							+ "</span><span></span></th><th role=\"gridcell\" tabindex=\"0\"><span >" + value
							+ "</span><span ></span></th><th role=\"gridcell\" tabindex=\"0\"><span >"
							+ "</span><span ></span></th></tr>";
				}
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
			message.setSubject("Movimientos de Cupo Rotativo");
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

	// Setters and Getters
	public QuotaDetailDto getQuotaDetailDto() {
		return quotaDetailDto;
	}

	public void setQuotaDetailDto(QuotaDetailDto quotaDetailDto) {
		this.quotaDetailDto = quotaDetailDto;
	}

	public MovementDetailDto getQuotaMoveDetailDto() {
		return quotaMoveDetailDto;
	}

	public void setQuotaMoveDetailDto(MovementDetailDto quotaMoveDetailDto) {
		this.quotaMoveDetailDto = quotaMoveDetailDto;
	}

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

	public Map<String, Boolean> getRenderComponents() {
		return renderComponents;
	}

	public void setRenderComponents(Map<String, Boolean> renderComponents) {
		this.renderComponents = renderComponents;
	}

	public List<MovementDto> getQuotamovenDtos() {
		return quotamovenDtos;
	}

	public void setQuotamovenDtos(List<MovementDto> quotamovenDtos) {
		this.quotamovenDtos = quotamovenDtos;
	}

	public DateRangeDto getDateRange() {
		return dateRange;
	}

	public void setDateRange(DateRangeDto dateRange) {
		this.dateRange = dateRange;
	}

	public Date getSinceDate() {
		return sinceDate;
	}

	public void setSinceDate(Date sinceDate) {
		this.sinceDate = sinceDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getSinceDatestr() {
		return sinceDatestr;
	}

	public void setSinceDatestr(String sinceDatestr) {
		this.sinceDatestr = sinceDatestr;
	}

	public String getToDatestr() {
		return toDatestr;
	}

	public void setToDatestr(String toDatestr) {
		this.toDatestr = toDatestr;
	}

	public String getSelectDate() {
		return selectDate;
	}

	public void setSelectDate(String selectDate) {
		this.selectDate = selectDate;
	}

	public String getSinceText() {
		return sinceText;
	}

	public void setSinceText(String sinceText) {
		this.sinceText = sinceText;
	}

	public String getToText() {
		return toText;
	}

	public void setToText(String toText) {
		this.toText = toText;
	}

	@Override
	public void setQuotaDetailFacade(QuotaDetailFacade quotaDetailFacade) {
		this.quotaDetailFacade = quotaDetailFacade;
	}

	public MovementDto getQuotaMove() {
		return quotaMove;
	}

	public void setQuotaMove(MovementDto quotaMove) {
		this.quotaMove = quotaMove;
	}

	public StreamedContent getExportExcel() {
		exportDocumentExcel();
		InputStream stream;
		try {
			stream = new BufferedInputStream(new FileInputStream(rutaExcelCupo));
			exportExcel = new DefaultStreamedContent(stream, "application/xls", "MovimientosCupo"
					+ getSelectedProduct().getProductNumber() + ".xls");
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
			stream = new BufferedInputStream(new FileInputStream(rutaPdfCupo));
			exportPdf = new DefaultStreamedContent(stream, "application/pdf", "MovimientosCupo"
					+ getSelectedProduct().getProductNumber() + ".pdf");
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
		exportDocDetailPdf();
		InputStream stream;
		try {
			stream = new BufferedInputStream(new FileInputStream(rutaPdfMove));
			exportDetailPdf = new DefaultStreamedContent(stream, "application/pdf", "MovDetalleCupo"
					+ quotaMoveDetailDto.getId() + ".pdf");
		} catch (FileNotFoundException e) {
			LOGGER.info("Error al descargar el pdf " + e.getMessage());
		}
		return exportDetailPdf;
	}

	/**
	 * @param exportPdf the exportPdf to set
	 */
	public void setExportDetailPdf(StreamedContent exportPdf) {
		this.exportDetailPdf = exportPdf;
	}

}
