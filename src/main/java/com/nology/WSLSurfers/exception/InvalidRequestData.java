package com.nology.WSLSurfers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidRequestData extends Exception {
    public InvalidRequestData(String message) {
        super(message);
    }
}
