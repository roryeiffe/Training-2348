package com.revature.registration.exceptions;

/**
 * We will throw this exception whenever our Workshop service (or any other downstream service) is unavailable
 */
public class DownstreamUnavailableException extends RuntimeException{
    public DownstreamUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
