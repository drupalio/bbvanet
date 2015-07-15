package com.bbva.net.front.controller.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.facade.TermasAccountsFacade;
import com.bbva.net.back.model.accounts.DetailConditionsDto;
import com.bbva.net.back.model.accounts.PostalAddresDto;
import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.front.controller.TermsController;
import com.bbva.net.front.core.AbstractBbvaController;
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
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TermsControllerImpl extends AbstractBbvaController implements TermsController {

	/**
	 * 
	 */
	@Resource(name = "TermsFacade")
	private transient TermasAccountsFacade detallesCuenta;

	private transient StreamedContent exportPdf;

	private String rutaArchivo;

	private static final long serialVersionUID = -9161774389839616910L;

	protected String RUTA_ICONO_BBVA = MessagesHelper.INSTANCE.getString("ruta.iconobbva");

	private Document fileInput;

	private TermsAccountsDto detallesCuentaDto = new TermsAccountsDto();

	@Override
	public TermsAccountsDto getAllConditions() {
		try {
			if (super.getSelectedProduct().getTypeProd().compareTo(EnumProductType.PC) == 0) {
				detallesCuentaDto = this.detallesCuenta.getAllConditions(super.getSelectedProduct().getProductId());
			}
		} catch (Exception e) {
			// FacesContext ctx = FacesContext.getCurrentInstance();
			// ctx.addMessage("Condiciones", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
		}
		return detallesCuentaDto;
	}

	@Override
	public void exportDocumentPdf() {

		LOGGER.info("iniciando exportar archivo pdf");

		rutaArchivo = "Conditions" + getSelectedProduct().getProductNumber() + ".pdf";

		try {

			FileOutputStream file = null;

			try {
				file = new FileOutputStream(rutaArchivo);
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

			PdfPTable tablaHeader = new PdfPTable(4);
			com.itextpdf.text.Font fontBlue = new com.itextpdf.text.Font(FontFamily.HELVETICA, 10,
					com.itextpdf.text.Font.BOLD, new BaseColor(0, 80, 152));
			// tablaHeader.addCell(new Phrase(, fontBlue));
			Paragraph title = new Paragraph("Información del producto", FontFactory.getFont("helvetica", 11,
					new BaseColor(51, 51, 51)));
			title.setSpacingBefore(20);
			document.add(title);

			com.itextpdf.text.Font font = new com.itextpdf.text.Font(FontFamily.HELVETICA, 7,
					com.itextpdf.text.Font.BOLD, new BaseColor(102, 102, 102));
			com.itextpdf.text.Font fontNormal = new com.itextpdf.text.Font(FontFamily.HELVETICA, 7,
					com.itextpdf.text.Font.NORMAL, new BaseColor(102, 102, 102));

			PdfPTable tabla = new PdfPTable(2);

			tabla.setSpacingBefore(20);
			tabla.setSpacingAfter(20);
			tabla.setHorizontalAlignment(Element.ALIGN_LEFT);
			tabla.getDefaultCell().setBorder(0);

			tabla.addCell(new Phrase("Alias:", font));
			tabla.addCell(new Phrase(getSelectedProduct().getAlias(), fontNormal));
			tabla.addCell(new Phrase("N° de cuenta:", font));
			tabla.addCell(new Phrase(getSelectedProduct().getProductNumber(), fontNormal));
			tabla.addCell(new Phrase("Tipo de cuenta:", font));
			tabla.addCell(new Phrase(getSelectedProduct().getProductName(), fontNormal));
			document.add(tabla);

			title = new Paragraph("Intervinientes", FontFactory.getFont("helvetica", 11, new BaseColor(51, 51, 51)));
			document.add(title);

			tabla = new PdfPTable(2);
			tabla.setSpacingBefore(20);
			tabla.setSpacingAfter(20);
			tabla.setHorizontalAlignment(Element.ALIGN_LEFT);
			tabla.getDefaultCell().setBorder(0);

			if (detallesCuentaDto.getHolders() != null) {
				for (int i = 0; i < detallesCuentaDto.getHolders().size(); i++) {
					tabla.addCell(new Phrase("Titular:", font));
					tabla.addCell(new Phrase(detallesCuentaDto.getHolders().get(i).getAlias(), fontNormal));
				}
			}

			tabla.addCell(new Phrase("Condiciones de movilización:", font));
			tabla.addCell(new Phrase(detallesCuentaDto.getCondicionesMovilizacion(), fontNormal));
			document.add(tabla);

			title = new Paragraph("Condiciones", FontFactory.getFont("helvetica", 11, new BaseColor(51, 51, 51)));
			document.add(title);

			tabla = new PdfPTable(2);
			tabla.setSpacingBefore(20);
			tabla.setSpacingAfter(20);
			tabla.setHorizontalAlignment(Element.ALIGN_LEFT);
			tabla.getDefaultCell().setBorder(0);

			tabla.addCell(new Phrase("Categoría:", font));
			if (detallesCuentaDto.getDetalleCondiciones() == null) {
				detallesCuentaDto.setDetalleCondiciones(new DetailConditionsDto());
			}
			tabla.addCell(new Phrase(detallesCuentaDto.getDetalleCondiciones().getCategoria(), fontNormal));
			tabla.addCell(new Phrase("Descripción:", font));
			tabla.addCell(new Phrase(detallesCuentaDto.getDetalleCondiciones().getDescripcion(), fontNormal));
			tabla.addCell(new Phrase("Fecha de apertura:", font));
			String date = super.getdateString(detallesCuentaDto.getDetalleCondiciones().getFechaApertura());
			tabla.addCell(new Phrase(date, fontNormal));
			tabla.addCell(new Phrase("Comisiones:", font));
			tabla.addCell(new Phrase(detallesCuentaDto.getDetalleCondiciones().getComisiones(), fontNormal));
			document.add(tabla);

			title = new Paragraph("Dirección postal", FontFactory.getFont("helvetica", 11, new BaseColor(51, 51, 51)));
			document.add(title);

			tabla = new PdfPTable(2);
			tabla.setSpacingBefore(20);
			tabla.setSpacingAfter(15);
			tabla.setHorizontalAlignment(Element.ALIGN_LEFT);
			tabla.getDefaultCell().setBorder(0);
			if (detallesCuentaDto.getDireccionPostal() == null) {
				detallesCuentaDto.setDireccionPostal(new PostalAddresDto());
			}
			tabla.addCell(new Phrase("Nombre oficina:", font));
			tabla.addCell(new Phrase(detallesCuentaDto.getDireccionPostal().getNombreOficina(), fontNormal));
			tabla.addCell(new Phrase("Dirección postal:", font));
			tabla.addCell(new Phrase(detallesCuentaDto.getDireccionPostal().getDireccionPostal(), fontNormal));
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
	 * @param detallesCuenta the detallesCuenta to set
	 */
	public void setDetallesCuenta(TermasAccountsFacade detallesCuenta) {
		this.detallesCuenta = detallesCuenta;
	}

	@Override
	public void deletePdf() {
		try {
			File fileOut = new File(rutaArchivo);

			if (fileOut.exists()) {
				fileOut.delete();
			}
		} catch (Exception ex) {
			LOGGER.info("Excepción no se encuentra el archivo para eliminar" + ex.getMessage());
		}
	}

	public void printFile() {
		File pdfFile = new File("Conditions" + getSelectedProduct().getProductNumber() + ".pdf");

		if (pdfFile.exists()) {
			if (pdfFile.delete()) {
				LOGGER.info("borró el archivo");
				exportDocumentPdf();
			} else
				LOGGER.info("No lo borró");
		} else {
			exportDocumentPdf();
		}

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

	/**
	 * @return the exportPdf
	 */
	public StreamedContent getExportPdf() {
		exportDocumentPdf();
		InputStream stream;
		try {
			stream = new BufferedInputStream(new FileInputStream("Conditions" + getSelectedProduct().getProductNumber()
					+ ".pdf"));
			exportPdf = new DefaultStreamedContent(stream, "application/pdf", "Conditions"
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

}
