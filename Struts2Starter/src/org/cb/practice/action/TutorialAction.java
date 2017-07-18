package org.cb.practice.action;

import org.cb.practice.service.TutorialFinderService;

public class TutorialAction    {

	private String bestTutorialSite;
	private String language;
	
		public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


		public String execute() {
	
		TutorialFinderService tutorialFinderService = new TutorialFinderService();
		
		setBestTutorialSite(tutorialFinderService.getBestTutorialSite(getLanguage()));
		
		//System.out.println(language);
		
		return "success";
	}
	
	
	public String getBestTutorialSite() {
		return bestTutorialSite;
	}

	public void setBestTutorialSite(String bestTutorialSite) {
		this.bestTutorialSite = bestTutorialSite;
	}
}
