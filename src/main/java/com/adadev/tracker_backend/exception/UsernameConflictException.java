package com.adadev.tracker_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
This exception can be used for when a username is already taken (when creating a new user)
 */

@ResponseStatus(HttpStatus.CONFLICT) // 409 conflict error
public class UsernameConflictException extends RuntimeException {
    public UsernameConflictException(String username) {
        super(String.format("Username \"%s\" already taken", username));
    }
}
