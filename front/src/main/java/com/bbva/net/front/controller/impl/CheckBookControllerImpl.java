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
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

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
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.CheckBookFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.checkbook.CheckbookDto;
import com.bbva.net.back.model.comboFilter.EnumCheckStatus;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.predicate.CheckBookStatusPredicate;
import com.bbva.net.back.predicate.CheckStatusPredicate;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.controller.CheckBookController;
import com.bbva.net.front.controller.HeaderController;
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
 * @author Entelgy
 */

public class CheckBookControllerImpl extends CheckPaginatedController implements CheckBookController {
    
    private static final long serialVersionUID = 1L;
    
    private static final String SEARCH_BY_NUMBER_CHECK = MessagesHelper.INSTANCE
            .getString("text.search.by.number.check"), SEARCH_CHECK = MessagesHelper.INSTANCE
                    .getString("text.search.by.numberbook"),
            CONCRETE_DATE = MessagesHelper.INSTANCE
                    .getString("select.radio.concret.date"),
            SINCE_TITLE = MessagesHelper.INSTANCE.getString("text.since"),
            TO_TITLE = MessagesHelper.INSTANCE.getString("text.to");
            
    private static final Integer LIST_CHECK_STATUS = 2;
    
    private String selectDate;
    
    private Date sinceDate, toDate;
    
    private String actionState, checkState, checkNumber, checkBookNumber, titleDateSince, titleDateTo, sinceDatestr,
            toDatestr, leftTitle, rightTitle, leftTitle2, rightTitle2, titleState;
            
    private List<CheckbookDto> checkBook;
    
    private List<CheckDto> checkList;
    
    private List<CheckbookDto> checkBookList = null;
    
    private CheckDto check = new CheckDto();
    
    private DateRangeDto dateRange = new DateRangeDto();
    
    private List<SelectItem> checkBooks;
    
    // <!-- Entelgy / GP-12834 / 25112015 / INICIO -->
    
    private CheckbookDto initialCheckBook;
    
    // <!-- Entelgy / GP-12834 / 25112015 / FIN -->
    
    @Resource(name = "checkBookFacade")
    private transient CheckBookFacade checkBookFacade;
    
    @Resource(name = "multiValueGroupFacade")
    private transient MultiValueGroupFacade multiValueGroupFacade;
    
    private transient StreamedContent exportCheckPdf;
    
    private transient StreamedContent exportCheckBookPdf;
    
    private transient StreamedContent exportCheckExcel;
    
    private transient StreamedContent exportCheckBookExcel;
    
    private String rutaCheckPdf;
    
    private String rutaCheckBookPdf;
    
    private String rutaCheckExcel;
    
    private String rutaCheckBookExcel;
    
    @Resource(name = "headerController")
    private transient HeaderController headerController;
    
    protected String RUTA_ICONO_BBVA = MessagesHelper.INSTANCE.getString("ruta.iconobbva");
    
    @Override
    public void init() {
        super.init();
        LOGGER.info("Initialize CheckBookControllerImpl");
    }
    
