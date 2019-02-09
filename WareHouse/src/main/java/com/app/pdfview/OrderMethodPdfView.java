package com.app.pdfview;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView {

	@Override
	public void buildPdfDocument(Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
            
		//set response
	    response.setHeader("Content-Disposition", "attachment;filename=OrderMethod.pdf");

	    List<OrderMethod> list=(List<OrderMethod>) model.get("list");
	    
	    Paragraph ph=new Paragraph("Order Method");
	    
	    document.add(ph);
	    
	    PdfPTable table=new PdfPTable(6);
	    
	    table.addCell("ID");
	    table.addCell("Mode");
	    table.addCell("Code");
	    table.addCell("Type");
	    table.addCell("OrderAccept");
	    table.addCell("Description");
	    
		for(OrderMethod om:list) {
			table.addCell(om.getOid().toString());
			table.addCell(om.getOrdermode());
			table.addCell(om.getOrdercode());
			table.addCell(om.getExecutetype());
			table.addCell(om.getOrderaccept().toString());
		    table.addCell(om.getOrderdesc());
		}
		//add table to document
		document.add(table);
		
		//add date to document
		document.add(new Paragraph(new Date().toString()));
		
	}

}
