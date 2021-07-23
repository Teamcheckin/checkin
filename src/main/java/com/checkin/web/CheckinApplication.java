package com.checkin.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.checkin.web.*" })
public class CheckinApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckinApplication.class, args);
	}

}
