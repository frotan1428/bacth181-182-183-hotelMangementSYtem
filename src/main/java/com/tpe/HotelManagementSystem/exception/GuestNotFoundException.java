package com.tpe.HotelManagementSystem.exception;

public class GuestNotFoundException extends RuntimeException {
    public GuestNotFoundException(String message) {
        super(message);
    }
}
