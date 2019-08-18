package org.utkarsh.messenger.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {

    private long id;
    private String comment;
    private Date dateCreated;
    private String author;

    public Comment(long id, String comment, String author) {
        this.id = id;
        this.comment = comment;
        this.author = author;
        this.dateCreated = new Date();
    }

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public String getComment() {
        return comment;
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

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = new Date();
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
