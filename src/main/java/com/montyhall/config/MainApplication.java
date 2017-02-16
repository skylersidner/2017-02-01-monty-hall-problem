package com.montyhall.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
@ComponentScan(value = "com.montyhall")
public class MainApplication {


	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
}