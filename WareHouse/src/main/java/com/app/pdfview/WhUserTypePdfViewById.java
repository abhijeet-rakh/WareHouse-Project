package com.app.pdfview;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfViewById extends AbstractPdfView{


	@SuppressWarnings("unchecked")
	@Override
	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// set response
		response.setHeader("Content-Disposition", "attachment;filename=WhUserType.pdf");

		List<WhUserType> list = (List<WhUserType>) model.get("onedata");

		Paragraph ph = new Paragraph("WhUser Details");

		document.add(ph);

		PdfPTable table = new PdfPTable(9);

		table.addCell("whId");
		table.addCell("whType");
		table.addCell("whCode");
		table.addCell("whFor");
		table.addCell("whEmail");
		table.addCell("whContact");
		table.addCell("whIdType");
		table.addCell("whIdOther");
		table.addCell("whIdNumber");

		for (WhUserType wu : list) {
			table.addCell(wu.getWhId().toString());
			table.addCell(wu.getWhType());
			table.addCell(wu.getWhCode());
			table.addCell(wu.getWhFor());
			table.addCell(wu.getWhEmail());
			table.addCell(wu.getWhContact());
			table.addCell(wu.getWhIdType());
			table.addCell(wu.getWhIdOther());
			table.addCell(wu.getWhIdNumber());
		}

		// add table to document
		document.add(table);

		// add date to document
		document.add(new Paragraph(new Date().toString()));

	}

}
