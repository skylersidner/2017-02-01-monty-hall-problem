package com.montyhall.controllers;

import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.montyhall.domain.DecisionEngineDomainServiceImpl;
import com.montyhall.domain.DecisionEngineTemplate;

@RestController
@RequestMapping("/slow")
public class SlowDecisionController {
	
	//Not really sure what to do with this.  My original intent was to program this to be as obvious and tangible
	//about the solution as possible, going through steps to generate an array of doors, set the closed door properly
	//etc, but when you give up the visual, it's actually really hard to do this and have it be meaningful.  Keeping
	//it for now to see if I can come up with some way for it to be useful.
	//Hopefully my front-end version can do better when there's something for the user to interact with.

	@Inject
	DecisionEngineDomainServiceImpl decisionEngineDomainServiceImpl;

	@RequestMapping(value="/3doorStay", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String get3doorStayResult() {
		DecisionEngineTemplate template = new DecisionEngineTemplate();
		template.setNumberOfDoors(3);
		template.setSwapping(false);
		template.setNumberOfRounds(1);
		
		//will eventually be player's choice; random for now
		int choiceDoor = ThreadLocalRandom.current().nextInt(1, (template.getNumberOfDoors() + 1));
		
		String message = "Aww, I'm sorry!  You lost!";
		int result = decisionEngineDomainServiceImpl.letsMakeADealSlow(template, choiceDoor);
		if (result == 1) {
			message = "Congratulations!  You won!";
		}
		return message;
	}
}
