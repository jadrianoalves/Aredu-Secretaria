package com.aredu.secretaria.exceptions;

import org.springframework.web.client.HttpClientErrorException;

public class ApiExternalException extends RuntimeException {

    public ApiExternalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiExternalException(String message) {
        super(message);
    }
}
