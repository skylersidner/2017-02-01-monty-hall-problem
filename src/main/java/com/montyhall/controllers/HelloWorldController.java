package com.montyhall.controllers;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.montyhall.domain.HelloWorldDomainService;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {

	@Inject
	private HelloWorldDomainService helloWorldDomainService;
	
	@RequestMapping(value="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String getMessage() {
		String message = helloWorldDomainService.getMessage();
		return message;
	}
	
	
}
