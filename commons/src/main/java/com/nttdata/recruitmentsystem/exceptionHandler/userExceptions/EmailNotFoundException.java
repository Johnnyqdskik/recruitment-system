package com.nttdata.recruitmentsystem.exceptionHandler.userExceptions;


import com.nttdata.recruitmentsystem.exceptionHandler.commonExceptions.EntityNotFoundException;

public class EmailNotFoundException extends EntityNotFoundException {

    public EmailNotFoundException(String email) {
        super(email + " is not found");
    }
}
