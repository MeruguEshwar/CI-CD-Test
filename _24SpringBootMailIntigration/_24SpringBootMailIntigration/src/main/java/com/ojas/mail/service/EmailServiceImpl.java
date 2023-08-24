package com.ojas.mail.service;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ojas.mail.model.EmailDetails;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl {

	@Autowired
	private JavaMailSender emailSender;
	/// this is the mail sending method without any attachments

	public void sendSimpleMessage() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("mailtoyashs@gmail.com");
		msg.setSubject("Hi yashwanth");
		msg.setText("how are you");
		emailSender.send(msg);
	}

	public void mailSendingWithAttachment() throws MessagingException {
		MimeMessage mm = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mm, true);
		helper.setTo("yannamsiva@gmail.com");
		helper.setSubject("This is From AttandanceManagmentSystem <h2>file Attachment completed</h2>");
		helper.setText("Thanks For Registering");
		//File file = new File("C:\\Users\\em22081\\Downloads\\eshu.jpg");
		FileSystemResource file = new FileSystemResource(new File("C:\\Users\\em22081\\OneDrive - Ojas Innovative Technologies Pvt Lt\\Desktop\\02.jpg"));
		helper.addAttachment("attachment.jpg", file);
		emailSender.send(mm);
	}

}
