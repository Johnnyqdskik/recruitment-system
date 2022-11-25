package com.nttdata.recruitmentsystem.exceptionHandler.commonExceptions;

import com.nttdata.recruitmentsystem.exceptionHandler.baseExceptions.BaseException;
import com.nttdata.recruitmentsystem.exceptionHandler.baseExceptions.ErrorCode;

public class InvalidValueException extends BaseException {

    public InvalidValueException(String value) {
        super(value, ErrorCode.INVALID_INPUT_VALUE);
    }

    public InvalidValueException(String value, ErrorCode errorCode) {
        super(value, errorCode);
    }
}
