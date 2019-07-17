package com.hecdu.springboot.first.exception;
//账户异常
public class AccoutException extends Exception {
    public AccoutException() {
        super();
    }

    public AccoutException(String message) {
        super(message);
    }

    public AccoutException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccoutException(Throwable cause) {
        super(cause);
    }

    protected AccoutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
