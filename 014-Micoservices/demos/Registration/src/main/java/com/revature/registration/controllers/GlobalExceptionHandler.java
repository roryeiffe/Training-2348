package com.revature.registration.controllers;

import com.revature.registration.exceptions.DownstreamUnavailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.CompletionException;

@ControllerAdvice
public class GlobalExceptionHandler {
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

    // Resilience
    @ExceptionHandler(DownstreamUnavailableException.class)
    public ResponseEntity<Map<String, Object>> handleDownstreamFailure(DownstreamUnavailableException ex) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(getErrorBody(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage()));
    }

    // When a CompletableFuture invokes.join and an exception is thrown, then the CompletionException is what will be "caught" by this GlobalExceptionHandler
    // In tihs case, we want to un-wrap the underlying exception and then return the appropriate request
    @ExceptionHandler(CompletionException.class)
    public ResponseEntity<Map<String, Object>> handleCompletionException(CompletionException ex) {
        // logic for unwrapping the underlying exception:
        Throwable root = ex.getCause();

        if(root instanceof DownstreamUnavailableException downstreamEx) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(getErrorBody(HttpStatus.SERVICE_UNAVAILABLE, downstreamEx.getMessage()));
        }

        // If it was not Downstream Exception that caused this, just send a more generic response back
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(getErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected Error"));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleOther(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(getErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected Error"));
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
