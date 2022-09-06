package com.person.wefin.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import javax.management.openmbean.KeyAlreadyExistsException;

@RestControllerAdvice
public class ErrorHandler {

    private String errors = "";

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ExceptionResponse invalidInput(IllegalArgumentException exception) {
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), "Digite um CPF ou CNPJ valido. Os valores nao devem ter pontuacao.");
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(KeyAlreadyExistsException.class)
    public ExceptionResponse dataAlreadyExists(KeyAlreadyExistsException exception) {
        return new ExceptionResponse( HttpStatus.BAD_REQUEST.value(), "Esse CPF/CNPJ ja esta cadastrado.");
    }

    @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ExceptionResponse methodNotAllowed(HttpRequestMethodNotSupportedException exception) {
        return new ExceptionResponse( HttpStatus.METHOD_NOT_ALLOWED.value(), "Esse metodo nao e permitido.");
    }

}
