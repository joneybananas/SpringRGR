package com.festu.meeting.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String entityName) {
        super(entityName);
    }

}
