package com.app.excelview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.UnitOfMeasurement;

public class UnitOfMeasurementTypeExcelView extends AbstractXlsxView {

	
	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		// get the model
		List<UnitOfMeasurement> list = (List<UnitOfMeasurement>) model.get("list");

		// create sheet by using workbook
		Sheet sheet = workbook.createSheet("UnitOfMeasurement Type");

		//set Head
		setHead(sheet);
		
		//set Body 
		setBody(sheet, list);
		
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Type");
		row.createCell(2).setCellValue("Model");
		row.createCell(3).setCellValue("Desc");
	}
     
	private void setBody(Sheet sheet,List<UnitOfMeasurement> list){
		
		int rowNum=1;
		
	    for(UnitOfMeasurement UnitOfMeasurement:list) {
		Row row=sheet.createRow(rowNum++);
		row.createCell(0).setCellValue(UnitOfMeasurement.getUomId());
        row.createCell(1).setCellValue(UnitOfMeasurement.getUomType());
        row.createCell(2).setCellValue(UnitOfMeasurement.getUomModel());
        row.createCell(3).setCellValue(UnitOfMeasurement.getUomDesc());    
	    }
	    
	}
}
