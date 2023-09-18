package com.tpe.hms.exception;


//step 8: custom message
public class HotelNotFoundException extends RuntimeException{
    public HotelNotFoundException(String message) {
        super(message);
    }
}
