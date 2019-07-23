package com.products.products.exceptionhandling;

import com.products.products.exceptionhandling.exceptions.ProductNotFoundException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {

        return handleExceptionInternal(ex, message(HttpStatus.BAD_REQUEST, ex), headers,
                                                   HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, message(HttpStatus.BAD_REQUEST, ex), headers,
                HttpStatus.BAD_REQUEST, request);
    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundResource(ProductNotFoundException ex, WebRequest request){
        return handleExceptionInternal(ex, message(HttpStatus.NOT_FOUND, ex), new HttpHeaders(),
                HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class })
    public ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request) {
        logger.error("500 Status Code", ex);
        return handleExceptionInternal(ex, message(HttpStatus.INTERNAL_SERVER_ERROR, ex), new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    private ApiError message(final HttpStatus status, final Exception ex) {
        String message = ex.getMessage() == null ? ex.getClass().getSimpleName(): ex.getMessage();
        String devMessage = ExceptionUtils.getRootCauseMessage(ex);

        if(ex instanceof MethodArgumentNotValidException) {
            devMessage = handleValidationErrors((MethodArgumentNotValidException) ex).toString();
            return new ApiError(status.value(), message, devMessage);
        }

        return new ApiError(status.value(), message, devMessage);
    }

    private Map<String, String> handleValidationErrors(MethodArgumentNotValidException ex){
        final Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
