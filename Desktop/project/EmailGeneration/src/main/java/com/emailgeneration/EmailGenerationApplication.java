package com.emailgeneration;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.emailgeneration.service.EmailSenderService;

@SpringBootApplication
public class EmailGenerationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailGenerationApplication.class, args);
	}

}
