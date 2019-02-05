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

public class WhUserTypePdfView extends AbstractPdfView {

	@Override
	public void buildPdfDocument(Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		//set response
	    response.setHeader("Content-Disposition", "attachment;filename=WhUserType.pdf");

		List<WhUserType> list=(List<WhUserType>) model.get("list");
		
        Paragraph ph=new Paragraph("Order Method");
	    
	    document.add(ph);
	    
	    PdfPTable table=new PdfPTable(8);
	    
	    table.addCell("ID");
	    table.addCell("UserType");
	    table.addCell("UserCode");
	    table.addCell("UserFor");
	    table.addCell("Email");
	    table.addCell("Contact");
	    table.addCell("IDType");
	    table.addCell("idNumber");
	    
		for(WhUserType wu:list) {
			table.addCell(wu.getWhid().toString());
			table.addCell(wu.getUserType());
			table.addCell(wu.getUserCode());
			table.addCell(wu.getUserFor());
			table.addCell(wu.getUserEmail());
		    table.addCell(wu.getUserContact());
		    table.addCell(wu.getUserIdType());
		    table.addCell(wu.getIdnumber());
		}
		//add table to document
		document.add(table);
		
		//add date to document
		document.add(new Paragraph(new Date().toString()));


	}

}
