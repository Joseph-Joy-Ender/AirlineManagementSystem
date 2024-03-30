package com.example.airlineproject.exceptions;

public class DuplicateFlightException extends Exception {
    public DuplicateFlightException(String message) {
        super(message);
    }
}
