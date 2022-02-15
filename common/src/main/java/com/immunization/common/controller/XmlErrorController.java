package com.immunization.common.controller;

import java.util.ArrayList;
import java.util.List;

import com.immunization.common.dto.AttributeDTO;
import com.immunization.common.dto.ErrorDTO;
import com.immunization.common.exception.base.BadRequestException;
import com.immunization.common.exception.base.ConflictException;
import com.immunization.common.exception.base.ForbiddenException;
import com.immunization.common.exception.base.InternalServerErrorException;
import com.immunization.common.exception.base.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.UnmarshallingFailureException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class XmlErrorController {

    @ExceptionHandler({
            BadRequestException.class,
            UnmarshallingFailureException.class,
            MethodArgumentNotValidException.class
    })
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleBadRequest(Exception e) {
        ErrorDTO error = getErrorDtoFromException(e);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_XML)
                .body(error);
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleForbidden(Exception e) {
        ErrorDTO error = getErrorDtoFromException(e);

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .contentType(MediaType.APPLICATION_XML)
                .body(error);
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleConflict(Exception e) {
        ErrorDTO error = getErrorDtoFromException(e);

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .contentType(MediaType.APPLICATION_XML)
                .body(error);
    }

    @ExceptionHandler({
        InternalAuthenticationServiceException.class,
        BadCredentialsException.class
    })
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleUnauthorized(Exception e) {
        ErrorDTO error = getErrorDtoFromException(e);

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .contentType(MediaType.APPLICATION_XML)
                .body(error);
    }

    @ExceptionHandler({
        InternalServerErrorException.class
    })
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleInternalServerError(Exception e) {
        ErrorDTO error = getErrorDtoFromException(e);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_XML)
                .body(error);
    }

    @ExceptionHandler({
        NotFoundException.class,
        UsernameNotFoundException.class
    })
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleNotFound(Exception e) {
        ErrorDTO error = getErrorDtoFromException(e);

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_XML)
                .body(error);
    }

    private ErrorDTO getErrorDtoFromException(Exception e) {
        ErrorDTO error = new ErrorDTO();
        List<AttributeDTO> attributes = new ArrayList<>();
        AttributeDTO attribute = new AttributeDTO();
        attribute.setKey("message");
        attribute.setValue(e.getMessage());
        attributes.add(attribute);

        error.setAttributes(attributes);
        return error;
    }
}
