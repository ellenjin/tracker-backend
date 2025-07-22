package com.adadev.tracker_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
This exception can be used for when a user does not exist -- either by id or by username.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String field, Object value) {
        super(String.format("User with %s '%s' not found", field, value));
    }
}

