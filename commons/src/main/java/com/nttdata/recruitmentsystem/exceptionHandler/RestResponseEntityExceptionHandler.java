package com.nttdata.recruitmentsystem.exceptionHandler;

import com.nttdata.recruitmentsystem.exceptionHandler.exceptions.ErrorCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler({ErrorCode.class)
//    public ResponseEntity<Object> handleEmailExistsException(
//            Exception e, WebRequest request) {
//        return new ResponseEntity<Object>(
//                ResponseEntity.badRequest().body(e, new HttpHeaders(), HttpStatus.BAD_REQUEST);
//    }
}
