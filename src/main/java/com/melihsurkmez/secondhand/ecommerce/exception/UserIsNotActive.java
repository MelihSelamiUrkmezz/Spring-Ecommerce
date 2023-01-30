package com.melihsurkmez.secondhand.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserIsNotActive extends RuntimeException {

    public UserIsNotActive(String message) {
        super(message);
    }
}
