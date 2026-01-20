package com.example.rsvp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RsvpNotFoundException extends RuntimeException {

    private final String name;

    public RsvpNotFoundException(String name) {
        super("RSVP not found for name: " + name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}