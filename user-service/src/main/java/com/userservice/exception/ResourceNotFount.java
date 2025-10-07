package com.userservice.exception;

public class ResourceNotFount extends RuntimeException{
    public ResourceNotFount(){
        super("Resource not found on server!!");
    }
    public ResourceNotFount(String message){
        super(message);
    }

}
