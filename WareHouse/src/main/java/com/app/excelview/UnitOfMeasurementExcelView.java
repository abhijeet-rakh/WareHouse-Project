package com.app.excelview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Uom;

public class UnitOfMeasurementExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// set list
		List<Uom> list = (List<Uom>) model.get("listdata");

		// create sheet
		Sheet sheet = workbook.createSheet();

		setHead(sheet);

		setBody(sheet, list);

	}

	private void setHead(Sheet sh) {
		Row row = sh.createRow(0);

		row.createCell(0).setCellValue("uomId");
		row.createCell(1).setCellValue("uomType");
		row.createCell(2).setCellValue("uomModel");
		row.createCell(3).setCellValue("uomDsc");

	}

	private void setBody(Sheet sh, List<Uom> list) {

		int rowNum = 1;

		for (Uom um : list) {

			Row row = sh.createRow(rowNum++);

			row.createCell(0).setCellValue(um.getUomId());
			row.createCell(1).setCellValue(um.getUomType());
			row.createCell(2).setCellValue(um.getUomModel());
			row.createCell(3).setCellValue(um.getUomDsc());

		}

	}

}