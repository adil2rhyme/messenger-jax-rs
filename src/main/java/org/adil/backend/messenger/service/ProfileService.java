package org.adil.backend.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.adil.backend.messenger.database.DatabaseClass;
import org.adil.backend.messenger.model.Profile;

public class ProfileService {

	Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService() {
		profiles.put("adil", new Profile(1L, "adil", "Adil", "Firoz", new Date()));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setProfileId(profiles.size() + 1L);
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

	public Profile deleteProfile(String profileName) {
		return profiles.remove(profileName);
	}

}
