package org.cb.practice.service;

public class TutorialFinderService {
	
	

	public String getBestTutorialSite(String language) {
		
		if(language.equals("java"))
		return "Java Brains";
		else
			return "language not supported yet!";
	}
	

}
