package com.example.rsvp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateRsvpException.class)
    public ResponseEntity<Map<String, Object>> handleDuplicateRsvp(
            DuplicateRsvpException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("error", "DUPLICATE_RSVP");
        body.put("message", "The following names have already submitted an RSVP");
        body.put("duplicates", ex.getDuplicateNames());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(body);
    }

    @ExceptionHandler(RsvpNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleRsvpNotFound(
            RsvpNotFoundException ex) {

        Map<String, Object> body = new HashMap<>();
        body.put("error", "RSVP_NOT_FOUND");
        body.put("message", "No RSVP found for the provided name");
        body.put("name", ex.getName());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(body);
    }
}
