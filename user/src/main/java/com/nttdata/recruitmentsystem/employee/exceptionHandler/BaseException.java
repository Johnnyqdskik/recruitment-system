package com.nttdata.recruitmentsystem.employee.exceptionHandler;

import com.nttdata.recruitmentsystem.employee.dto.ExceptionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public abstract class BaseException extends Exception {
    private ExceptionDto messageDto;

    public BaseException(String message) {
        this.messageDto = new ExceptionDto(message);
    }

    public ExceptionDto getMessageDto() {
        return messageDto;
    }

    public void setMessageDto(ExceptionDto messageDto) {
        this.messageDto = messageDto;
    }
}
