package com.montyhall.domain;

import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Named;

import com.montyhall.exceptions.TooManyException;

@Named
public class DecisionEngineDomainServiceImpl implements DecisionEngineDomainService {

	@Override
	public int letsMakeADealFast(DecisionEngineTemplate template) {
		if (template.getNumberOfRounds() > 1000 || template.getNumberOfDoors() > 1000) {
			throw new TooManyException();
		}
		
		int numberOfWins = 0;
		for (int x = 0; x < template.getNumberOfRounds(); x++) {
			//get random number for prizeDoor
			//int between 1 and numberOfDoors, inclusive;
			int prizeDoor = ThreadLocalRandom.current().nextInt(1, template.getNumberOfDoors() + 1);
		
			//get random number for choiceDoor
			//same randomizer condition as prizeDoor
			int choiceDoor = ThreadLocalRandom.current().nextInt(1, template.getNumberOfDoors() + 1);
		
			//get random number for closedDoor
			//same randomizer condition as prizeDoor, cannot be same as choiceDoor
			int closedDoor = 0;
			while (closedDoor != choiceDoor) {
				closedDoor = ThreadLocalRandom.current().nextInt(1, template.getNumberOfDoors() + 1);
			}
		
			//set choiceDoor based on isSwapping
			if (template.isSwapping()) {
				choiceDoor = closedDoor;
			}
		
			//determine if player wins and increment
		 	if (choiceDoor == prizeDoor || choiceDoor == closedDoor) {
			   numberOfWins++;
			}
		}
		
		return numberOfWins;
	}

}
