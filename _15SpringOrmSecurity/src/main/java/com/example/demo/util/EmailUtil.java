package com.example.demo.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender javamailsender;

	public boolean send(String to, String[] cc, String[] bcc, String subject, String text, MultipartFile file) {
		boolean sent = false;
		try {
			MimeMessage message = javamailsender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, file != null);

			helper.setTo(to);

			if (cc != null) {
				helper.setCc(cc);
			}
			if (bcc != null) {
				helper.setBcc(bcc);
			}
			helper.setSubject(subject);
			helper.setText(text);

			if (file != null) {
				helper.addAttachment(file.getOriginalFilename(), file);
			}

			javamailsender.send(message);
			sent = true;

		} catch (Exception e) {

		}
		return sent;
	}

	public boolean send(String to, String subject, String text, MultipartFile file) {
		return send(to, subject, text, file);
	}

	public boolean send(String to, String subject, String text) {
		return send(to, subject, text);
	}
}

