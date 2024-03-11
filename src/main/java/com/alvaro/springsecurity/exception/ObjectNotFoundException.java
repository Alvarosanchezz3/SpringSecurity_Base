package com.alvaro.springsecurity.exception;

// Excepción personalizada para poder personalizar el mensaje
public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException() {}

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
