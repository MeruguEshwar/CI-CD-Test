package com.ojas.mail.Controller;

import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ojas.mail.model.EmailDetails;
import com.ojas.mail.service.EmailServiceImpl;

import jakarta.mail.MessagingException;

@RestController
public class EmailController {

	@Autowired
	private EmailServiceImpl emailservice;

	@PostMapping("/sendmail")
	public void email() {
		emailservice.sendSimpleMessage();
	}

	@GetMapping("/sendmailwithattachment")
	public void emailWithAttachment() throws IOException {
		try {
			emailservice.mailSendingWithAttachment();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
