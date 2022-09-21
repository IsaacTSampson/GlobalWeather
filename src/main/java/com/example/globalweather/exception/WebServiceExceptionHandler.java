package com.example.globalweather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ws.client.WebServiceIOException;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class WebServiceExceptionHandler {

    @ExceptionHandler(value = {WebServiceIOException.class})
    public ResponseEntity<Object> handleWebServiceException(WebServiceIOException e) {
        WebServiceException exception = new WebServiceException(
                e.getMessage() + " - Check mock SOAP service is running",
                HttpStatus.INTERNAL_SERVER_ERROR,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
