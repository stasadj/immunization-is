package com.immunization.common.exception;

import com.immunization.common.exception.base.InternalServerErrorException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FailedMetadataExtractionException extends InternalServerErrorException {
    public FailedMetadataExtractionException(String message) {
        super(message);
    }
    
    public FailedMetadataExtractionException() {
        super("Internal Server Error");
    }
}
