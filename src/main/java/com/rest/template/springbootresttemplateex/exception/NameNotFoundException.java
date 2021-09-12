package com.rest.template.springbootresttemplateex.exception;

public class NameNotFoundException extends RuntimeException{

    public NameNotFoundException(String msg){
        super(msg);
    }

    public NameNotFoundException(){

    }
}
