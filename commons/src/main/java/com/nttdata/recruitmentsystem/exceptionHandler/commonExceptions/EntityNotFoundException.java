package com.nttdata.recruitmentsystem.exceptionHandler.commonExceptions;

import com.nttdata.recruitmentsystem.exceptionHandler.baseExceptions.BaseException;
import com.nttdata.recruitmentsystem.exceptionHandler.baseExceptions.ErrorCode;

public class EntityNotFoundException extends BaseException {
    public EntityNotFoundException(String message) {
        super(message, ErrorCode.ENTITY_NOT_FOUND);
    }
}
