package com.person.wefin.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.management.openmbean.KeyAlreadyExistsException;

@RestControllerAdvice
public class ErrorHandler {

    private String errors = "";

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ExceptionResponse invalidInput(IllegalArgumentException exception) {
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), "Digite um CPF ou CNPJ válido. Os valores nao devem ter pontuacao.");
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(KeyAlreadyExistsException.class)
    public ExceptionResponse dataAlreadyExists(KeyAlreadyExistsException exception) {
        return new ExceptionResponse( HttpStatus.BAD_REQUEST.value(), "Esse CPF/CNPJ ja esta cadastrado.");
    }

}
