package com.app.pdfview;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.PurchaseOrder;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PurchaseOrderPdfView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// set response
		response.setHeader("Content-Disposition", "attachment;filename=purchaseOrder.pdf");

		List<PurchaseOrder> list = (List<PurchaseOrder>) model.get("list");

		Paragraph ph = new Paragraph("Purchase Order Detail");

		document.add(ph);

		PdfPTable table = new PdfPTable(8);

		table.addCell("ID");
		table.addCell("Code");
		table.addCell("Shipment Code");
		table.addCell("User Code");
		table.addCell("RefNum");
		table.addCell("QualityCheck");
		table.addCell("OrdStatus");
		table.addCell("Desc");

		for (PurchaseOrder po : list) {
			table.addCell(po.getOrderId().toString());
			table.addCell(po.getOrderCode());
			table.addCell(po.getShiptype().getShipmentCode());
			table.addCell(po.getWhusertype().getWhCode());
			table.addCell(po.getRefNum());
			table.addCell(po.getQualityCheck());
			table.addCell(po.getOrdStatus());
			table.addCell(po.getOrdDesc());
		}
		// add table to document
		document.add(table);

		// add date to document
		document.add(new Paragraph(new Date().toString()));
	}

}
