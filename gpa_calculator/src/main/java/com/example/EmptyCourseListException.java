package com.example;

public class EmptyCourseListException extends Exception{

    public EmptyCourseListException (String message){
        super(message);
    }

    public EmptyCourseListException (){
        super("List is currently empty");
    }
}