package org.utkarsh.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

    private String errorMessage;
    private int errorCode;
    private String document;

    public ErrorMessage() {
    }

    public ErrorMessage(int errorCode, String errorMessage, String document) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.document = document;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getDocument() {
        return document;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setDocument(String document) {
        this.document = document;
    }

}
