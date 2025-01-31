package com.example.hexagonal_architecture.configurations.handler;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.hexagonal_architecture.configurations.handler.dto.CustomErrorResponse;
import com.example.hexagonal_architecture.configurations.handler.exceptions.ErrorCodeException;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler{

    @Resource
    private MessageSource messageSource;

    @ExceptionHandler({ErrorCodeException.class})
    private ResponseEntity<Object> handlerCoderError(Exception e, WebRequest request){
        CustomErrorResponse errorResponse = new CustomErrorResponse<>();

        errorResponse.setError(e.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        log.error(e.getMessage());

        return handleExceptionInternal(e, errorResponse, headers, HttpStatus.BAD_REQUEST, request);

    }
}
