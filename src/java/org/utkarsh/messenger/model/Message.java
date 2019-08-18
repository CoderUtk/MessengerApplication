package org.utkarsh.messenger.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {

    private long id;
    private String message;
    private Date dateCreated;
    private String author;
    private Map<Long, Comment> comments = new HashMap<>();

    public Message(long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
        this.dateCreated = new Date();
    }

    public Message() {
    }

    @XmlTransient
    public Map<Long, Comment> getComments() {
        return comments;
    }

    public void setComments(Map<Long, Comment> comments) {
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = new Date();
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
