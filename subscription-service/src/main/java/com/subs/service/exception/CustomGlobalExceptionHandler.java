package com.subs.service.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/*
 * 
 * 
 * 
 */

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomGlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> customHandleNotFound(Exception ex, HttpServletRequest request) {
        
        LOGGER.error("Endpoint: [{}] {}", request.getMethod(), request.getRequestURI());
        LOGGER.error("Query String: {}", request.getQueryString());
        LOGGER.error("Exception: ", ex);

        ErrorResponse errorResponse = new ErrorResponse.ErrorResponseBuilder(LocalDateTime.now())
                .setStatus(HttpStatus.NOT_FOUND.value())
                .setMessage(ex.getMessage()).build();

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }

    
    /*
     * 
     * 
     */
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleInternalError(Exception ex, HttpServletRequest request) {
        LOGGER.error("Endpoint: [{}] {}", request.getMethod(), request.getRequestURI());
        LOGGER.error("Query String: {}", request.getQueryString());
        LOGGER.error("Exception: ", ex);
        
        ErrorResponse errorResponse = new ErrorResponse.ErrorResponseBuilder(LocalDateTime.now())
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setMessage(ex.getMessage()).build();
        
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    

}
