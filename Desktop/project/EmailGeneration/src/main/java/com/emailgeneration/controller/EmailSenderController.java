package com.emailgeneration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emailgeneration.service.EmailSenderService;

import jakarta.mail.MessagingException;
@RestController
public class EmailSenderController {
	
@Autowired
EmailSenderService emailSenderService;
@GetMapping("/email")
//public void sendMail() {
//	emailSenderService.sendMail("priyadarshini.hl@dikshatech.com", "this is subject", "Hi gm");
//}

public void attachment() throws MessagingException {
	emailSenderService.sendMailWithAttachment
	("priyadarshini.hl@dikshatech.com", "this is subject", 
			"Hi good evening","C:\\Users\\diksha\\Downloads/pdfGeneration.pdf");
}
}
