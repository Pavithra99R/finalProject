package com.lti.service;

import java.io.File;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSendService {
	
	private JavaMailSender mailSender;
	
	public void sendMail(String fileName,String email) {
		
		final String recepient = email;
		final String sender = "busReservation-bluebus@outlook.com";
		final String password = "password12345";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp-mail.outlook.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender,password);
			}
		});
		
		try {
			Message message = new MimeMessage(session); 
			message.setFrom(new InternetAddress(sender)); 
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient)); 
			message.setSubject("Ticket For Your Journey!");
			
			BodyPart messageBodyPart = new MimeBodyPart(); 
			messageBodyPart.setText("Happy Travel with CleanTrip!!");
			MimeBodyPart attachmentPart = new MimeBodyPart();
			attachmentPart.attachFile(new File(fileName));
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(attachmentPart);
			
			message.setContent(multipart);
			Transport.send(message);
			
			//FileSystemResource file = new FileSystemResource("d:/Ticket/Ticket30032.pdf");
			//MimeMessage message = new MimeMessage(session);
//			MimeMessage message = mailSender.createMimeMessage();
//			MimeMessageHelper helper = new MimeMessageHelper(message, true);
//			helper.setFrom(new InternetAddress(sender));
//			helper.setTo(new InternetAddress(recepient));
//			helper.setSubject("Hello Test mail");
//			helper.setText("Hiii");
			//helper.addAttachment(file.getFilename(), file);
			
//			message.setFrom(new InternetAddress(sender));
//			message.addRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
//			message.setSubject("Hello Test mail");
//			message.setText("Hiii");
			
			//Transport.send(message);
//			mailSender.send(message);
			System.out.println("Sent message successfully");
		}
		catch(MessagingException mex) {
			mex.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
