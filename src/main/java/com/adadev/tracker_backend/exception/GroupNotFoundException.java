package com.adadev.tracker_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
This exception can be used for when a group does not exist by id 
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class GroupNotFoundException extends RuntimeException {
    public GroupNotFoundException(String field, Object value) {
        super(String.format("Group with %s '%s' not found", field, value));
    }
}
