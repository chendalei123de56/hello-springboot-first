package com.hecdu.springboot.first.exception;

public class LoginNameNotExistsException extends LoginException {
    public LoginNameNotExistsException() {
        super();
    }

    public LoginNameNotExistsException(String message) {
        super(message);
    }

    public LoginNameNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginNameNotExistsException(Throwable cause) {
        super(cause);
    }

    protected LoginNameNotExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
