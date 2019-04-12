package com.neu.edu.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.neu.edu.pojo.Transaction;
import com.neu.edu.pojo.User;
import com.itextpdf.text.Phrase;

public class PDFBuilder extends AbstractITextPdfView {
	 
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document,
            PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
		List<Transaction> transactions = (List<Transaction>) model.get("transactions");
		
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Paragraph title = new Paragraph("Transactions for " + strDate);
		title.setAlignment(Element.ALIGN_CENTER);
		document.add(title);
		document.add(Chunk.NEWLINE);
		document.add(new Paragraph("User Name: " + user.getName()));
		document.add(new Paragraph("Address: " + user.getAddress()));
		document.add(new Paragraph("Mobile Number: " + user.getPhoneNumber()));
		document.add(new Paragraph("Email Address: " + user.getEmail()));
		document.add(Chunk.NEWLINE);
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 3.0f, 2.0f, 2.0f, 2.0f, 1.0f });
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.BLACK);
		
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.GRAY);
		cell.setPadding(5);

		// write table header
		cell.setPhrase(new Phrase("Recipient", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Payment Method", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Transaction Amount", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Currency", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Transaction Date", font));
		table.addCell(cell);
		
		for(Transaction t : transactions)
		{
			table.addCell(t.getRecipient());
			table.addCell(t.getCardNumber());
			table.addCell(String.valueOf(t.getTransactionAmount()));
			table.addCell(t.getTransactionCurrency());
			table.addCell(String.valueOf(t.getTransactionDateTime()));
		}
		document.add(table);
         
    }
 
}
