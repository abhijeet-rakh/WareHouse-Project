package com.app.pdfview;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.User;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UserPdfViewById extends AbstractPdfView{

	@Override
	public void buildPdfDocument(Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		
		//set response
	    response.setHeader("Content-Disposition", "attachment;filename=One-User.pdf");

	    List<User> list=(List<User>) model.get("onedata");
	    
	    Paragraph ph=new Paragraph("Order Method");
	    
	    document.add(ph);
	    
	    PdfPTable table=new PdfPTable(6);
	    

	    table.addCell("ID");
	    table.addCell("User Name");
	    table.addCell("Mail");
	    table.addCell("Password");
	    table.addCell("Mobile");
	    table.addCell("Roles");
	    
		for(User user:list) {
			table.addCell(user.getUserid().toString());
			table.addCell(user.getUserName());
			table.addCell(user.getMail());
			table.addCell(user.getPassword());
			table.addCell(user.getMobile());
		    table.addCell(user.getRoles().toString());
		}
		//add table to document
		document.add(table);
		
		//add date to document
		document.add(new Paragraph(new Date().toString()));
	
	}
	
}
