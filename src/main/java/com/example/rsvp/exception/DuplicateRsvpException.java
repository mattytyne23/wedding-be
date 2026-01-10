package com.example.rsvp.exception;

import java.util.List;

public class DuplicateRsvpException extends RuntimeException {

    private final List<String> duplicateNames;

    public DuplicateRsvpException(List<String> duplicateNames) {
        super("Duplicate RSVP names found");
        this.duplicateNames = duplicateNames;
    }

    public List<String> getDuplicateNames() {
        return duplicateNames;
    }
}