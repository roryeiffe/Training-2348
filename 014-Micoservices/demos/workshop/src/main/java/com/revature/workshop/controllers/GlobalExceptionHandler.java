package com.revature.workshop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.Map;

/**
 * When an exception is thrown, this class will resolve them, based on the ExceptionHandlers
 * we define below.
 * We need to annotate the class with @ControllerAdvice for this to work
 * And we will specify an ExceptionHandler for each type of exception we want to handle
 */
@ControllerAdvice(basePackages = "com.revature.workshop")
public class GlobalExceptionHandler {

    // This annotation means that whenever IllegalArgumentException is thrown, we delegate to this method to handle the response to the client
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgument(IllegalArgumentException ex) {
        // Returning a response entity, specifying the status code and formatting a detailed body using our private helper method
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(getErrorBody(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalState(IllegalStateException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(getErrorBody(HttpStatus.CONFLICT, ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception ex) {
        return ResponseEntity.
                status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(getErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong that wasn't handled by our explicit Exception Handlers"));

    }

    /**
     * Helper method to help format our responses:
     * Given an HttpStatus and a message, this method
     * will format a Map object to be returned in a human-readble format
     * including the time
     */
    private Map<String, Object> getErrorBody(HttpStatus status, String message) {
        return Map.of(
                "timestamp", Instant.now().toString(),
                "status", status.value(),
                "error", status.getReasonPhrase(),
                "message", message
        );
    }
}
