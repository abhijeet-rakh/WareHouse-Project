package com.app.pdfview;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UnitOfMeasurementPdfViewById extends AbstractPdfView {

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//list get 
		List<Uom> oneData = (List<Uom>) model.get("oneData");

		Paragraph ph=new Paragraph("All Uom Data");
		
		document.add(ph);

		PdfPTable table=new PdfPTable(4);
		
		table.addCell("UomId");
		table.addCell("UomType");
		table.addCell("UomModel");
		table.addCell("UomDsc");
		
		 for(Uom um:oneData) {
	        	table.addCell(um.getUomId().toString());
	        	table.addCell(um.getUomType());
	        	table.addCell(um.getUomModel());
	        	table.addCell(um.getUomDsc()); 
		    }	
	        
	        document.add(table);
	        
	        document.add(new Paragraph(new Date().toString()));	
	        
	}

}
