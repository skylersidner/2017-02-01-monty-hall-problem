package com.montyhall.domain;

public interface DecisionEngineDomainService {
	
	public int letsMakeADealFast(DecisionEngineTemplate template);
	
	public int letsMakeADealSlow(DecisionEngineTemplate template, int choiceDoor);

}
