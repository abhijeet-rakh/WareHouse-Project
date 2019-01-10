package com.app.pdfview;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	public void buildPdfDocument(Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		//set response
	    response.setHeader("Content-Disposition", "attachment;filename=SHIPMENTS.pdf");

		
		//get Model application
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");
		
		
		//add paragraph
		Paragraph ph=new Paragraph("Shipment data");
		
		//add paragraph to document
		document.add(ph);
		
		//add paragraph to table
		PdfPTable table=new PdfPTable(6);
		table.addCell("ID");
		table.addCell("Mode");
		table.addCell("Code");
		table.addCell("Enabled");
		table.addCell("ShipmentGrade");
		table.addCell("Description");
		
		for(ShipmentType sh:list) {
			table.addCell(sh.getId().toString());
			table.addCell(sh.getShipmentMode());
			table.addCell(sh.getShipmentCode());
			table.addCell(sh.getEnableShipment());
			table.addCell(sh.getShipmentGrade());
			table.addCell(sh.getDesc());
		}
		
		//add table to document
		document.add(table);
		
		//display current generated date 
		document.add(new Paragraph(new Date().toString()));
	}

}
