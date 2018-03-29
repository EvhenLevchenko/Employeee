package com.example.demo.exeptions;

public class DepartamentNotFoundException extends Exception {

    public DepartamentNotFoundException() {
    }

    public DepartamentNotFoundException(String message) {
        super(message);
    }

    public DepartamentNotFoundException(Throwable cause) {
        super(cause);
    }

    public DepartamentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartamentNotFoundException(String message, Throwable cause,
                                        boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
