package com.caalm.user.exception;

public class SomethingWentWrong extends RuntimeException {
    
   String message;
    public SomethingWentWrong(String message){
        super(String.format("%s",message));
        this.message=message;
        
    }
}

