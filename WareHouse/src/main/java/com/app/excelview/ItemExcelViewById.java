package com.app.excelview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Item;

public class ItemExcelViewById extends AbstractXlsxView {

	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		        // get list record by using map
				List<Item> list = (List<Item>) model.get("onedata");

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
				row.createCell(2).setCellValue("Length");
				row.createCell(3).setCellValue("Width");
				row.createCell(4).setCellValue("Height");
				row.createCell(5).setCellValue("Cost");
				row.createCell(6).setCellValue("Currency");
				row.createCell(7).setCellValue("UOMid");
				row.createCell(8).setCellValue("Oid");
				row.createCell(9).setCellValue("Description");
			}// setHead

			private void setBody(Sheet sheet, List<Item> list) {
				int rowNum = 1;

				for (Item item : list) {
					Row row = sheet.createRow(rowNum++);
					row.createCell(0).setCellValue(item.getItemId());
					row.createCell(1).setCellValue(item.getItemCode());
					row.createCell(2).setCellValue(item.getItemLength());
					row.createCell(3).setCellValue(item.getItemWidth());
					row.createCell(4).setCellValue(item.getItemHeight());
					row.createCell(5).setCellValue(item.getBaseCost());
					row.createCell(6).setCellValue(item.getBaseCurrency());
					row.createCell(7).setCellValue(item.getUom().getUomModel());
					row.createCell(8).setCellValue(item.getOm().getOrdercode());
					row.createCell(9).setCellValue(item.getItemDesc());
				}

			}// setBody

		
		
		
		
	}

