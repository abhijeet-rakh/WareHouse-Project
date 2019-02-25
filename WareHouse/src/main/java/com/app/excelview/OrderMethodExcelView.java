package com.app.excelview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	public void buildExcelDocument(Map<String, Object> model, 
			Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// get list record by using map
		List<OrderMethod> list = (List<OrderMethod>) model.get("list");

		// create sheet using workbook
		Sheet sheet = workbook.createSheet();
		
		//set head
		setHead(sheet);

		//set Body
		setBody(sheet, list);

	}//buildExcelDocument

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);	
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Mode");
		row.createCell(2).setCellValue("Code");
		row.createCell(3).setCellValue("Type");
		row.createCell(4).setCellValue("Desc");
        row.createCell(5).setCellValue("OrderAccept");	
	}//setHead

	private void setBody(Sheet sheet,List<OrderMethod> list) {
        int rowNum=1;
        
        for(OrderMethod om:list) {
        	Row row=sheet.createRow(rowNum++);
        	row.createCell(0).setCellValue(om.getOid());
        	row.createCell(1).setCellValue(om.getOrdermode());
        	row.createCell(2).setCellValue(om.getOrdercode());
        	row.createCell(3).setCellValue(om.getExecutetype());
        	row.createCell(4).setCellValue(om.getOrderdesc());
        	row.createCell(5).setCellValue(om.getOrderaccept().toString());
        }
		
	}//setBody
	
}//class
