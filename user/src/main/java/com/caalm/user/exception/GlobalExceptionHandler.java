package com.caalm.user.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.dao.DuplicateKeyException;
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

    

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ApiResponse> duplicateKeyExceptionHandler(DuplicateKeyException ex){
        String message="Username or Mobile Number or Reg.No Can not be duplicate";
        ApiResponse apiResponse=new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ApiResponse> maxUploadSizeExceedExceptionHandler(MaxUploadSizeExceededException e){
        String message="Maximum file size should be less than 10MB";
        ApiResponse apiResponse=new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    
}
