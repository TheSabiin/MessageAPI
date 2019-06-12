package br.edu.uniopet.messageapi.exception;

import br.edu.uniopet.messageapi.payload.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NoSuchElementException.class})
    protected ResponseEntity<Object> notFoundException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new ApiResponse(404, "Resource not found"), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    protected ResponseEntity<Object> nullException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new ApiResponse(412, ex.getMessage()), new HttpHeaders(), HttpStatus.PRECONDITION_FAILED, request);
    }
}
