package com.lti.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {

	private JavaMailSender mailSender;
	
	public void forgotPassword(String email) {
		
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
			message.setSubject("Reset Password Link!");
			String messageBody="http://localhost:4200/dashboard/change-password";
			message.setText(messageBody);
			Transport.send(message);
			System.out.println("Password Link sent successfully");
		}
		catch(MessagingException mex) {
			mex.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	

}
