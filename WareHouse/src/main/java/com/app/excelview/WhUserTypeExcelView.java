package com.app.excelview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView{


	@SuppressWarnings("unchecked")
	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		  //get list record by using map 
		  List<WhUserType> list=(List<WhUserType>) model.get("list");
	
		  //create sheet using workbook
          Sheet sheet=workbook.createSheet();
		  
          //send sheet to setHead Method
          setHead(sheet);
          
          //send Sheet with list using Body method
          setBody(sheet, list);
          
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
        row.createCell(0).setCellValue("whId");
        row.createCell(1).setCellValue("whType");
        row.createCell(2).setCellValue("whCode");
        row.createCell(3).setCellValue("whFor");
        row.createCell(4).setCellValue("whEmail");
        row.createCell(5).setCellValue("whContact");
        row.createCell(6).setCellValue("whIdType");
        row.createCell(7).setCellValue("whIdOther");
        row.createCell(8).setCellValue("whIdNumber");
	}
	
	private void setBody(Sheet sheet,List<WhUserType> list) {
		int rowNum=1;
		
		for(WhUserType wu:list) {
		Row row=sheet.createRow(rowNum++);
	    row.createCell(0).setCellValue(wu.getWhId());
	    row.createCell(1).setCellValue(wu.getWhType());
	    row.createCell(2).setCellValue(wu.getWhCode());
	    row.createCell(3).setCellValue(wu.getWhFor());
	    row.createCell(4).setCellValue(wu.getWhEmail());
	    row.createCell(5).setCellValue(wu.getWhContact());
	    row.createCell(6).setCellValue(wu.getWhIdType());
	    row.createCell(7).setCellValue(wu.getWhIdOther());
	    row.createCell(8).setCellValue(wu.getWhIdNumber());
	    
		}
		
		
	}
	
	
	

	
	
}
