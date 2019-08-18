package org.utkarsh.messenger.exception;

public class NoDataFoundException extends RuntimeException {

    private static final long serialVersionUID = 999999999;

    public NoDataFoundException(String msg) {
        super(msg);
    }

}
