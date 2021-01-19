package com.lti.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lti.entity.Passenger;
import com.lti.repository.TicketRepository;

@Service
@Transactional
public class TicketServiceImpl implements TicketPdfService{
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private MailSendService mailSender;

	public void ticketPdf(int ticketId,String email) {
		Document document = new Document();
		try {
			String fileName = "d:/Ticket/Ticket"+ Integer.toString(ticketId)+".pdf";
			FileOutputStream out = new FileOutputStream(fileName);
			PdfWriter writer = PdfWriter.getInstance(document, out);
			document.open();
			Paragraph title = new Paragraph("Clean Trip");
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);
			Paragraph head = new Paragraph("Ticket For your Journey");
			head.setAlignment(Element.ALIGN_CENTER);
			document.add(head);
			document.add(new Paragraph(" "));
			PdfPTable myReportTable = new PdfPTable(7);
			PdfPCell tableCell;
			List<Object[]> list = ticketRepository.fetchBookingDetails(ticketId);
			tableCell = new PdfPCell(new Phrase("Ticket Id"));
			tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			myReportTable.addCell(tableCell);
			tableCell = new PdfPCell(new Phrase("Boarding point"));
			tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			myReportTable.addCell(tableCell);
			tableCell = new PdfPCell(new Phrase("Dropping point"));
			tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			myReportTable.addCell(tableCell);
			tableCell = new PdfPCell(new Phrase("Amount"));
			tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			myReportTable.addCell(tableCell);
			tableCell = new PdfPCell(new Phrase("Status"));
			tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			myReportTable.addCell(tableCell);
			tableCell = new PdfPCell(new Phrase("Date Of Journey"));
			tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			myReportTable.addCell(tableCell);
			tableCell = new PdfPCell(new Phrase("Duration"));
			tableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			myReportTable.addCell(tableCell);
			for(Object[] b:list) {
				String id = String.valueOf(b[0]);
				tableCell = new PdfPCell(new Phrase(id));
				myReportTable.addCell(tableCell);
				String boarding = String.valueOf(b[1]);
				tableCell = new PdfPCell(new Phrase(boarding));
				myReportTable.addCell(tableCell);
				String destination = String.valueOf(b[2]);
				tableCell = new PdfPCell(new Phrase(destination));
				myReportTable.addCell(tableCell);
				String amount = String.valueOf(b[3]);
				tableCell = new PdfPCell(new Phrase(amount));
				myReportTable.addCell(tableCell);
				String status = String.valueOf(b[4]);
				tableCell = new PdfPCell(new Phrase(status));
				myReportTable.addCell(tableCell);
				String date = String.valueOf(b[5]);
				tableCell = new PdfPCell(new Phrase(date));
				myReportTable.addCell(tableCell);
				String duration = String.valueOf(b[6]);
				tableCell = new PdfPCell(new Phrase(duration));
				myReportTable.addCell(tableCell);
			}
			document.add(myReportTable);
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			Paragraph preface = new Paragraph("Passengers List");
			preface.setAlignment(Element.ALIGN_CENTER);
			document.add(preface);
			document.add(new Paragraph(" "));
			PdfPTable myPassTable = new PdfPTable(3);
			PdfPCell myCell;
			myCell = new PdfPCell(new Phrase("Passenger Name"));
			myCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			myCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			myPassTable.addCell(myCell);
			myCell = new PdfPCell(new Phrase("Passenger Gender"));
			myCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			myCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			myPassTable.addCell(myCell);
			myCell = new PdfPCell(new Phrase("Passenger Age"));
			myCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			myCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			myPassTable.addCell(myCell);
			List<Passenger> pass = ticketRepository.fetchPassengerForTrip(ticketId);
			for(Passenger p:pass) {
				String name= p.getName();
				myCell= new PdfPCell(new Phrase(name));
				myCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				myPassTable.addCell(myCell);
				String gender= p.getGender();
				myCell= new PdfPCell(new Phrase(gender));
				myCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				myPassTable.addCell(myCell);
				String age= Integer.toString(p.getAge());
				myCell= new PdfPCell(new Phrase(age));
				myCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				myPassTable.addCell(myCell);
			}
			document.add(myPassTable);
			document.close();
			writer.close();
			System.out.println("Pdf created");
			mailSender.sendMail(fileName,email);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
