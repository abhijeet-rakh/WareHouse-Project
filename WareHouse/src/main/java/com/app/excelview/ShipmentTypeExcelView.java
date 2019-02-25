package com.app.excelview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	public void buildExcelDocument(Map<String, Object> model, 
			Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//set header
		response.setHeader("Content-Disposition","attachment;filename-SHIPMENTS.xlsx");
		
		//Reading data from Model
		List<ShipmentType> list=(List<ShipmentType>) model.get("excellist");
		
		//creating sheet
		Sheet sheet=workbook.createSheet("Shipment Type");
		
		//set head
		setHead(sheet);
		
		//set Body
        setBody(sheet, list);     
		  
	}
	
	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
	    row.createCell(0).setCellValue("ShipId");
	    row.createCell(1).setCellValue("ShipMode");
	    row.createCell(2).setCellValue("ShipCode");
	    row.createCell(3).setCellValue("EnableShip");
	    row.createCell(4).setCellValue("ShipGrade");
	    row.createCell(5).setCellValue("ShipDesc");
	}
	
	private void setBody(Sheet sheet,List<ShipmentType> list) {
		
		int rowNum=1;
		
		for(ShipmentType s:list) {	
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(s.getId());
			row.createCell(1).setCellValue(s.getShipmentMode());
			row.createCell(2).setCellValue(s.getShipmentCode());
			row.createCell(3).setCellValue(s.getEnableShipment());
			row.createCell(4).setCellValue(s.getShipmentGrade());
			row.createCell(5).setCellValue(s.getDesc());
		}
	}
}
