package com.mehak.remindflow.exception;

public class ReminderNotFoundException extends RuntimeException{
    public ReminderNotFoundException(String message) {
        super(message);
    }
}
