package org.utkarsh.messenger.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.utkarsh.messenger.model.Profile;
import org.utkarsh.messenger.services.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

    ProfileService profileService = new ProfileService();

    @GET
    public List<Profile> getProfiles() {
        return profileService.getAllProfiles();
    }

    @GET
    @Path("/{profileId}") // One can also use regex -- make a note
    public Profile getProfile(@PathParam("profileId") long id) {
        return profileService.getProfile(id);
    }

    @POST
    public Profile addProfile(Profile profile) {
        return profileService.addProfile(profile);
    }

    @PUT
    @Path("/{profileId}")
    public Profile updateProfile(@PathParam("profileId") long id, Profile profile) {
        profile.setId(id);
        return profileService.updateProfile(profile);
    }

    @DELETE
    @Path("/{profileId}")
    public void deleteProfile(@PathParam("profileId") long id) {
        profileService.removeProfile(id);
    }
}
