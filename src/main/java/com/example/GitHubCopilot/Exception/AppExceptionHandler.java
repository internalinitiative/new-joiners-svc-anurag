package com.example.GitHubCopilot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.*;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> validateEntityArgumen(MethodArgumentNotValidException ex){

        Map<String,String> errormap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                err -> errormap.put(err.getField(), err.getDefaultMessage())
        );
        return errormap;
    }


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> NoSuchElementException(NoSuchElementException exception){

        return new ResponseEntity<>("No value present with provided id !!", HttpStatus.NOT_FOUND);
    }
}
