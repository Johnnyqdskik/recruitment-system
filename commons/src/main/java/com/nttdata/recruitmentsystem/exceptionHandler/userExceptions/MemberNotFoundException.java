package com.nttdata.recruitmentsystem.exceptionHandler.userExceptions;

import com.nttdata.recruitmentsystem.exceptionHandler.commonExceptions.EntityNotFoundException;

public class MemberNotFoundException extends EntityNotFoundException {

    public MemberNotFoundException(Long target) {
        super(target + " is not found");
    }
}
