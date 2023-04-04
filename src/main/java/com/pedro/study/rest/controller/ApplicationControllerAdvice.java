package com.pedro.study.rest.controller;

import com.pedro.study.exception.RegraNegocioExceptional;
import com.pedro.study.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioExceptional.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleRegraNegocioException(RegraNegocioExceptional ex) {
        String menssagemErro = ex.getMessage();
        return new ApiErrors(menssagemErro);
    }
}
