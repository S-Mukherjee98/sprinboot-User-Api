package com.caalm.user.exception;

public class DuplicateKey extends RuntimeException{
    String message;
    DuplicateKey(String message){
        super(String.format("%s",message));
        message=this.message;
    }
}
