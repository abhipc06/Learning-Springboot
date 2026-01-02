package com.learning.Product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CategoryAlreadyExistsException extends RuntimeException{

    public CategoryAlreadyExistsException(String message){
        super(message);// Passes the custom message to RuntimeException so this exception carries a clear reason that can be read later via getMessage(), logs, or error responses

    }
}
