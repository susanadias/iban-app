package com.subs.service.exception;



import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;



@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException  {
    
  

    /**
     * 
     */
    private static final long serialVersionUID = -1037931633944817892L;

    public UserNotFoundException (String exception) {
        super(exception);
    }

}
