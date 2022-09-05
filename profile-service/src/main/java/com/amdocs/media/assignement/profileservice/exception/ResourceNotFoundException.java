/**
 * 
 */
package com.amdocs.media.assignement.profileservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ikramshariff
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(String message){
        super(message);
    }

}
