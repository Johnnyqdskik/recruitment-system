package com.nttdata.recruitmentsystem.exceptionHandler.userExceptions;

import com.nttdata.recruitmentsystem.exceptionHandler.baseExceptions.ErrorCode;
import com.nttdata.recruitmentsystem.exceptionHandler.commonExceptions.InvalidValueException;

public class UsernameDuplicateException extends InvalidValueException {

    public UsernameDuplicateException(final String username) {
        super(username, ErrorCode.USERNAME_ALREADY_EXISTS);
    }
}
