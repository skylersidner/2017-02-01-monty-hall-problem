package com.montyhall.controllers;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.montyhall.domain.DecisionEngineDomainServiceImpl;
import com.montyhall.domain.DecisionEngineTemplate;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Inject
	DecisionEngineDomainServiceImpl decisionEngineDomainServiceImpl;
	
	@RequestMapping(value="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String getMessage() {
		String message = "Welcome!  This is a demonstration of what many refer to as the \"Monty Hall Problem.\"";
		return message;
	}
	
}