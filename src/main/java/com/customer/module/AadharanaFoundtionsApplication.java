package com.customer.module;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Component;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AadharanaFoundtionsApplication 
{
	public static void main(String[] args) {
		SpringApplication.run(AadharanaFoundtionsApplication.class, args);
		
		System.out.print("Started the project!");
	}

}


