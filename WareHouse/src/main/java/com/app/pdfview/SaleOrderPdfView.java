package com.app.pdfview;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Item;
import com.app.model.SaleOrder;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class SaleOrderPdfView extends AbstractPdfView{

	@Override
	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		// set response
		response.setHeader("Content-Disposition", "attachment;filename=item.pdf");

		List<SaleOrder> list = (List<SaleOrder>) model.get("list");

		Paragraph ph = new Paragraph("Item Detail");

		document.add(ph);

		PdfPTable table = new PdfPTable(9);

		table.addCell("OrderID");
		table.addCell("OrderCode");
		table.addCell("ShipmentMode");
		table.addCell("Customer");
		table.addCell("RefNumber");
		table.addCell("StockMode");
		table.addCell("StockSource");
		table.addCell("DefaultStatus");
		table.addCell("SaleOrdDesc");
		

		for (SaleOrder so : list) {
			table.addCell(so.getOrderId().toString());
			table.addCell(so.getOrderCode());
			table.addCell(so.getShiptype().getShipmentMode());
			table.addCell(so.getCustomer());
			table.addCell(so.getRefNumber().toString());
			table.addCell(so.getStockMode());
			table.addCell(so.getStockSource());
			table.addCell(so.getDefaultStatus());
			table.addCell(so.getSaleOrdDesc());
		}
		// add table to document
		document.add(table);

		// add date to document
		document.add(new Paragraph(new Date().toString()));
		
	}
	
}
