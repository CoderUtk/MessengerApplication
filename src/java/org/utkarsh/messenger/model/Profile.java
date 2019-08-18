package org.utkarsh.messenger.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {

    private String profileName;
    private String firstName;
    private String lastName;
    private long id;
    private Date dateCreated;

    public Profile(Long id, String profileName, String firstName, String lastName, Date dateCreated) {
        this.id = id;
        this.profileName = profileName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateCreated = new Date();
    }

    public Profile() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = new Date();
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

}
