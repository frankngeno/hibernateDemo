package com.grl.hibernateDemo.pickOrderHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class PickOrderServiceNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PickOrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String pickOrderServiceNotFoundHandler(PickOrderNotFoundException ex){
        return ex.getMessage();
    }
}
