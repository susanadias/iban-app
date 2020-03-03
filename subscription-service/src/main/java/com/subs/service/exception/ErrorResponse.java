package com.subs.service.exception;



import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * Error Response class represents the message of error between client and server
 * 
 */

import java.time.LocalDateTime;

public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
    private int status;
    private String message;

    private ErrorResponse(ErrorResponseBuilder errorResponsebuilder) {
        this.timestamp = errorResponsebuilder.timestamp;
        this.status = errorResponsebuilder.status;
        this.message = errorResponsebuilder.message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ErrorResponse [status=" + status + ", message=" + message + "]";
    }

    /*
     * Design pattern - Error Response Builder
     * 
     */

    public static final class ErrorResponseBuilder {
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
        private LocalDateTime timestamp;
        private int status;
        private String message;

        public ErrorResponseBuilder(LocalDateTime timestamp) {
            this.timestamp = timestamp;

        }

        public ErrorResponseBuilder setStatus(int status) {
            this.status = status;
            return this;
        }

        public ErrorResponseBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public ErrorResponse build() {
            // call the private constructor in the outer class
            return new ErrorResponse(this);
        }

    }

    // END CLASS
}
