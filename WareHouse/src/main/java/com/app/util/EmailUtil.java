package com.app.util;

import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender sender;

	public boolean sendEmail(String to
			, String[] cc
			, String[] bcc
			, String subject
			,String text
			, CommonsMultipartFile file) {

		boolean flag = false;

		try {
			// 1.create Mime message object
			MimeMessage message = sender.createMimeMessage();

			
			
			// 2.create helper class object
			MimeMessageHelper helper = new MimeMessageHelper(message
					, file != null ? true : false);

			//3.Set data
	        helper.setFrom("rakh.abhiraja.2@gmail.com");
			helper.setTo(to);
	
			//set Cc and bcc
			if(cc!=null && cc.length>0)
				helper.setCc(cc);
			
			if(bcc!=null && bcc.length>0)
				helper.setBcc(bcc);
			
			
			//set subject and text
            helper.setSubject(subject);
            helper.setText(text);
            
            
            
            if(file!=null)
			helper.addAttachment(file.getOriginalFilename(), file);
			
            message.setContent(text,"text/html");
            
			//send Email
			sender.send(message);
			
			flag=true;
			
		} catch (Exception e) {
			flag=false;
            e.printStackTrace();			
		}
		return flag;
	}
	
	
	/*Overloaded a method*/
	public boolean sendEmail(String to
			, String subject
			, String text) {
		
		return sendEmail(to, null, null, subject, text, null);
	}
	
	/*Overloaded a method*/
	public boolean sendEmail(String to
			, String text) {
		
		return sendEmail(to, null, null, null, text, null);
	}
	
}
