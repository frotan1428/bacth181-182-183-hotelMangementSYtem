package com.tpe.HotelManagementSystem.exception;

//step 8: custom   message
public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(String message) {
        super(message);
    }

    //!!! open model pk Create Entity hotel and room
}
