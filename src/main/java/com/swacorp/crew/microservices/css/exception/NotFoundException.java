package com.swacorp.crew.microservices.css.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * NotFoundException class to modified custom error message
 * @author PodNorris
 */
@ResponseStatus (value = HttpStatus.NOT_FOUND, reason = "Custom message NotFoundException")
public class NotFoundException extends Exception{
    
}
