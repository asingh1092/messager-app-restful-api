package com.singh.messenger.service;

import java.util.ArrayList;
import java.util.Map;

import com.singh.messenger.database.DatabaseClass;
import com.singh.messenger.model.Profile;

public class ProfileService {

	// Method that connects to the database
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService() {
		profiles.put("FirstProfile", new Profile(1, "FirstProfile", "Amrit", "Singh"));
		profiles.put("2ndProfile", new Profile(2, "2ndProfile", "yo", "man"));
	}

	public ArrayList<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
