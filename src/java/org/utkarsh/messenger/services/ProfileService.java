package org.utkarsh.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.utkarsh.messenger.database.Database;
import org.utkarsh.messenger.model.Profile;

public class ProfileService {

    private final Map<Long, Profile> profiles = Database.getProfiles();

    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profiles.values());
    }

    public Profile getProfile(Long id) {
        return profiles.get(id);
    }

    public Profile addProfile(Profile profile) {
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getId(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile) {
        if (profile.getId() <= 0) {
            return null;
        }
        profiles.put(profile.getId(), profile);
        return profile;
    }

    public void removeProfile(Long id) {
        profiles.remove(id);
    }

}
