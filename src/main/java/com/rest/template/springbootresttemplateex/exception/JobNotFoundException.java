package com.rest.template.springbootresttemplateex.exception;

public class JobNotFoundException extends RuntimeException{

    public JobNotFoundException(String msg){
        super(msg);
    }

    public JobNotFoundException() {

    }

}
