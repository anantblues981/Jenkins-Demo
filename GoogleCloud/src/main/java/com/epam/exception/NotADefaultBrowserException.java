package com.epam.exception;

public class NotADefaultBrowserException extends RuntimeException {
    public NotADefaultBrowserException(String message) {
        super(message);
    }
}
