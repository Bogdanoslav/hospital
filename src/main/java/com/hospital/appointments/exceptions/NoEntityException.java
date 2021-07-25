package com.hospital.appointments.exceptions;

public class NoEntityException extends RuntimeException{
    public NoEntityException(String message) {
        super(message + "   not found");
    }
}
