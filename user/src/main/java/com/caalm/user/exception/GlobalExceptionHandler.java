package com.caalm.user.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.caalm.user.payload.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFound ex){
        String message=ex.getMessage();
        ApiResponse apiResponse=new ApiResponse(message,false);
        
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){

        Map<String,String> resp=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((err)->{
            String field_name=((FieldError)err).getField();
            String message= err.getDefaultMessage();
            resp.put(field_name, message);
        });
        return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
    }

    
}
