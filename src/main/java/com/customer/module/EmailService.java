package com.customer.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {

	
	public JavaMailSender javaMailSender;
	
	@Autowired
	public EmailService(JavaMailSender jms)
	{
		javaMailSender=jms;
	}
	
	@Async
    public void sendEmail(SimpleMailMessage email) {
        javaMailSender.send(email);
    }
}