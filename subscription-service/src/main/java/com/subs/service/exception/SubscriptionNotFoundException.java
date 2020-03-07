package com.subs.service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SubscriptionNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -2187612384600792668L;

    public SubscriptionNotFoundException(String exception) {
        super(exception);
    }
}
