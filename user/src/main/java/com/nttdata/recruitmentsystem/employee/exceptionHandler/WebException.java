package com.nttdata.recruitmentsystem.employee.exceptionHandler;

import com.nttdata.recruitmentsystem.employee.dto.ExceptionDto;

public class WebException {

    public static class UserNotFoundException extends BaseException
    {
        public UserNotFoundException() { super("Incorrect log type!"); }
    }
    public static class EmailExistsException extends BaseException
    {
        public EmailExistsException() { super("Email exists."); }
    }
    public static class UsernameExistsException extends BaseException
    {
        public UsernameExistsException() { super("Username exists!"); }
    }
    public static class InvalidCredentialsException extends BaseException
    {
        public InvalidCredentialsException() { super("Username/email or password incorrect!"); }
    }


}
