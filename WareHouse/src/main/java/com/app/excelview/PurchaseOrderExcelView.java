package com.app.excelview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.PurchaseOrder;

public class PurchaseOrderExcelView extends AbstractXlsxView{

	@SuppressWarnings("unchecked")
	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// get list record by using map
		List<PurchaseOrder> list = (List<PurchaseOrder>) model.get("list");

		// create sheet using workbook
		Sheet sheet = workbook.createSheet();

		// set head
		setHead(sheet);

		// set Body
		setBody(sheet, list);

	}// buildExcelDocument

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Code");
		row.createCell(2).setCellValue("Ship Code");
		row.createCell(3).setCellValue("User Code");
		row.createCell(4).setCellValue("RefNum");
		row.createCell(5).setCellValue("QualityCheck");
		row.createCell(6).setCellValue("OrdStatus");
		row.createCell(7).setCellValue("Description");
	}// setHead

	private void setBody(Sheet sheet, List<PurchaseOrder> list) {
		int rowNum = 1;

		for (PurchaseOrder po : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(po.getOrderId());
			row.createCell(1).setCellValue(po.getOrderCode());
			row.createCell(2).setCellValue(po.getShiptype().getShipmentCode());
			row.createCell(3).setCellValue(po.getWhusertype().getWhCode());
			row.createCell(4).setCellValue(po.getRefNum());
			row.createCell(5).setCellValue(po.getQualityCheck());
			row.createCell(6).setCellValue(po.getOrdStatus());
			row.createCell(7).setCellValue(po.getOrdDesc());
		}

	}// setBody

}

