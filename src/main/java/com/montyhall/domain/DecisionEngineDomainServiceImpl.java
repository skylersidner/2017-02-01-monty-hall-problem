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
			int prizeDoor = ThreadLocalRandom.current().nextInt(1, (template.getNumberOfDoors() + 1));
		
			//get random number for choiceDoor
			//same randomizer condition as prizeDoor
			int choiceDoor = ThreadLocalRandom.current().nextInt(1, (template.getNumberOfDoors() + 1));
		
			int closedDoor = 0;
			if (choiceDoor != prizeDoor) {
				closedDoor = prizeDoor;
			}
		
			//set choiceDoor based on isSwapping
			if (template.isSwapping()) {
				choiceDoor = closedDoor;
			}
		
			//determine if player wins and increment
		 	if (choiceDoor == prizeDoor) {
			   numberOfWins++;
			}
		}
		
		return numberOfWins;
	}
	
	public int letsMakeADealSlow(DecisionEngineTemplate template, int choiceDoor) {
		//This method isn't meaningfully different than the fast version; see SlowDecisionController
		
		if (template.getNumberOfRounds() > 100 || template.getNumberOfDoors() > 100) {
			throw new TooManyException();
		}
		
		int numberOfWins = 0;
		for (int x = 0; x < template.getNumberOfRounds(); x++) {
			//get random number for prizeDoor
			//int between 1 and numberOfDoors, inclusive;
			int prizeDoor = ThreadLocalRandom.current().nextInt(1, (template.getNumberOfDoors() + 1));
		
			//Decide which door to leave closed; this is easy if they haven't picked the prize door
			//because then it MUST be the prize door (since you can't open that one!).
			//If they have chosen the prize door, you have to randomly leave one of the others closed;
			//logic is necessary to be sure you don't pick the choice/prize door.
			int closedDoor = 0;
			if (choiceDoor == prizeDoor) {
				boolean isClosedDoorValid = false;
				while (isClosedDoorValid) {
					closedDoor = ThreadLocalRandom.current().nextInt(1, (template.getNumberOfDoors() + 1));
					if (closedDoor != choiceDoor) {
						isClosedDoorValid = true;
					}
				}
			} else {
				closedDoor = prizeDoor;
			}
		
			//set choiceDoor based on isSwapping
			if (template.isSwapping()) {
				choiceDoor = closedDoor;
			}
		
			//determine if player wins and increment
		 	if (choiceDoor == prizeDoor) {
			   numberOfWins++;
			}
		}
		
		return numberOfWins;
	}

}