    public void initCheckBookList() {
        LOGGER.info(" CheckBookControllerImpl initCheckBookList ");
        this.checkBook = new ArrayList<CheckbookDto>();
        this.checkBookList = new ArrayList<CheckbookDto>();
        try {
            // Trae la lista para el combo de Busqueda por chequeras
            LOGGER.info("CheckBookControllerImpl initCheckBookList productId: " + getSelectedProduct().getProductId());
            this.checkBookList = checkBookFacade.getCheckBooksById(getSelectedProduct().getProductId());
        } catch (Exception e) {
            LOGGER.info("Error al llamar al servicio de getAccount");
            FacesContext cxt = FacesContext.getCurrentInstance();
            cxt.addMessage("checkBookList", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
        checkBooks = new ArrayList<SelectItem>(checkBookList.size());
        for (CheckbookDto value : checkBookList) {
            checkBooks.add(new SelectItem(value.getId()));
        }
        clean();
    }
    
    @Override
    public void cleanFilters(ActionEvent event) {
        LOGGER.info("CheckAccountController clean Filters");
        clean();
    }
    
    // <!-- Entelgy / GP-12834 / 08092015 / INICIO -->
    
    public void clean() {
        setSinceDatestr(new String());
        setToDatestr(new String());
        checkNumber = null;
        checkBookNumber = null;
        sinceDate = null;
        toDate = null;
        titleDateSince = "";
        titleDateTo = "";
        selectDate = StringUtils.EMPTY;
        dateRange = null;
        titleState = null;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public void nextPage(ActionEvent event) {
        getRenderComponents().put(RenderAttributes.TITLECHECKS.name(), true);
        getRenderComponents().put(RenderAttributes.CHECKTABLE.toString(), true);
        super.setCheckBookFacade(checkBookFacade);
        next();
        final List<CheckDto> cheksByStatus = (List<CheckDto>)CollectionUtils.select(getCurrentList(),
                new CheckStatusPredicate());
        this.checkList = cheksByStatus;
        hasMoreElementsCheck(this.checkList);
        setFalseMovementsComponents();
    }
    
    // <!-- Entelgy / GP-12834 / 08092015 / FIN -->
    
    // <!-- Entelgy / GP-12834 / 25112015 / INICIO -->
    
    @Override
    public void nextPageCheckBook(ActionEvent event) {
        getRenderComponents().put(RenderAttributes.TITLECHECKBOOKS.toString(), true);
        getRenderComponents().put(RenderAttributes.CHECKBOOKTABLE.toString(), true);
        getRenderComponents().put(RenderAttributes.FOOTERTABLECHECKBOOK.toString(), false);
        // this.checkBook.addAll(initialCheckBook.subList(5, initialCheckBook.size()));
    }
    
    // <!-- Entelgy / GP-12834 / 25112015 / FIN -->
    
    @Override
    public void oneSelectDate() {
        LOGGER.info(" CheckBookControllerImpl oneSelectDate " + getSelectDate());
        getRenderComponents().put(RenderAttributes.FILTERDATECHECK.toString(), true);
        getRenderComponents().put(RenderAttributes.FILTERCHECKBOOK.toString(), false);
        getRenderComponents().put(RenderAttributes.FILTERNUMBERCHECK.toString(), false);
        if ( getSelectDate().equals(CONCRETE_DATE) ) {
            getRenderComponents().put(RenderAttributes.CALENDARCHECK.toString(), false);
            LOGGER.info(" CheckBookControllerImpl oneSelectDate es igual CONCRETE_DATE " + getSelectDate() + "  "
                    + getRenderComponents().get(RenderAttributes.CALENDARCHECK.toString()));
        } else {
            getRenderComponents().put(RenderAttributes.CALENDARCHECK.toString(), true);
            LOGGER.info(" CheckBookControllerImpl oneSelectDate no es igual CONCRETE_DATE" + getSelectDate() + "  "
                    + getRenderComponents().get(RenderAttributes.CALENDARCHECK.toString()));
        }
    }
    
    @Override
    public void radioActionState() {
        LOGGER.info(SEARCH_CHECK + " " + SEARCH_BY_NUMBER_CHECK + " CheckBookControllerImpl actionState "
                + getActionState());
        if ( getActionState().equals(SEARCH_CHECK) ) {
            LOGGER.info(" CheckBookControllerImpl actionState entro a SEARCH_CHECK " + SEARCH_CHECK);
            
            getRenderComponents().put(RenderAttributes.BUTTONBOOK.toString(), false);
            getRenderComponents().put(RenderAttributes.FILTERCHECKBOOK.toString(), true);
            getRenderComponents().put(RenderAttributes.NUMBERBOOK.toString(), false);
            
            getRenderComponents().put(RenderAttributes.NUMBERCHECK.toString(), true);
            getRenderComponents().put(RenderAttributes.STATUS.toString(), true);
            getRenderComponents().put(RenderAttributes.RADIOSTATUS.toString(), false);
            
            getRenderComponents().put(RenderAttributes.FILTERNUMBERCHECK.toString(), false);
            getRenderComponents().put(RenderAttributes.FILTERDATECHECK.toString(), false);
            
            LOGGER.info("getRenderComponents(). FILTERCHECKBOOK"
                    + getRenderComponents().get(RenderAttributes.FILTERCHECKBOOK.toString()));
            LOGGER.info("getRenderComponents(). NUMBERBOOK"
                    + getRenderComponents().get(RenderAttributes.NUMBERBOOK.toString()));
            LOGGER.info("getRenderComponents(). BUTTONBOOK"
                    + getRenderComponents().get(RenderAttributes.BUTTONBOOK.toString()));
                    
        } else if ( getActionState().equals(SEARCH_BY_NUMBER_CHECK) ) {
            LOGGER.info(" CheckBookControllerImpl actionState entro a SEARCH_BY_NUMBER_CHECK " + SEARCH_BY_NUMBER_CHECK);
            
            getRenderComponents().put(RenderAttributes.BUTTONBOOK.toString(), false);
            getRenderComponents().put(RenderAttributes.FILTERNUMBERCHECK.toString(), true);
            getRenderComponents().put(RenderAttributes.NUMBERCHECK.toString(), false);
            getRenderComponents().put(RenderAttributes.STATUS.toString(), false);
            getRenderComponents().put(RenderAttributes.RADIOSTATUS.toString(), true);
            
            getRenderComponents().put(RenderAttributes.NUMBERBOOK.toString(), true);
            
            getRenderComponents().put(RenderAttributes.FILTERCHECKBOOK.toString(), false);
            getRenderComponents().put(RenderAttributes.FILTERDATECHECK.toString(), false);
            
            LOGGER.info("getRenderComponents(). FILTERNUMBERCHECK"
                    + getRenderComponents().get(RenderAttributes.FILTERNUMBERCHECK.toString()));
            LOGGER.info("getRenderComponents(). NUMBERCHECK"
                    + getRenderComponents().get(RenderAttributes.NUMBERCHECK.toString()));
            LOGGER.info("getRenderComponents(). STATUS" + getRenderComponents().get(RenderAttributes.STATUS.toString()));
        }
    }
    
    @Override
    public void setCustomDate(final AjaxBehaviorEvent event) {
        LOGGER.info(" CheckBookControllerImpl setCustomDate ");
        getRenderComponents().put(RenderAttributes.FILTERDATE.toString(), true);
        this.dateRange = new DateRangeDto();
        this.dateRange.setDateSince(getSinceDate());
        this.dateRange.setDateTo(getToDate());
        if ( !(getSinceDate() == (null)) && !(getToDate() == (null)) && getSelectDate().equals(CONCRETE_DATE) ) {
            titleDateSince = SINCE_TITLE + ":";
            titleDateTo = TO_TITLE + ":";
            sinceDatestr = DateUtils.format(getSinceDate(), "dd/MM/yyyy");
            toDatestr = DateUtils.format(getToDate(), "dd/MM/yyyy");
        } else {
            setTitleDateSince("");
            setTitleDateTo("");
            sinceDatestr = getSelectDate();
            toDatestr = "";
            setSinceDate(null);
            setToDate(null);
        }
    }
    
    @Override
    public void setNumberCheckOrBook(final AjaxBehaviorEvent event) {
        LOGGER.info(" CheckBookControllerImpl setNumberCheckOrBook ");
        radioActionState();
        if ( getRenderComponents().get(RenderAttributes.FILTERNUMBERCHECK.toString()) ) {
            
            if ( getCheckState() != null && !getCheckState().isEmpty() ) {
                leftTitle2 = " Estado ";
                setTitleState(EnumCheckStatus.valueOf(Integer.parseInt(getCheckState())).getValue());
                rightTitle2 = getTitleState();
            } else {
                leftTitle2 = " Estado ";
                setTitleState("Ninguno");
                rightTitle2 = getTitleState();
            }
            
            if ( getCheckNumber() != null && !getCheckNumber().isEmpty() ) {
                leftTitle = " Nº Cheque ";
                rightTitle = getCheckNumber();
            } else {
                leftTitle = " Nº Cheque ";
                rightTitle = "todos";
            }
            
        } else if ( getRenderComponents().get(RenderAttributes.FILTERCHECKBOOK.toString()) ) {
            
            if ( getCheckBookNumber() != null && !getCheckBookNumber().isEmpty() ) {
                leftTitle = " Talonario: ";
                rightTitle = getCheckBookNumber();
                
                leftTitle2 = "";
                rightTitle2 = "";
            } else {
                leftTitle = " Talonario: ";
                rightTitle = "Todos";
                
                leftTitle2 = "";
                rightTitle2 = "";
            }
        }
    }
    
    // <!-- Entelgy / GP-12834 / 08092015 / INICIO -->
    @Override
    public void showResults(final AjaxBehaviorEvent event) {
        LOGGER.info(" CheckBookControllerImpl showResults ");
        
        setFalseMovementsComponents();
        this.checkList = new ArrayList<CheckDto>();
        this.checkBook = new ArrayList<CheckbookDto>();
        
        if ( getRenderComponents().get(RenderAttributes.FILTERNUMBERCHECK.toString()) ) {
            LOGGER.info("CheckBookControllerImpl showResults FILTERNUMBERCHECK, FILTERSTATUS render");
            
            setFalseCheckBookComponents();
            getRenderComponents().put(RenderAttributes.TITLECHECKS.name(), true);
            getRenderComponents().put(RenderAttributes.CHECKTABLE.toString(), true);
            
            if ( getCheckNumber() != null && !getCheckNumber().isEmpty() ) {
                try {
                    LOGGER.info(" CheckBookControllerImpl showResults filterByCheckBook checkId: " + getCheckNumber());
                    this.check = checkBookFacade.getCheckById(getSelectedProduct().getProductId(), getCheckNumber());
                } catch (Exception e) {
                    FacesContext ctx = FacesContext.getCurrentInstance();
                    ctx.addMessage("check", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
                    this.check = new CheckDto();
                }
                
                if ( getTitleState() != null && !getTitleState().equals("Ninguno") ) {
                    LOGGER.info(" CheckBookControllerImpl showResults filterByCheckBook, filterByStatus ");
                    List<CheckDto> select = new ArrayList<CheckDto>();
                    select.add(check);
                    select = getListCheckById(select);
                    for (CheckDto value : select) {
                        if ( value.getStatus().equals(getTitleState()) && value.getStatus() != null ) {
                            checkList.add(value);
                        }
                    }
                    hasMoreElementsCheck(this.checkList);
                } else {
                    LOGGER.info(" CheckBookControllerImpl showResults filterByCheckBook ");
                    
                    this.checkList.add(check);
                    this.checkList = getListCheckById(checkList);
                    hasMoreElementsCheck(this.checkList);
                }
                
            } else if ( getTitleState() != null && !getTitleState().equals("Ninguno") ) {
                LOGGER.info(" CheckBookControllerImpl showResults filterByStatus ");
                this.dateRange = null;
                criteriaSearch();
            } else {
                LOGGER.info(" CheckBookControllerImpl showResults sin filtro cheques");
                EnumPeriodType periodType = EnumPeriodType.valueOfLabel(MessagesHelper.INSTANCE
                        .getString("select.radio.45.days"));
                dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
                criteriaSearch();
            }
            resetMapResults();
            
        } else if ( getRenderComponents().get(RenderAttributes.FILTERCHECKBOOK.toString()) ) {
            LOGGER.info("CheckBookControllerImpl showResults FILTERCHECKBOOK render");
            
            setFalseCheckComponents();
            getRenderComponents().put(RenderAttributes.TITLECHECKBOOKS.name(), true);
            getRenderComponents().put(RenderAttributes.CHECKBOOKTABLE.toString(), true);
            
            LOGGER.info(" CheckBookControllerImpl showResults filterByNumberCheck ");
            // <!-- Entelgy / GP-12834 / 25112015 / INICIO -->
            try {
                LOGGER.info(" CheckBookControllerImpl showResults filterByNumberCheck checkBookNumber: " + getCheckBookNumber());
                String temp = (StringUtils.leftPad(getCheckBookNumber(), 20, "0"));
                this.initialCheckBook = checkBookFacade.getCheckBookByAccountId(getSelectedProduct().getProductId(), temp);
                this.checkBook.add(initialCheckBook);
                this.checkBook = getListCheckBookById(checkBook);
            } catch (Exception e) {
                FacesContext ctx = FacesContext.getCurrentInstance();
                ctx.addMessage("CheckBookById", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
                this.checkBook = new ArrayList<CheckbookDto>();
            }
            resetMapResults();
            // <!-- Entelgy / GP-12834 / 25112015 / FIN -->
        } else if ( getRenderComponents().get(RenderAttributes.FILTERDATECHECK.toString()) ) {
            LOGGER.info("CheckBookControllerImpl showResults FILTERDATECHECK render");
            
            setFalseCheckBookComponents();
            getRenderComponents().put(RenderAttributes.TITLECHECKS.name(), true);
            getRenderComponents().put(RenderAttributes.CHECKTABLE.toString(), true);
            
            LOGGER.info(" CheckBookControllerImpl showResults filterByDateCheck ");
            EnumPeriodType periodType = EnumPeriodType.valueOfLabel(this.getSelectDate());
            if ( !(periodType == (null)) ) {
                dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
            }
            this.titleState = null;
            criteriaSearch();
        }
    }
    
    // <!-- Entelgy / GP-12834 / 08092015 / FIN -->
    
    @SuppressWarnings("unchecked")
    public List<CheckbookDto> getListCheckBookById(List<CheckbookDto> initial) {
        return (List<CheckbookDto>)CollectionUtils.select(initial, new CheckBookStatusPredicate());
    }
    
    @SuppressWarnings("unchecked")
    public List<CheckDto> getListCheckById(List<CheckDto> initial) {
        return (List<CheckDto>)CollectionUtils.select(initial, new CheckStatusPredicate());
    }
    
    @SuppressWarnings("unchecked")
    public void criteriaSearch() {
        LOGGER.info(" CheckBookControllerImpl criteriaSearch ");
        if ( this.dateRange != null ) {
            setDateRangePControl(this.dateRange);
        }
        if ( this.titleState != null ) {
            setStatusPControl(getCheckState());
        }
        super.init();
        super.setCheckBookFacade(checkBookFacade);
        search();
        final List<CheckDto> cheksByStatus = (List<CheckDto>)CollectionUtils.select(getCurrentList(),
                new CheckStatusPredicate());
        this.checkList = cheksByStatus;
        hasMoreElementsCheck(this.checkList);
    }
    
    @Override
    public void exportDocCheckPdf() {
        
        LOGGER.info("iniciando exportar archivo pdf");
        
        rutaCheckPdf = "Cheques" + getSelectedProduct().getProductNumber() + ".pdf";
        headerController.setLastDownload(rutaCheckPdf);
        try {
            
            FileOutputStream file = null;
            
            try {
                file = new FileOutputStream(rutaCheckPdf);
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
            
            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidthPercentage(90);
            
            com.itextpdf.text.Font font = new com.itextpdf.text.Font(FontFamily.HELVETICA, 8,
                    com.itextpdf.text.Font.BOLD, BaseColor.BLACK);
            com.itextpdf.text.Font fontNormal = new com.itextpdf.text.Font(FontFamily.HELVETICA, 8,
                    com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
            com.itextpdf.text.Font fontBlue = new com.itextpdf.text.Font(FontFamily.HELVETICA, 8,
                    com.itextpdf.text.Font.BOLD, new BaseColor(0, 80, 152));
            tabla.setSpacingBefore(20);
            tabla.setSpacingAfter(20);
            
            PdfPCell cheque = new PdfPCell(new Phrase("N° CHEQUE", font));
            cheque.setHorizontalAlignment(Element.ALIGN_CENTER);
            cheque.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cheque.setBackgroundColor(new BaseColor(229, 229, 229));
            tabla.addCell(cheque);
            
            PdfPCell dateIng = new PdfPCell(new Phrase("FECHA EMISIÓN", font));
            dateIng.setHorizontalAlignment(Element.ALIGN_CENTER);
            dateIng.setVerticalAlignment(Element.ALIGN_MIDDLE);
            dateIng.setBackgroundColor(new BaseColor(229, 229, 229));
            tabla.addCell(dateIng);
            
            PdfPCell value = new PdfPCell(new Phrase("VALOR", font));
            value.setHorizontalAlignment(Element.ALIGN_CENTER);
            value.setVerticalAlignment(Element.ALIGN_MIDDLE);
            value.setBackgroundColor(new BaseColor(229, 229, 229));
            tabla.addCell(value);
            
            PdfPCell stateAc = new PdfPCell(new Phrase("ESTADO ACTUAL", font));
            stateAc.setHorizontalAlignment(Element.ALIGN_CENTER);
            stateAc.setVerticalAlignment(Element.ALIGN_MIDDLE);
            stateAc.setBackgroundColor(new BaseColor(229, 229, 229));
            tabla.addCell(stateAc);
            
            PdfPCell datestateAc = new PdfPCell(new Phrase("FECHA CAMBIO ESTADO", font));
            datestateAc.setHorizontalAlignment(Element.ALIGN_CENTER);
            datestateAc.setVerticalAlignment(Element.ALIGN_MIDDLE);
            datestateAc.setBackgroundColor(new BaseColor(229, 229, 229));
            tabla.addCell(datestateAc);
            
            if ( checkList != null && checkList.size() != 0 ) {
                
                for (int i = 0; i < checkList.size(); i++) {
                    
                    PdfPCell idCheck = new PdfPCell(new Phrase(checkList.get(i).getId(), fontBlue));
                    idCheck.setHorizontalAlignment(Element.ALIGN_CENTER);
                    idCheck.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    tabla.addCell(idCheck);
                    
                    String dateIss = super.getdateString(checkList.get(i).getIssueDate());
                    PdfPCell dateIssCheck = new PdfPCell(new Phrase(dateIss, fontNormal));
                    dateIssCheck.setHorizontalAlignment(Element.ALIGN_CENTER);
                    dateIssCheck.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    tabla.addCell(dateIssCheck);
                    
                    if ( checkList.get(i).getValue() != null ) {
                        PdfPCell valueCheck = new PdfPCell(new Phrase(checkList.get(i).getValue().toString(), font));
                        valueCheck.setHorizontalAlignment(Element.ALIGN_CENTER);
                        valueCheck.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tabla.addCell(valueCheck);
                    } else {
                        tabla.addCell(" ");
                    }
                    
                    PdfPCell statusCheck = new PdfPCell(new Phrase(checkList.get(i).getStatus(), fontNormal));
                    statusCheck.setHorizontalAlignment(Element.ALIGN_CENTER);
                    statusCheck.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    tabla.addCell(statusCheck);
                    
                    if ( checkList.get(i).getModifiedDate() != null ) {
                        PdfPCell dateModC = new PdfPCell(new Phrase(checkList.get(i).getModifiedDate()
                                .replace("/", "-"), fontNormal));
                        dateModC.setHorizontalAlignment(Element.ALIGN_CENTER);
                        dateModC.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tabla.addCell(dateModC);
                    } else {
                        tabla.addCell(" ");
                    }
                }
                
            } else if ( checkList == null || checkList.size() == 0 ) {
                
                PdfPCell nonee = new PdfPCell(new Phrase("No hay registros", font));
                nonee.setHorizontalAlignment(Element.ALIGN_CENTER);
                nonee.setVerticalAlignment(Element.ALIGN_MIDDLE);
                nonee.setBorder(Rectangle.BOX);
                nonee.setColspan(5);
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
    public void exportDocCheckBookPdf() {
        
        LOGGER.info("iniciando exportar archivo pdf");
        
        rutaCheckBookPdf = "Chequeras" + getSelectedProduct().getProductNumber() + ".pdf";
        headerController.setLastDownload(rutaCheckBookPdf);
        try {
            
            FileOutputStream file = null;
            
            try {
                file = new FileOutputStream(rutaCheckBookPdf);
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
            
            Paragraph title = new Paragraph("Información del producto", FontFactory.getFont("helvetica", 11,
                    new BaseColor(51, 51, 51)));
            title.setSpacingBefore(20);
            document.add(title);
            
            PdfPTable tabla = new PdfPTable(7);
            tabla.setWidthPercentage(90);
            tabla.setWidths(new float[] { 30f, 30f, 30f, 28f, 2f, 28f, 30f });
            
            com.itextpdf.text.Font font = new com.itextpdf.text.Font(FontFamily.HELVETICA, 9,
                    com.itextpdf.text.Font.BOLD, BaseColor.BLACK);
            com.itextpdf.text.Font fontNormal = new com.itextpdf.text.Font(FontFamily.HELVETICA, 9,
                    com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
            com.itextpdf.text.Font fontBlue = new com.itextpdf.text.Font(FontFamily.HELVETICA, 9,
                    com.itextpdf.text.Font.BOLD, new BaseColor(0, 80, 152));
            tabla.setSpacingBefore(20);
            tabla.setSpacingAfter(20);
            
            PdfPCell cheque = new PdfPCell(new Phrase("PRIMER CHEQUE", font));
            cheque.setBackgroundColor(new BaseColor(229, 229, 229));
            cheque.setHorizontalAlignment(Element.ALIGN_CENTER);
            cheque.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tabla.addCell(cheque);
            
            PdfPCell dateIng = new PdfPCell(new Phrase("ÚLTIMO CHEQUE", font));
            dateIng.setBackgroundColor(new BaseColor(229, 229, 229));
            dateIng.setHorizontalAlignment(Element.ALIGN_CENTER);
            dateIng.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tabla.addCell(dateIng);
            
            PdfPCell value = new PdfPCell(new Phrase("CHEQUES DISPONIBLES", font));
            value.setBackgroundColor(new BaseColor(229, 229, 229));
            value.setHorizontalAlignment(Element.ALIGN_CENTER);
            value.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tabla.addCell(value);
            
            PdfPCell stateAc = new PdfPCell(new Phrase("  FECHA PETICIÓN -\nFECHA ENTREGA", font));
            stateAc.setBackgroundColor(new BaseColor(229, 229, 229));
            stateAc.setHorizontalAlignment(Element.ALIGN_CENTER);
            stateAc.setVerticalAlignment(Element.ALIGN_MIDDLE);
            stateAc.setColspan(3);
            tabla.addCell(stateAc);
            
            PdfPCell datestateAc = new PdfPCell(new Phrase("ESTADO", font));
            datestateAc.setBackgroundColor(new BaseColor(229, 229, 229));
            datestateAc.setHorizontalAlignment(Element.ALIGN_CENTER);
            datestateAc.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tabla.addCell(datestateAc);
            
            if ( checkBook != null && checkBook.size() != 0 ) {
                
                for (int i = 0; i < checkBook.size(); i++) {
                    PdfPCell firstCheck = new PdfPCell(new Phrase(checkBook.get(i).getFirstCheck(), fontBlue));
                    firstCheck.setHorizontalAlignment(Element.ALIGN_CENTER);
                    firstCheck.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    tabla.addCell(firstCheck);
                    
                    PdfPCell lastCheck = new PdfPCell(new Phrase(checkBook.get(i).getLastCheck(), fontNormal));
                    lastCheck.setHorizontalAlignment(Element.ALIGN_CENTER);
                    lastCheck.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    tabla.addCell(lastCheck);
                    
                    PdfPCell totalCheck = new PdfPCell(new Phrase(checkBook.get(i).getTotalCheck(), fontNormal));
                    totalCheck.setHorizontalAlignment(Element.ALIGN_CENTER);
                    totalCheck.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    tabla.addCell(totalCheck);
                    
                    if ( checkBook.get(i).getRequestDate() != null ) {
                        // <!-- Entelgy / GP-12834 / 25112015 / INICIO -->
                        PdfPCell dateReq = new PdfPCell(new Phrase(getdateString(checkBook.get(i).getRequestDate()).replace("/", "-"), fontNormal));
                        // <!-- Entelgy / GP-12834 / 25112015 / FIN -->
                        dateReq.setBorder(Rectangle.BOTTOM);
                        dateReq.setHorizontalAlignment(Element.ALIGN_CENTER);
                        dateReq.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tabla.addCell(dateReq);
                    } else {
                        tabla.addCell(" ");
                    }
                    
                    PdfPCell lineDiv = new PdfPCell(new Phrase("-", fontNormal));
                    lineDiv.setBorder(Rectangle.BOTTOM);
                    lineDiv.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    tabla.addCell(lineDiv);
                    
                    if ( checkBook.get(i).getDeliveryDate() != null ) {
                        // <!-- Entelgy / GP-12834 / 25112015 / INICIO -->
                        PdfPCell dateDeli = new PdfPCell(new Phrase(getdateString(checkBook.get(i).getDeliveryDate()).replace("/", "-"), fontNormal));
                        // <!-- Entelgy / GP-12834 / 25112015 / FIN -->
                        dateDeli.setBorder(Rectangle.BOTTOM);
                        dateDeli.setHorizontalAlignment(Element.ALIGN_CENTER);
                        dateDeli.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tabla.addCell(dateDeli);
                    } else {
                        tabla.addCell(" ");
                    }
                    
                    PdfPCell state = new PdfPCell(new Phrase(checkBook.get(i).getActualState(), fontNormal));
                    state.setHorizontalAlignment(Element.ALIGN_CENTER);
                    state.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    tabla.addCell(state);
                }
            } else if ( checkBook == null || checkBook.size() == 0 ) {
                
                PdfPCell nonee = new PdfPCell(new Phrase("No hay registros", font));
                nonee.setHorizontalAlignment(Element.ALIGN_CENTER);
                nonee.setVerticalAlignment(Element.ALIGN_MIDDLE);
                nonee.setBorder(Rectangle.BOX);
                nonee.setColspan(5);
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
    
    @SuppressWarnings({ "deprecation", "resource" })
    @Override
    public void exportDocCheckExcel() {
        LOGGER.info("iniciando exportar archivo excel");
        
        File miDir = new File(".");
        try {
            LOGGER.info("Directorio actual: " + miDir.getCanonicalPath());
        } catch (Exception e) {
            LOGGER.info("No encontró directorio actual " + e.getMessage());
        }
        
        rutaCheckExcel = "Cheques" + getSelectedProduct().getProductNumber() + ".xls";
        headerController.setLastDownload(rutaCheckExcel);
        List<Cell> cellSheet = new ArrayList<Cell>();
        
        int inicio = 10;
        
        File archivoXLS = new File(rutaCheckExcel);
        if ( archivoXLS.exists() ) {
            archivoXLS.delete();
        }
        
        try {
            archivoXLS.createNewFile();
        } catch (IOException e) {
            LOGGER.info("Excepción al crear el archivo" + e.getMessage());
        }
        
        Workbook libro = new HSSFWorkbook();
        
        try {
            FileOutputStream archivo = new FileOutputStream(archivoXLS);
            Sheet hoja = libro.createSheet("Chequeras de cuenta");
            
            try {
                URL url = new URL(RUTA_ICONO_BBVA);
                InputStream is = url.openStream();
                ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
                int b;
                while ((b = is.read()) != -1) {
                    img_bytes.write(b);
                }
                
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
            
            if ( checkList != null && (this.checkList.size() != 0 || !this.checkList.isEmpty()) ) {
                
                Cell numberCheck = filaHeader.createCell(1);
                numberCheck.setCellType(Cell.CELL_TYPE_STRING);
                numberCheck.setCellStyle(cellStyleHeader);
                numberCheck.setCellValue("N° CHEQUE");
                cellSheet.add(numberCheck);
                
                Cell dateRea = filaHeader.createCell(2);
                dateRea.setCellType(Cell.CELL_TYPE_STRING);
                dateRea.setCellStyle(cellStyleHeader);
                dateRea.setCellValue("FECHA EMISIÓN");
                cellSheet.add(dateRea);
                
                Cell valueCheck = filaHeader.createCell(3);
                valueCheck.setCellType(Cell.CELL_TYPE_STRING);
                valueCheck.setCellStyle(cellStyleHeader);
                valueCheck.setCellValue("VALOR");
                cellSheet.add(valueCheck);
                
                Cell state = filaHeader.createCell(4);
                state.setCellType(Cell.CELL_TYPE_STRING);
                state.setCellStyle(cellStyleHeader);
                state.setCellValue("ESTADO ACTUAL");
                cellSheet.add(state);
                
                Cell dateState = filaHeader.createCell(5);
                dateState.setCellType(Cell.CELL_TYPE_STRING);
                dateState.setCellStyle(cellStyleHeader);
                dateState.setCellValue("FECHA CAMBIO ESTADO");
                cellSheet.add(dateState);
                
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 1));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 2, 2));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 3, 3));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 4, 4));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 5, 5));
                
            } else {
                
                Cell numberCheck = filaHeader.createCell(1);
                numberCheck.setCellType(Cell.CELL_TYPE_STRING);
                numberCheck.setCellStyle(cellStyleHeader);
                numberCheck.setCellValue("N° CHEQUE");
                hoja.autoSizeColumn(1);
                
                Cell dateRea = filaHeader.createCell(2);
                dateRea.setCellType(Cell.CELL_TYPE_STRING);
                dateRea.setCellStyle(cellStyleHeader);
                dateRea.setCellValue("FECHA EMISIÓN");
                hoja.autoSizeColumn(2);
                
                Cell valueCheck = filaHeader.createCell(3);
                valueCheck.setCellType(Cell.CELL_TYPE_STRING);
                valueCheck.setCellStyle(cellStyleHeader);
                valueCheck.setCellValue("VALOR");
                hoja.autoSizeColumn(3);
                
                Cell state = filaHeader.createCell(4);
                state.setCellType(Cell.CELL_TYPE_STRING);
                state.setCellStyle(cellStyleHeader);
                state.setCellValue("ESTADO ACTUAL");
                hoja.autoSizeColumn(4);
                
                Cell dateState = filaHeader.createCell(5);
                dateState.setCellType(Cell.CELL_TYPE_STRING);
                dateState.setCellStyle(cellStyleHeader);
                dateState.setCellValue("FECHA CAMBIO ESTADO");
                hoja.autoSizeColumn(5);
                
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 1));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 2, 2));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 3, 3));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 4, 4));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 5, 5));
            }
            
            inicio = inicio + 1;
            
            if ( checkList != null && (this.checkList.size() != 0 || !this.checkList.isEmpty()) ) {
                for (int f = 0; f < this.checkList.size(); f++) {
                    Row fila = hoja.createRow(f + inicio);
                    for (int c = 1; c < 6; c++) {
                        
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
                        
                        if ( c == 1 ) {
                            cellStyle.setFont(check);
                            super.createCell(celda, this.checkList.get(f).getId(), cellStyle);
                            cellSheet.add(celda);
                        }
                        if ( c == 2 ) {
                            String DateString = super.getdateString(this.checkList.get(f).getIssueDate());
                            super.createCell(celda, DateString, cellStyle);
                            cellSheet.add(celda);
                        }
                        if ( c == 3 ) {
                            super.createCellMoney(celda, this.checkList.get(f).getValue(), cellStyle);
                            cellSheet.add(celda);
                        }
                        if ( c == 4 ) {
                            super.createCell(celda, this.checkList.get(f).getStatus(), cellStyle);
                            cellSheet.add(celda);
                        }
                        
                        if ( c == 5 ) {
                            celda.setCellStyle(cellStyle);
                            if ( this.checkList.get(f).getModifiedDate() != null ) {
                                celda.setCellValue(this.checkList.get(f).getModifiedDate().replace("/", "-"));
                            } else {
                                celda.setCellValue(" ");
                            }
                            cellSheet.add(celda);
                        }
                        
                        hoja.addMergedRegion(new CellRangeAddress(f, f, 1, 1));
                        hoja.addMergedRegion(new CellRangeAddress(f, f, 2, 2));
                        hoja.addMergedRegion(new CellRangeAddress(f, f, 3, 3));
                        hoja.addMergedRegion(new CellRangeAddress(f, f, 4, 4));
                        hoja.addMergedRegion(new CellRangeAddress(f, f, 5, 5));
                    }
                }
                
                super.maxSize(cellSheet, hoja, 5);
                
                inicio = inicio + this.checkList.size() + 2;
                
            } else if ( checkList != null && (this.checkList.size() == 0 || this.checkList.isEmpty()) ) {
                
                Row filaOter = hoja.createRow(inicio);
                
                Cell celda = filaOter.createCell(1);
                Cell celda1 = filaOter.createCell(2);
                Cell celda2 = filaOter.createCell(3);
                Cell celda3 = filaOter.createCell(4);
                Cell celda4 = filaOter.createCell(5);
                
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
                celda4.setCellStyle(cellStyle);
                celda.setCellValue("No hay registros");
                
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 5));
                
                inicio = inicio + this.checkList.size() + 3;
            }
            
            Row filaFooter = hoja.createRow(inicio);
            filaFooter.createCell(1).setCellValue("Cordial saludo,");
            hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 5));
            
            Font bbvaAde = libro.createFont();
            bbvaAde.setColor(HSSFColor.BLUE.index);
            
            CellStyle bbvaStyle = libro.createCellStyle();
            bbvaStyle.setFont(bbvaAde);
            
            inicio = inicio + 1;
            
            filaFooter = hoja.createRow(inicio);
            Cell bbva = filaFooter.createCell(1);
            bbva.setCellStyle(bbvaStyle);
            bbva.setCellValue("BBVA Adelante");
            hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 5));
            
            inicio = inicio + 2;
            
            Font notaFont = libro.createFont();
            notaFont.setBold(true);
            
            CellStyle cellNotaStyle = libro.createCellStyle();
            cellNotaStyle.setVerticalAlignment(CellStyle.VERTICAL_JUSTIFY);
            cellNotaStyle.setFont(notaFont);
            
            filaFooter = hoja.createRow(inicio);
            Cell nota = filaFooter.createCell(1);
            nota.setCellStyle(cellNotaStyle);
            nota.setCellValue(
                    "Nota: Si no eres el destinatario de este mensaje, por favor comunícate con nosotros con el fin de realizar la actualización correspondiente, al 4010000 en Bogotá, 4938300 en Medellín, 3503500 en Barranquilla, 8892020 en Cali, 6304000 en Bucaramanga o al 01800 912227 desde el resto del país. ");
            filaFooter.setHeight((short)1100);
            hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 5));
            
            inicio = inicio + 2;
            
            CellStyle cellFooterStyle = libro.createCellStyle();
            cellFooterStyle.setVerticalAlignment(CellStyle.VERTICAL_JUSTIFY);
            
            filaFooter = hoja.createRow(inicio);
            filaFooter.createCell(1).setCellValue("********************* AVISO LEGAL **************************");
            hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 5));
            
            inicio = inicio + 1;
            filaFooter = hoja.createRow(inicio);
            Cell message = filaFooter.createCell(1);
            message.setCellStyle(cellFooterStyle);
            message.setCellValue(
                    "Este mensaje es solamente para la persona a la que va dirigido. Puede contener informacion  confidencial  o  legalmente  protegida.  No  hay  renuncia  a la confidencialidad o privilegio por cualquier transmision mala/erronea. Si usted ha recibido este mensaje por error,  le rogamos que borre de su sistema inmediatamente el mensaje asi como todas sus copias, destruya todas las copias del mismo de su disco duro y notifique al remitente.  No debe,  directa o indirectamente, usar, revelar, distribuir, imprimir o copiar ninguna de las partes de este mensaje si no es usted el destinatario. Cualquier opinion expresada en este mensaje proviene del remitente, excepto cuando el mensaje establezca lo contrario y el remitente este autorizado para establecer que dichas opiniones provienen de  BBVA. Notese que el correo electronico via Internet no permite asegurar ni la confidencialidad de los mensajes que se transmiten ni la correcta recepcion de los mismos. En el caso de que el destinatario de este mensaje no consintiera la utilizacion del correo electronico via Internet, rogamos lo ponga en nuestro conocimiento de manera inmediata.");
            filaFooter.setHeight((short)3500);
            hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 5));
            
            inicio = inicio + 2;
            
            filaFooter = hoja.createRow(inicio);
            filaFooter.createCell(1).setCellValue("**************************  DISCLAIMER**********************");
            hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 5));
            
            inicio = inicio + 1;
            
            filaFooter = hoja.createRow(inicio);
            Cell messEng = filaFooter.createCell(1);
            messEng.setCellStyle(cellFooterStyle);
            messEng.setCellValue(
                    "This message is intended exclusively for the named person. It may contain confidential, propietary or legally privileged information. No confidentiality or privilege is waived or lost by any mistransmission. If you receive this message in error, please immediately delete it and all copies of it from your system, destroy any hard copies of it and notify the sender. Your must not, directly or indirectly, use, disclose, distribute, print, or copy any part of this message if you are not the intended recipient. Any views expressed in this message are those of the individual sender, except where the message states otherwise and the sender is authorised to state them to be the views of BBVA. Please note that internet e-mail neither guarantees the confidentiality nor the proper receipt of the message sent.If the addressee of this message does not consent to the use of internet e-mail, please communicate it to us immediately.");
            filaFooter.setHeight((short)2900);
            hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 5));
            
            inicio = inicio + 1;
            
            filaFooter = hoja.createRow(inicio);
            filaFooter.createCell(1).setCellValue("************************************************************");
            hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 5));
            
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
    
    @SuppressWarnings({ "deprecation", "resource" })
    @Override
    public void exportDocCheckBookExcel() {
        LOGGER.info("iniciando exportar archivo excel");
        
        File miDir = new File(".");
        try {
            LOGGER.info("Directorio actual: " + miDir.getCanonicalPath());
        } catch (Exception e) {
            LOGGER.info("No encontró directorio actual " + e.getMessage());
        }
        rutaCheckBookExcel = "Chequeras" + getSelectedProduct().getProductNumber() + ".xls";
        headerController.setLastDownload(rutaCheckBookExcel);
        List<Cell> cellSheet = new ArrayList<Cell>();
        
        int inicio = 10;
        
        File archivoXLS = new File(rutaCheckBookExcel);
        if ( archivoXLS.exists() ) {
            archivoXLS.delete();
        }
        
        try {
            archivoXLS.createNewFile();
        } catch (IOException e) {
            LOGGER.info("Excepción al crear el archivo" + e.getMessage());
        }
        Workbook libro = new HSSFWorkbook();
        
        try {
            FileOutputStream archivo = new FileOutputStream(archivoXLS);
            Sheet hoja = libro.createSheet("Chequeras de cuenta");
            
            try {
                URL url = new URL(RUTA_ICONO_BBVA);
                InputStream is = url.openStream();
                ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
                int b;
                while ((b = is.read()) != -1) {
                    img_bytes.write(b);
                }
                
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
            CellStyle cellStyleHeader2 = libro.createCellStyle();
            
            cellStyleHeader2.setFont(text);
            cellStyleHeader2.setWrapText(true);
            cellStyleHeader2.setBorderBottom((short)1);
            cellStyleHeader2.setBorderTop((short)1);
            cellStyleHeader2.setAlignment(CellStyle.ALIGN_CENTER);
            
            cellStyleHeader.setFont(text);
            cellStyleHeader.setWrapText(true);
            cellStyleHeader.setBorderBottom((short)1);
            cellStyleHeader.setBorderLeft((short)1);
            cellStyleHeader.setBorderRight((short)1);
            cellStyleHeader.setBorderTop((short)1);
            cellStyleHeader.setAlignment(CellStyle.ALIGN_CENTER);
            
            if ( checkBook != null && (this.checkBook.size() != 0 || !this.checkBook.isEmpty()) ) {
                
                Cell fistCheq = filaHeader.createCell(1);
                fistCheq.setCellStyle(cellStyleHeader);
                fistCheq.setCellValue("PRIMER CHEQUE");
                cellSheet.add(fistCheq);
                
                Cell lastCheq = filaHeader.createCell(2);
                lastCheq.setCellStyle(cellStyleHeader);
                lastCheq.setCellValue("ÚLTIMO CHEQUE");
                cellSheet.add(lastCheq);
                
                Cell avalCheck = filaHeader.createCell(3);
                avalCheck.setCellStyle(cellStyleHeader);
                avalCheck.setCellValue("CHEQUES DISPONIBLES");
                cellSheet.add(avalCheck);
                
                Cell dates1 = filaHeader.createCell(4);
                dates1.setCellStyle(cellStyleHeader2);
                dates1.setCellValue("FECHA PETICIÓN");
                cellSheet.add(dates1);
                
                Cell dates2 = filaHeader.createCell(5);
                dates2.setCellStyle(cellStyleHeader2);
                dates2.setCellValue(" - ");
                cellSheet.add(dates2);
                
                Cell dates3 = filaHeader.createCell(6);
                dates3.setCellStyle(cellStyleHeader2);
                dates3.setCellValue("FECHA ENTREGA");
                cellSheet.add(dates3);
                
                Cell state = filaHeader.createCell(7);
                state.setCellStyle(cellStyleHeader);
                state.setCellValue("ESTADO");
                cellSheet.add(state);
                
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 1));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 2, 2));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 3, 3));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 4, 4));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 5, 5));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 6, 6));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 7, 7));
                
            } else {
                
                Cell fistCheq = filaHeader.createCell(1);
                fistCheq.setCellStyle(cellStyleHeader);
                fistCheq.setCellValue("PRIMER CHEQUE");
                hoja.autoSizeColumn(1);
                
                Cell lastCheq = filaHeader.createCell(2);
                lastCheq.setCellStyle(cellStyleHeader);
                lastCheq.setCellValue("ÚLTIMO CHEQUE");
                hoja.autoSizeColumn(2);
                
                Cell avalCheck = filaHeader.createCell(3);
                avalCheck.setCellStyle(cellStyleHeader);
                avalCheck.setCellValue("CHEQUES DISPONIBLES");
                hoja.autoSizeColumn(3);
                
                Cell dates = filaHeader.createCell(4);
                dates.setCellStyle(cellStyleHeader);
                dates.setCellValue("FECHA PETICIÓN - FECHA ENTREGA");
                hoja.autoSizeColumn(4);
                
                Cell state = filaHeader.createCell(5);
                state.setCellStyle(cellStyleHeader);
                state.setCellValue("ESTADO");
                hoja.autoSizeColumn(5);
                
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 1));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 2, 2));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 3, 3));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 4, 4));
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 5, 5));
            }
            
            inicio = inicio + 1;
            
            if ( checkBook != null && (this.checkBook.size() != 0 || !this.checkBook.isEmpty()) ) {
                
                for (int f = 0; f < this.checkBook.size(); f++) {
                    Row fila = hoja.createRow(f + inicio);
                    for (int c = 1; c < 8; c++) {
                        
                        Font book = libro.createFont();
                        book.setFontHeightInPoints((short)10);
                        book.setFontName("Arial");
                        book.setBold(true);
                        book.setColor(HSSFColor.BLUE.index);
                        
                        Cell celda = fila.createCell(c);
                        CellStyle cellStyle = libro.createCellStyle();
                        CellStyle cellStyleDtae = libro.createCellStyle();
                        
                        cellStyleDtae.setAlignment(CellStyle.ALIGN_CENTER);
                        cellStyleDtae.setBorderBottom((short)1);
                        cellStyleDtae.setBorderTop((short)1);
                        cellStyleDtae.setWrapText(true);
                        
                        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
                        cellStyle.setBorderBottom((short)1);
                        cellStyle.setBorderLeft((short)1);
                        cellStyle.setBorderRight((short)1);
                        cellStyle.setBorderTop((short)1);
                        cellStyle.setWrapText(true);
                        
                        if ( c == 1 ) {
                            cellStyle.setFont(book);
                            super.createCell(celda, this.checkBook.get(f).getFirstCheck(), cellStyle);
                            cellSheet.add(celda);
                        }
                        if ( c == 2 ) {
                            celda.setCellStyle(cellStyle);
                            super.createCell(celda, this.checkBook.get(f).getLastCheck(), cellStyle);
                            cellSheet.add(celda);
                        }
                        if ( c == 3 ) {
                            celda.setCellStyle(cellStyle);
                            super.createCell(celda, this.checkBook.get(f).getTotalCheck(), cellStyle);
                            cellSheet.add(celda);
                        }
                        if ( c == 4 ) {
                            celda.setCellStyle(cellStyleDtae);
                            if ( this.checkBook.get(f).getRequestDate() != null ) {
                                // <!-- Entelgy / GP-12834 / 25112015 / INICIO -->
                                celda.setCellValue(getdateString(this.checkBook.get(f).getRequestDate()).replace("/", "-"));
                                // <!-- Entelgy / GP-12834 / 25112015 / FIN -->
                            } else {
                                celda.setCellValue(" ");
                            }
                            cellSheet.add(celda);
                        }
                        
                        if ( c == 5 ) {
                            celda.setCellStyle(cellStyleDtae);
                            celda.setCellValue(" - ");
                            cellSheet.add(celda);
                        }
                        
                        if ( c == 6 ) {
                            celda.setCellStyle(cellStyleDtae);
                            if ( this.checkBook.get(f).getDeliveryDate() != null ) {
                                // <!-- Entelgy / GP-12834 / 25112015 / INICIO -->
                                celda.setCellValue(getdateString(this.checkBook.get(f).getDeliveryDate()).replace("/", "-"));
                                // <!-- Entelgy / GP-12834 / 25112015 / FIN -->
                            } else {
                                celda.setCellValue(" ");
                            }
                            cellSheet.add(celda);
                        }
                        if ( c == 7 ) {
                            celda.setCellStyle(cellStyle);
                            super.createCell(celda, this.checkBook.get(f).getActualState(), cellStyle);
                            cellSheet.add(celda);
                        }
                        
                        hoja.addMergedRegion(new CellRangeAddress(f, f, 1, 1));
                        hoja.addMergedRegion(new CellRangeAddress(f, f, 2, 2));
                        hoja.addMergedRegion(new CellRangeAddress(f, f, 3, 3));
                        hoja.addMergedRegion(new CellRangeAddress(f, f, 4, 4));
                        hoja.addMergedRegion(new CellRangeAddress(f, f, 5, 5));
                        hoja.addMergedRegion(new CellRangeAddress(f, f, 6, 6));
                        hoja.addMergedRegion(new CellRangeAddress(f, f, 7, 7));
                    }
                }
                
                super.maxSize(cellSheet, hoja, 7);
                
                inicio = inicio + this.checkBook.size() + 3;
                
            } else if ( checkBook != null && (this.checkBook.size() == 0 || this.checkBook.isEmpty()) ) {
                
                Row filaOter = hoja.createRow(inicio);
                
                Cell celda = filaOter.createCell(1);
                Cell celda1 = filaOter.createCell(2);
                Cell celda2 = filaOter.createCell(3);
                Cell celda3 = filaOter.createCell(4);
                Cell celda4 = filaOter.createCell(5);
                
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
                celda4.setCellStyle(cellStyle);
                celda.setCellValue("No hay registros");
                
                hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 5));
                
                inicio = inicio + this.checkBook.size() + 3;
            }
            
            Row filaFooter = hoja.createRow(inicio);
            filaFooter.createCell(1).setCellValue("Cordial saludo,");
            hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 7));
            
            Font bbvaAde = libro.createFont();
            bbvaAde.setColor(HSSFColor.BLUE.index);
            
            CellStyle bbvaStyle = libro.createCellStyle();
            bbvaStyle.setFont(bbvaAde);
            
            inicio = inicio + 1;
            
            filaFooter = hoja.createRow(inicio);
            Cell bbva = filaFooter.createCell(1);
            bbva.setCellStyle(bbvaStyle);
            bbva.setCellValue("BBVA Adelante");
            hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 7));
            
            inicio = inicio + 2;
            
            Font notaFont = libro.createFont();
            notaFont.setBold(true);
            
            CellStyle cellNotaStyle = libro.createCellStyle();
            cellNotaStyle.setVerticalAlignment(CellStyle.VERTICAL_JUSTIFY);
            cellNotaStyle.setFont(notaFont);
            
            filaFooter = hoja.createRow(inicio);
            Cell nota = filaFooter.createCell(1);
            nota.setCellStyle(cellNotaStyle);
            nota.setCellValue(
                    "Nota: Si no eres el destinatario de este mensaje, por favor comunícate con nosotros con el fin de realizar la actualización correspondiente, al 4010000 en Bogotá, 4938300 en Medellín, 3503500 en Barranquilla, 8892020 en Cali, 6304000 en Bucaramanga o al 01800 912227 desde el resto del país. ");
            filaFooter.setHeight((short)1100);
            hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 7));
            
            inicio = inicio + 2;
            
            CellStyle cellFooterStyle = libro.createCellStyle();
            cellFooterStyle.setVerticalAlignment(CellStyle.VERTICAL_JUSTIFY);
            
            filaFooter = hoja.createRow(inicio);
            filaFooter.createCell(1).setCellValue("********************* AVISO LEGAL **************************");
            hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 7));
            
            inicio = inicio + 1;
            filaFooter = hoja.createRow(inicio);
            Cell message = filaFooter.createCell(1);
            message.setCellStyle(cellFooterStyle);
            message.setCellValue(
                    "Este mensaje es solamente para la persona a la que va dirigido. Puede contener informacion  confidencial  o  legalmente  protegida.  No  hay  renuncia  a la confidencialidad o privilegio por cualquier transmision mala/erronea. Si usted ha recibido este mensaje por error,  le rogamos que borre de su sistema inmediatamente el mensaje asi como todas sus copias, destruya todas las copias del mismo de su disco duro y notifique al remitente.  No debe,  directa o indirectamente, usar, revelar, distribuir, imprimir o copiar ninguna de las partes de este mensaje si no es usted el destinatario. Cualquier opinion expresada en este mensaje proviene del remitente, excepto cuando el mensaje establezca lo contrario y el remitente este autorizado para establecer que dichas opiniones provienen de  BBVA. Notese que el correo electronico via Internet no permite asegurar ni la confidencialidad de los mensajes que se transmiten ni la correcta recepcion de los mismos. En el caso de que el destinatario de este mensaje no consintiera la utilizacion del correo electronico via Internet, rogamos lo ponga en nuestro conocimiento de manera inmediata.");
            filaFooter.setHeight((short)3100);
            hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 7));
            
            inicio = inicio + 2;
            
            filaFooter = hoja.createRow(inicio);
            filaFooter.createCell(1).setCellValue("**************************  DISCLAIMER**********************");
            hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 7));
            
            inicio = inicio + 1;
            
            filaFooter = hoja.createRow(inicio);
            Cell messEng = filaFooter.createCell(1);
            messEng.setCellStyle(cellFooterStyle);
            messEng.setCellValue(
                    "This message is intended exclusively for the named person. It may contain confidential, propietary or legally privileged information. No confidentiality or privilege is waived or lost by any mistransmission. If you receive this message in error, please immediately delete it and all copies of it from your system, destroy any hard copies of it and notify the sender. Your must not, directly or indirectly, use, disclose, distribute, print, or copy any part of this message if you are not the intended recipient. Any views expressed in this message are those of the individual sender, except where the message states otherwise and the sender is authorised to state them to be the views of BBVA. Please note that internet e-mail neither guarantees the confidentiality nor the proper receipt of the message sent.If the addressee of this message does not consent to the use of internet e-mail, please communicate it to us immediately.");
            filaFooter.setHeight((short)2600);
            hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 7));
            
            inicio = inicio + 1;
            
            filaFooter = hoja.createRow(inicio);
            filaFooter.createCell(1).setCellValue("************************************************************");
            hoja.addMergedRegion(new CellRangeAddress(inicio, inicio, 1, 7));
            
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
    
    @Override
    public void printCheck() {
        printFile("Checks");
    }
    
    @Override
    public void printCheckBook() {
        printFile("CheckBook");
    }
    
    public void printFile(String typeDoc) {
        
        File pdfFile = null;
        
        if ( typeDoc.equals("Checks") ) {
            pdfFile = new File("Cheques" + getSelectedProduct().getProductNumber() + ".pdf");
        }
        
        if ( typeDoc.equals("CheckBook") ) {
            pdfFile = new File("Chequeras" + getSelectedProduct().getProductNumber() + ".pdf");
        }
        
        LOGGER.info("printFile ruta de archivo " + pdfFile.getAbsolutePath());
        
        if ( pdfFile.exists() ) {
            if ( pdfFile.delete() ) {
                LOGGER.info("borró el archivo " + pdfFile.getAbsolutePath());
                if ( typeDoc.equals("Checks") ) {
                    exportDocCheckPdf();
                }
                if ( typeDoc.equals("CheckBook") ) {
                    exportDocCheckBookPdf();
                }
            } else {
                LOGGER.info("No lo borró");
            }
            
        } else {
            LOGGER.info("crea el archivo " + pdfFile.getAbsolutePath());
            if ( typeDoc.equals("Checks") ) {
                exportDocCheckPdf();
            }
            if ( typeDoc.equals("CheckBook") ) {
                exportDocCheckBookPdf();
            }
            
        }
        
        String s = System.getProperty("os.name").toLowerCase();
        if ( s.contains("win") ) {
            createCommand("explorer", "%s", pdfFile.getAbsolutePath());
        }
        
        if ( s.contains("mac") ) {
            createCommand("open", "%s", pdfFile.getAbsolutePath());
        }
        
        if ( s.contains("linux") || s.contains("unix") ) {
            createCommand("kde-open", "%s", pdfFile.getAbsolutePath());
            createCommand("gnome-open", "%s", pdfFile.getAbsolutePath());
            createCommand("xdg-open", "%s", pdfFile.getAbsolutePath());
        }
        
    }
    
    private boolean createCommand(String command, String args, String file) {
        
        LOGGER.info("Probando comando exec:\n   cmd = " + command + "\n   args = " + args + "\n   %s = " + file);
        
        List<String> parts = new ArrayList<String>();
        parts.add(command);
        
        if ( args != null ) {
            for (String s : args.split(" ")) {
                s = String.format(s, file);
                parts.add(s.trim());
            }
        }
        
        String[] sParts = parts.toArray(new String[parts.size()]);
        
        try {
            Process p = Runtime.getRuntime().exec(sParts);
            LOGGER.info(" Proceso input " + p.toString());
            
            if ( p == null ) {
                return false;
            }
            
            LOGGER.info("Inicia la terminación de proceso");
            try {
                int retval = p.exitValue();
                if ( retval == 0 ) {
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
    
    public void addResetValue(ValueChangeEvent valueChangeEvent) {
        String data = valueChangeEvent.getNewValue().toString();
        System.out.println(data);
    }
    
    // <!-- Entelgy / GP-12834 / 08092015 / INICIO -->
    
    public void hasMoreElementsCheck(List<CheckDto> cheksList) {
        if ( cheksList.size() >= 9 && super.isHasMorePages() ) {
            getRenderComponents().put(RenderAttributes.FOOTERTABLECHEKS.toString(), true);
        } else {
            getRenderComponents().put(RenderAttributes.FOOTERTABLECHEKS.toString(), false);
        }
        
    }
    
    public void hasMoreElementsCheckBook(List<CheckbookDto> cheksBooks) {
        if ( cheksBooks.size() >= 5 ) {
            this.checkBook.addAll(cheksBooks.subList(0, 5));
            getRenderComponents().put(RenderAttributes.FOOTERTABLECHECKBOOK.toString(), true);
        } else {
            this.checkBook.addAll(cheksBooks);
            getRenderComponents().put(RenderAttributes.FOOTERTABLECHECKBOOK.toString(), false);
        }
    }
    
    // <!-- Entelgy / GP-12834 / 08092015 / FIN -->
    
    public void setFalseMovementsComponents() {
        getRenderComponents().put(RenderAttributes.TITLEMOVES.name(), false);
        getRenderComponents().put(RenderAttributes.MOVEMENTSTABLE.name(), false);
        getRenderComponents().put(RenderAttributes.FOOTERTABLEMOVEMENT.name(), false);
    }
    
    public void setFalseCheckComponents() {
        getRenderComponents().put(RenderAttributes.TITLECHECKS.name(), false);
        getRenderComponents().put(RenderAttributes.CHECKTABLE.name(), false);
        getRenderComponents().put(RenderAttributes.FOOTERTABLECHEKS.name(), false);
    }
    
    public void setFalseCheckBookComponents() {
        getRenderComponents().put(RenderAttributes.TITLECHECKBOOKS.name(), false);
        getRenderComponents().put(RenderAttributes.CHECKBOOKTABLE.name(), false);
        getRenderComponents().put(RenderAttributes.FOOTERTABLECHECKBOOK.name(), false);
    }
    
    public void resetMapResults() {
        LOGGER.info("Entro a ResetMapResults" + RenderAttributes.FILTERCHECKBOOK.toString() + " "
                + RenderAttributes.FILTERNUMBERCHECK.toString() + " " + RenderAttributes.FILTERDATECHECK.toString());
        getRenderComponents().put(RenderAttributes.FILTERCHECKBOOK.toString(), false);
        getRenderComponents().put(RenderAttributes.FILTERNUMBERCHECK.toString(), false);
        getRenderComponents().put(RenderAttributes.FILTERDATECHECK.toString(), false);
        
        LOGGER.info("Salio del ResetMapResults");
    }
    
    // Setters And Getters
    
    @Override
    public List<MultiValueGroup> getListMultiValueChecks() {
        return this.multiValueGroupFacade.getMultiValueTypes(LIST_CHECK_STATUS);
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
     * @return the actionState
     */
    public String getActionState() {
        return actionState;
    }
    
    /**
     * @param actionState the actionState to set
     */
    public void setActionState(String actionState) {
        this.actionState = actionState;
    }
    
    /**
     * @return the checkState
     */
    public String getCheckState() {
        return checkState;
    }
    
    /**
     * @param checkState the checkState to set
     */
    public void setCheckState(String checkState) {
        this.checkState = checkState;
    }
    
    /**
     * @return the checkBookNumber
     */
    public String getCheckBookNumber() {
        return checkBookNumber;
    }
    
    /**
     * @param checkBookNumber the checkBookNumber to set
     */
    public void setCheckBookNumber(String checkBookNumber) {
        this.checkBookNumber = checkBookNumber;
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
    
    /**
     * @return the toDatestr
     */
    public String getToDatestr() {
        return toDatestr;
    }
    
    /**
     * @param toDatestr the toDatestr to set
     */
    public void setToDatestr(String toDatestr) {
        this.toDatestr = toDatestr;
    }
    
    /**
     * @return the renderComponents
     */
    @SuppressWarnings("unchecked")
    public Map<String, Boolean> getRenderComponents() {
        return (Map<String, Boolean>)getViewVarView("renderComponents");
    }
    
    /**
     * @return the checkBook
     */
    public List<CheckbookDto> getCheckBook() {
        return checkBook;
    }
    
    /**
     * @return the checkBookList
     */
    public List<CheckbookDto> getCheckBookList() {
        return checkBookList;
    }
    
    /**
     * @param checkBook the checkBook to set
     */
    public void setCheckBook(List<CheckbookDto> checkBook) {
        this.checkBook = checkBook;
    }
    
    /**
     * @return the checkList
     */
    public List<CheckDto> getCheckList() {
        return checkList;
    }
    
    /**
     * @param checkList the checkList to set
     */
    public void setCheckList(List<CheckDto> checkList) {
        this.checkList = checkList;
    }
    
    /**
     * @param checkBookList the checkBookList to set
     */
    public void setCheckBookList(List<CheckbookDto> checkBookList) {
        this.checkBookList = checkBookList;
    }
    
    /**
     * @return the check
     */
    public CheckDto getCheck() {
        return check;
    }
    
    /**
     * @param check the check to set
     */
    public void setCheck(CheckDto check) {
        this.check = check;
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
     * @param checkBookFacade the checkBookFacade to set
     */
    @Override
    public void setCheckBookFacade(CheckBookFacade checkBookFacade) {
        this.checkBookFacade = checkBookFacade;
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
    
    /**
     * @return the leftTitle
     */
    public String getLeftTitle() {
        return leftTitle;
    }
    
    /**
     * @param leftTitle the leftTitle to set
     */
    public void setLeftTitle(String leftTitle) {
        this.leftTitle = leftTitle;
    }
    
    /**
     * @return the rightTitle
     */
    public String getRightTitle() {
        return rightTitle;
    }
    
    /**
     * @param rightTitle the rightTitle to set
     */
    public void setRightTitle(String rightTitle) {
        this.rightTitle = rightTitle;
    }
    
    /**
     * @return the checkNumber
     */
    public String getCheckNumber() {
        return checkNumber;
    }
    
    /**
     * @param checkNumber the checkNumber to set
     */
    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }
    
    /**
     * @return the checkBooks
     */
    public List<SelectItem> getCheckBooks() {
        return checkBooks;
    }
    
    /**
     * @param checkBooks the checkBooks to set
     */
    public void setCheckBooks(List<SelectItem> checkBooks) {
        this.checkBooks = checkBooks;
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
     * @return the titleState
     */
    public String getTitleState() {
        return titleState;
    }
    
    /**
     * @param titleState the titleState to set
     */
    public void setTitleState(String titleState) {
        this.titleState = titleState;
    }
    
    /**
     * @return the leftTitle2
     */
    public String getLeftTitle2() {
        return leftTitle2;
    }
    
    /**
     * @param leftTitle2 the leftTitle2 to set
     */
    public void setLeftTitle2(String leftTitle2) {
        this.leftTitle2 = leftTitle2;
    }
    
    /**
     * @return the rightTitle2
     */
    public String getRightTitle2() {
        return rightTitle2;
    }
    
    /**
     * @param rightTitle2 the rightTitle2 to set
     */
    public void setRightTitle2(String rightTitle2) {
        this.rightTitle2 = rightTitle2;
    }
    
    /**
     * @return the exportPdf
     */
    public StreamedContent getExportCheckPdf() {
        exportDocCheckPdf();
        InputStream stream;
        try {
            stream = new BufferedInputStream(new FileInputStream(rutaCheckPdf));
            exportCheckPdf = new DefaultStreamedContent(stream, "application/pdf", rutaCheckPdf);
        } catch (FileNotFoundException e) {
            LOGGER.info("Error al descargar el pdf " + e.getMessage());
        }
        return exportCheckPdf;
    }
    
    /**
     * @param exportPdf the exportPdf to set
     */
    public void setExportCheckPdf(StreamedContent exportPdf) {
        this.exportCheckPdf = exportPdf;
    }
    
    /**
     * @return the exportPdf
     */
    public StreamedContent getExportCheckBookPdf() {
        exportDocCheckBookPdf();
        InputStream stream;
        try {
            stream = new BufferedInputStream(new FileInputStream(rutaCheckBookPdf));
            exportCheckBookPdf = new DefaultStreamedContent(stream, "application/pdf", rutaCheckBookPdf);
        } catch (FileNotFoundException e) {
            LOGGER.info("Error al descargar el pdf " + e.getMessage());
        }
        return exportCheckBookPdf;
    }
    
    /**
     * @param exportPdf the exportPdf to set
     */
    public void setExportCheckBookPdf(StreamedContent exportPdf) {
        this.exportCheckBookPdf = exportPdf;
    }
    
    public StreamedContent getExportCheckExcel() {
        exportDocCheckExcel();
        InputStream stream;
        try {
            stream = new BufferedInputStream(new FileInputStream(rutaCheckExcel));
            exportCheckExcel = new DefaultStreamedContent(stream, "application/xls", rutaCheckExcel);
        } catch (FileNotFoundException e) {
            LOGGER.info("Error al descargar el Excel " + e.getMessage());
        }
        
        return exportCheckExcel;
    }
    
    public void setExportCheckExcel(StreamedContent exportExcel) {
        this.exportCheckExcel = exportExcel;
    }
    
    public StreamedContent getExportCheckBookExcel() {
        exportDocCheckBookExcel();
        InputStream stream;
        try {
            stream = new BufferedInputStream(new FileInputStream(rutaCheckBookExcel));
            exportCheckBookExcel = new DefaultStreamedContent(stream, "application/xls", rutaCheckBookExcel);
        } catch (FileNotFoundException e) {
            LOGGER.info("Error al descargar el Excel " + e.getMessage());
        }
        
        return exportCheckBookExcel;
    }
    
    public void setExportCheckBookExcel(StreamedContent exportExcel) {
        this.exportCheckBookExcel = exportExcel;
    }
    
    // <!-- Entelgy / GP-12834 / 25112015 / INICIO -->
    /**
     * @return the initialCheckBook
     */
    public CheckbookDto getInitialCheckBook() {
        return initialCheckBook;
    }
    
    /**
     * @param initialCheckBook the initialCheckBook to set
     */
    public void setInitialCheckBook(CheckbookDto initialCheckBook) {
        this.initialCheckBook = initialCheckBook;
    }
    
    // <!-- Entelgy / GP-12834 / 25112015 / FIN -->
    
    // <!-- Entelgy / GP-12834 / 17112015 / INICIO -->
    
    public HeaderController getHeaderController() {
        return headerController;
    }
    
    public void setHeaderController(HeaderController headerController) {
        this.headerController = headerController;
    }
    
    // <!-- Entelgy / GP-12834 / 17112015 / FIN -->
}