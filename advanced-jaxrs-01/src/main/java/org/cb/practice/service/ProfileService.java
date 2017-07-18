package org.cb.practice.service;

import java.util.ArrayList;
import java.util.Map;

import org.cb.practice.messenger.database.DatabaseClass;
import org.cb.practice.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
										//(long id, String profileName, String firstName, String lastName)
		profiles.put("chinna", new Profile(1L, "chinna", "Chinna Babu", "Sadam"));
		profiles.put("ram", new Profile(2L, "ram", "Rama Nayudu", "Sadam"));
		
	}
	
	
	public ArrayList<Profile> getAllProfile() {
		
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfiel(String profileName) {
		
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		
		if(profiles.containsKey(profileName)) {
			
			return profiles.remove(profileName);
		}
		else {	
			return null;
		}
		
		//System.out.println(profiles.remove(profileName));		
	}
	
	

}
