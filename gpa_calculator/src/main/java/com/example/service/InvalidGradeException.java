package com.example.service;

public class InvalidGradeException extends Exception{

    public InvalidGradeException (String message){
        super(message);
    }

    public InvalidGradeException (){
        super("The grade entered is invalid.");
    }
}