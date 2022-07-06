package com.kenzie.app;

// create custom exceptions InvalidWeekException and InvalidDayOfWeekException first
//Each of these will pass in a root error from IllegalArgumentException

public class InvalidWeekException extends RuntimeException {
    public InvalidWeekException(String message){
        super(message);
    }

}
