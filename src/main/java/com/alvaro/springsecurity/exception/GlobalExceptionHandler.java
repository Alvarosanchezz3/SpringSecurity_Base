package com.alvaro.springsecurity.exception;

import com.alvaro.springsecurity.dto.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerGenericException(HttpServletRequest request, Exception exception) {

        ApiError apiError = new ApiError();
            apiError.setBackendMessage(exception.getLocalizedMessage());
            apiError.setUrl(request.getRequestURL().toString());
            apiError.setMethod(request.getMethod());
            apiError.setTimestamp(LocalDateTime.now());
            apiError.setMessage("Error interno del servidor");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerMethodArgumentNotValidExceptionException(HttpServletRequest request,
                                                                             MethodArgumentNotValidException exception) {

        ApiError apiError = new ApiError();
        apiError.setBackendMessage(exception.getAllErrors().stream().map(each -> each.getDefaultMessage()).
                                                                         collect(Collectors.toList()).toString());
        apiError.setUrl(request.getRequestURL().toString());
        apiError.setMethod(request.getMethod());
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setMessage("Error en la petición enviadada");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
}
