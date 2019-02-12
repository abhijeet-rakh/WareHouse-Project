package com.app.pdfview;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Item;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ItemPdfViewById extends AbstractPdfView {

	@Override
	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// set response
		response.setHeader("Content-Disposition", "attachment;filename=item.pdf");

		List<Item> list = (List<Item>) model.get("onedata");

		Paragraph ph = new Paragraph("Item Detail");

		document.add(ph);

		PdfPTable table = new PdfPTable(10);

		table.addCell("ID");
		table.addCell("Code");
		table.addCell("Length");
		table.addCell("Width");
		table.addCell("Height");
		table.addCell("Cost");
		table.addCell("Currency");
		table.addCell("UomModel");
		table.addCell("OrderCode");
		table.addCell("Desc");

		for (Item item : list) {
			table.addCell(item.getItemId().toString());
			table.addCell(item.getItemCode());
			table.addCell(item.getItemLength().toString());
			table.addCell(item.getItemWidth().toString());
			table.addCell(item.getItemHeight().toString());
			table.addCell(item.getBaseCost().toString());
			table.addCell(item.getBaseCurrency().toString());
			table.addCell(item.getUom().getUommodel());
			table.addCell(item.getOm().getOrdercode());
			table.addCell(item.getItemDesc());
			
		}
		// add table to document
		document.add(table);

		// add date to document
		document.add(new Paragraph(new Date().toString()));
	}

}
