package com.app.pdfview;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.UOM;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UOMTypePdfViewById extends AbstractPdfView {

	@Override
	public void buildPdfDocument(Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

    		//set response
	        response.setHeader("Content-Disposition", "attachment;filename=ONE-UOMTYPE.pdf");

		    //get the data from model contained in controller
	       	List<UOM> list=(List<UOM>) model.get("onedata");
	       	
	       	Paragraph ph=new Paragraph("single record of ");
	       	
	       	document.add(ph);
	       	
	        
		       PdfPTable table=new PdfPTable(4);
		       
		       table.addCell("ID");
		       table.addCell("Type");
		       table.addCell("Model");
		       table.addCell("Desc");
		       
			   for(UOM u:list) {
				   table.addCell(u.getUomid().toString());
				   table.addCell(u.getUomtype());
				   table.addCell(u.getUommodel());
				   table.addCell(u.getUomdesc());
			   }
		    
			//add table to doc
			document.add(table);
			
			//add date to doc
			document.add(new Paragraph(new Date().toString()));
			
	}

}
