package com.example.fleetmaster.entity.assigment.exception;

public class AssignmentNotFoundException extends RuntimeException{
    
    public AssignmentNotFoundException(){
        super ("Couldn't find the assigment!");
    }
    
}
