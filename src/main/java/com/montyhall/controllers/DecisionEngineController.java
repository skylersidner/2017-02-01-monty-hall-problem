package com.montyhall.controllers;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.montyhall.domain.DecisionEngineDomainServiceImpl;
import com.montyhall.domain.DecisionEngineTemplate;

@RestController
@RequestMapping("/engine")
public class DecisionEngineController {
	
	@Inject
	DecisionEngineDomainServiceImpl decisionEngineDomainServiceImpl;


	@RequestMapping(value="/params", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> getParamsResult(@RequestParam(value = "numberOfDoors") Integer numberOfDoors, 
			@RequestParam(value = "isSwapping") boolean isSwapping, @RequestParam(value = "numberOfRounds") Integer numberOfRounds) {
		DecisionEngineTemplate template = new DecisionEngineTemplate();
		template.setNumberOfDoors(numberOfDoors);
		template.setSwapping(isSwapping);
		template.setNumberOfRounds(numberOfRounds);
		
		int result = decisionEngineDomainServiceImpl.letsMakeADealFast(template);
		String message = "You won " + result + " times out of " + numberOfRounds + "!";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@RequestMapping(value="/template", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> getTemplateResult(@RequestBody DecisionEngineTemplate template) {
//		DecisionEngineTemplate template = new DecisionEngineTemplate();
//		template.setNumberOfDoors(numberOfDoors);
//		template.setSwapping(isSwapping);
//		template.setNumberOfRounds(numberOfRounds);
		
		int result = decisionEngineDomainServiceImpl.letsMakeADealFast(template);
		String message = "You won " + result + " times out of " + template.getNumberOfRounds() + "!";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	// this is a terrible example of purpose, but here for an example of execution; these are not nested path ids at all!
	@RequestMapping(value="pathVariables/{numberOfDoors}/{isSwapping}/{numberOfRounds}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> getPathVariableResult(@PathVariable Integer numberOfDoors, 
			@PathVariable boolean isSwapping, @PathVariable Integer numberOfRounds) {
		DecisionEngineTemplate template = new DecisionEngineTemplate();
		template.setNumberOfDoors(numberOfDoors);
		template.setSwapping(isSwapping);
		template.setNumberOfRounds(numberOfRounds);
		
		int result = decisionEngineDomainServiceImpl.letsMakeADealFast(template);
		String message = "You won " + result + " times out of " + numberOfRounds + "!";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/3doorStay", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> get3doorStayResult() {
		DecisionEngineTemplate template = new DecisionEngineTemplate();
		template.setNumberOfDoors(3);
		template.setSwapping(false);
		template.setNumberOfRounds(1);
		
		String message = "Aww, I'm sorry!  You lost!";
		int result = decisionEngineDomainServiceImpl.letsMakeADealFast(template);
		if (result == 1) {
			message = "Congratulations!  You won!";
		}
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@RequestMapping(value="/3doorStay100", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> get3doorStay100Result() {
		DecisionEngineTemplate template = new DecisionEngineTemplate();
		template.setNumberOfDoors(3);
		template.setSwapping(false);
		template.setNumberOfRounds(100);
		
		int result = decisionEngineDomainServiceImpl.letsMakeADealFast(template);
		String message = "You won " + result + " times out of 100!";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	

	@RequestMapping(value="/3doorStay1000", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> get3doorStay1000Result() {
		DecisionEngineTemplate template = new DecisionEngineTemplate();
		template.setNumberOfDoors(3);
		template.setSwapping(false);
		template.setNumberOfRounds(1000);
		
		int result = decisionEngineDomainServiceImpl.letsMakeADealFast(template);
		String message = "You won " + result + " times out of 1000!";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@RequestMapping(value="/3doorSwap", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> get3doorSwapResult() {
		DecisionEngineTemplate template = new DecisionEngineTemplate();
		template.setNumberOfDoors(3);
		template.setSwapping(true);
		template.setNumberOfRounds(1);
		
		String message = "Aww, I'm sorry!  You lost!";
		int result = decisionEngineDomainServiceImpl.letsMakeADealFast(template);
		if (result == 1) {
			message = "Congratulations!  You won!";
		}

		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@RequestMapping(value="/3doorSwap100", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> get3doorSwap100Result() {
		DecisionEngineTemplate template = new DecisionEngineTemplate();
		template.setNumberOfDoors(3);
		template.setSwapping(true);
		template.setNumberOfRounds(100);
		
		int result = decisionEngineDomainServiceImpl.letsMakeADealFast(template);
		String message = "You won " + result + " times out of 100!";

		return new ResponseEntity<String>(message, HttpStatus.OK);

	}
	
	@RequestMapping(value="/3doorSwap1000", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> get3doorSwap1000Result() {
		DecisionEngineTemplate template = new DecisionEngineTemplate();
		template.setNumberOfDoors(3);
		template.setSwapping(true);
		template.setNumberOfRounds(1000);
		
		int result = decisionEngineDomainServiceImpl.letsMakeADealFast(template);
		String message = "You won " + result + " times out of 1000!";
	
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@RequestMapping(value="/100doorStay", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> get100doorStayResult() {
		DecisionEngineTemplate template = new DecisionEngineTemplate();
		template.setNumberOfDoors(100);
		template.setSwapping(false);
		template.setNumberOfRounds(1);
		
		String message = "Aww, I'm sorry!  You lost!";
		int result = decisionEngineDomainServiceImpl.letsMakeADealFast(template);
		if (result == 1) {
			message = "Congratulations!  You won!";
		}

		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	

	@RequestMapping(value="/100doorStay1000", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> get100doorStay1000Result() {
		DecisionEngineTemplate template = new DecisionEngineTemplate();
		template.setNumberOfDoors(100);
		template.setSwapping(false);
		template.setNumberOfRounds(1000);
		
		int result = decisionEngineDomainServiceImpl.letsMakeADealFast(template);
		String message = "You won " + result + " times out of 1000!";

		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@RequestMapping(value="/100doorSwap", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> get100doorSwapResult() {
		DecisionEngineTemplate template = new DecisionEngineTemplate();
		template.setNumberOfDoors(100);
		template.setSwapping(true);
		template.setNumberOfRounds(1);
		
		String message = "Aww, I'm sorry!  You lost!";
		int result = decisionEngineDomainServiceImpl.letsMakeADealFast(template);
		if (result == 1) {
			message = "Congratulations!  You won!";
		}

		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	

	@RequestMapping(value="/100doorSwap1000", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> get100doorSwap1000Result() {
		DecisionEngineTemplate template = new DecisionEngineTemplate();
		template.setNumberOfDoors(100);
		template.setSwapping(true);
		template.setNumberOfRounds(1000);
		
		int result = decisionEngineDomainServiceImpl.letsMakeADealFast(template);
		String message = "You won " + result + " times out of 1000!";

		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
}
