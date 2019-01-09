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

public class WhUserTypeUserTypeExcelViewById extends AbstractXlsxView {

	@Override
	public void buildExcelDocument(Map<String, Object> model, 
			Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		    
            List<WhUserType> list=(List<WhUserType>) model.get("wut");
            
            Sheet sheet=workbook.createSheet("WhUser-Type");
		
            //set head
            setHead(sheet);
            
            //set Body
            setBody(sheet, list);
	}


	private void setHead(Sheet sheet) {
        Row row= sheet.createRow(0);
       
        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Type");
        row.createCell(2).setCellValue("Code");
        row.createCell(3).setCellValue("UserFor");
        row.createCell(4).setCellValue("UserEmail");
        row.createCell(5).setCellValue("UserContact");
        row.createCell(6).setCellValue("UserIdType");
        row.createCell(7).setCellValue("IDNumber");
	}

	
	private void setBody(Sheet sheet,List<WhUserType> list) {

		int rowNum=1;
		
		for(WhUserType wh:list) {
		     Row row=sheet.createRow(rowNum++);
		     
		     row.createCell(0).setCellValue(wh.getWhid());
		     row.createCell(1).setCellValue(wh.getUserType());
		     row.createCell(2).setCellValue(wh.getUserCode());
		     row.createCell(3).setCellValue(wh.getUserFor());
		     row.createCell(4).setCellValue(wh.getUserEmail());
		     row.createCell(5).setCellValue(wh.getUserContact());
		     row.createCell(6).setCellValue(wh.getUserIdType());
		     row.createCell(7).setCellValue(wh.getIdnumber());    
		}
	
	}//setBody

}
