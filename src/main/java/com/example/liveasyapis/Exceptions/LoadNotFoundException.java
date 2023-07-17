package com.example.liveasyapis.Exceptions;

public class LoadNotFoundException extends RuntimeException{
    public LoadNotFoundException(){
        super("Load not found") ;
    }
}
