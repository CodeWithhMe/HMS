package com.clinic.hms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author akhilkanakendran
 * Custom Exception Handler
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class HMSException extends RuntimeException {
    public HMSException(String message) {
        super(message);
    }
}
