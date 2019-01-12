package com.app.excelview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.User;

public class UserExcelViewById extends AbstractXlsxView{

	@Override
	public void buildExcelDocument(Map<String, Object> model,
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			
		// get Model data
		List<User> list = (List<User>) model.get("onedata");

		// create sheet using workbook
        Sheet sheet = workbook.createSheet("User");

        //set head
        setHead(sheet);
        
        //set Body
        setBody(sheet, list);
        
	}//buildExcelDocument

	
	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);	
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("UserName");
		row.createCell(2).setCellValue("UserMail");
		row.createCell(3).setCellValue("Password");
		row.createCell(4).setCellValue("Mobile");
        row.createCell(5).setCellValue("Roles");
	}//setHead

	private void setBody(Sheet sheet,List<User> list) {
        int rowNum=1;    
        for(User user:list) {
        	Row row=sheet.createRow(rowNum++);
        	row.createCell(0).setCellValue(user.getUserid());
        	row.createCell(1).setCellValue(user.getUserName());
        	row.createCell(2).setCellValue(user.getMail());
        	row.createCell(3).setCellValue(user.getPassword());
        	row.createCell(4).setCellValue(user.getMobile());
        	row.createCell(5).setCellValue(user.getRoles().toString());
        }//forEach
        
     }//setBody

	
}