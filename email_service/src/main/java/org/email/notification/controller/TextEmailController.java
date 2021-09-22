package org.email.notification.controller;
/*
 * @Author Debu Paul
 */

import org.email.notification.model.EmailTemplate;
import org.email.notification.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@RestController

@Slf4j
public class TextEmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping(value="/textemail",consumes = "application/json", produces = "application/json")
	public String sendEmail(@RequestBody EmailTemplate emailTemplate) {
		try {
			System.out.println("Sending Simple Text Email....");
			emailService.sendTextEmail(emailTemplate);
			return "Email Sent!";
		} catch (Exception ex) {
			return "Error in sending email: " + ex;
		}
	}
	
	
	@PostMapping(value="/attachemail",consumes = {"multipart/form-data","application/json"}, produces = "application/json")
	public String sendEmailWithAttachment(@RequestPart(value = "file") MultipartFile file ,@RequestPart(value = "template") EmailTemplate emailTemplate ) {
		try {
			System.out.println("Sending Attachment Email....");
			emailService.sendEmailWithAttachment(file , emailTemplate);
			return "Email Sent!";
		} catch (Exception ex) {
			return "Error in sending email: " + ex;
		}
	}
	

}
