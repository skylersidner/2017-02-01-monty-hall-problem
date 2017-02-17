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
	
	@RequestMapping(value="/3doorStay", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String get3doorStayResult() {
		DecisionEngineTemplate template = new DecisionEngineTemplate();
		template.setNumberOfDoors(3);
		template.setSwapping(false);
		template.setNumberOfRounds(1);
		
		String message = "Aww, I'm sorry!  You lost!";
		int result = decisionEngineDomainServiceImpl.letsMakeADealFast(template);
		if (result == 1) {
			message = "Congratulations!  You won!";
		}
		return message;
	}
	
	@RequestMapping(value="/3doorStay100", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String get3doorStay100Result() {
		DecisionEngineTemplate template = new DecisionEngineTemplate();
		template.setNumberOfDoors(3);
		template.setSwapping(false);
		template.setNumberOfRounds(100);
		
		int result = decisionEngineDomainServiceImpl.letsMakeADealFast(template);
		String message = "You won " + result + " times out of 100!";
		return message;
	}
	
	@RequestMapping(value="/3doorSwap", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String get3doorSwapResult() {
		DecisionEngineTemplate template = new DecisionEngineTemplate();
		template.setNumberOfDoors(3);
		template.setSwapping(true);
		template.setNumberOfRounds(1);
		
		String message = "Aww, I'm sorry!  You lost!";
		int result = decisionEngineDomainServiceImpl.letsMakeADealFast(template);
		if (result == 1) {
			message = "Congratulations!  You won!";
		}
		return message;
	}
	
	@RequestMapping(value="/3doorSwap100", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String get3doorSwap100Result() {
		DecisionEngineTemplate template = new DecisionEngineTemplate();
		template.setNumberOfDoors(3);
		template.setSwapping(true);
		template.setNumberOfRounds(100);
		
		int result = decisionEngineDomainServiceImpl.letsMakeADealFast(template);
		String message = "You won " + result + " times out of 100!";
		return message;

	}

}