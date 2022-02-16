package com.immunization.common.exception;
import com.immunization.common.exception.base.BadRequestException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomConstraintViolationException extends BadRequestException {
    public CustomConstraintViolationException(String message) {
        super(message);
    }
}
