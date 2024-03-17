package com.fenton.rest_api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FieldsNotEnteredException extends RuntimeException {
    public FieldsNotEnteredException() {
        super("Please enter all the fields");
    }
}
