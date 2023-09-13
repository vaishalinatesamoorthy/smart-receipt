package com.example.receipt.service;

import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.example.receipt.model.Receipt;
@Service
public class MailService {
	@Autowired
	private JavaMailSender sender;
	 @Autowired
	 private SpringTemplateEngine templateEngine;

	
public void sendmail(Receipt r,Map<String, Object> model) throws Exception
 {
	System.out.println("mail sending");
	final Context ctx=new Context();
	ctx.setVariables(model);
	System.out.print("context Success");
	System.out.print(model);
	MimeMessage message=sender.createMimeMessage();
	MimeMessageHelper helper=new MimeMessageHelper(message,false);
	helper.setSubject("Smart Receipt");
	helper.setFrom("varshinininatesamoorthy@gmail.com");
	helper.setTo(r.getEmail());
	//helper.setText("hello");
	String htmlContent=templateEngine.process("GmailReceipt",ctx);
	helper.setText(htmlContent,true); 
	sender.send(message);
	
	 
 }
 
}
