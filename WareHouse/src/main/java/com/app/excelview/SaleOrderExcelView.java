package com.app.excelview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.SaleOrder;

public class SaleOrderExcelView extends AbstractXlsxView{

	@Override
		public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			// get list record by using map
			List<SaleOrder> list = (List<SaleOrder>) model.get("list");

			// create sheet using workbook
			Sheet sheet = workbook.createSheet();

			// set head
			setHead(sheet);

			// set Body
			setBody(sheet, list);

		}// buildExcelDocument

		private void setHead(Sheet sheet) {
			Row row = sheet.createRow(0);
			row.createCell(0).setCellValue("OrderId");
			row.createCell(1).setCellValue("OrderCode");
			row.createCell(2).setCellValue("ShipmentMode");
			row.createCell(3).setCellValue("Customer");
			row.createCell(4).setCellValue("RefNumber");
			row.createCell(5).setCellValue("StockMode");
			row.createCell(6).setCellValue("StockSource");
			row.createCell(7).setCellValue("DefaultStatus");
			row.createCell(8).setCellValue("SaleOrdDesc");
		}// setHead
		
		
		private void setBody(Sheet sheet, List<SaleOrder> list) {
			int rowNum = 1;

			for (SaleOrder sale : list) {
				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(sale.getOrderId());
				row.createCell(1).setCellValue(sale.getOrderCode());
				row.createCell(2).setCellValue(sale.getShiptype().getShipmentMode());
				row.createCell(3).setCellValue(sale.getCustomer());
				row.createCell(4).setCellValue(sale.getRefNumber());
				row.createCell(5).setCellValue(sale.getStockMode());
				row.createCell(6).setCellValue(sale.getStockSource());
				row.createCell(7).setCellValue(sale.getDefaultStatus());
				row.createCell(8).setCellValue(sale.getSaleOrdDesc());				
			}

		}// setBody	
	}	