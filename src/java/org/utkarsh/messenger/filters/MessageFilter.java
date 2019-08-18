package org.utkarsh.messenger.filters;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class MessageFilter {

    @QueryParam("year")
    private int year;
    @QueryParam("start")
    private int start;
    @QueryParam("size")
    private int size;
    @PathParam("messageId")
    private long id;

    public int getYear() {
        return year;
    }

    public int getStart() {
        return start;
    }

    public int getSize() {
        return size;
    }

    public long getId() {
        return id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setId(long id) {
        this.id = id;
    }

}
