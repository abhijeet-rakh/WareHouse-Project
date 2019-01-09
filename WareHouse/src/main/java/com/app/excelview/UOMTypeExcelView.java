package com.app.excelview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.UOM;

public class UOMTypeExcelView extends AbstractXlsxView {

	
	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		// get the model
		List<UOM> list = (List<UOM>) model.get("list");

		// create sheet by using workbook
		Sheet sheet = workbook.createSheet("UOM Type");

		//set Head
		setHead(sheet);
		
		//set Body 
		setBody(sheet, list);
		
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(0).setCellValue("Type");
		row.createCell(0).setCellValue("Model");
		row.createCell(0).setCellValue("Desc");
	}
     
	private void setBody(Sheet sheet,List<UOM> list){
		
		int rowNum=1;
		
	    for(UOM uom:list) {
		Row row=sheet.createRow(rowNum++);
		row.createCell(0).setCellValue(uom.getUomid());
        row.createCell(1).setCellValue(uom.getUomtype());
        row.createCell(2).setCellValue(uom.getUommodel());
        row.createCell(3).setCellValue(uom.getUomdesc());    
	    }
	    
	}
}
