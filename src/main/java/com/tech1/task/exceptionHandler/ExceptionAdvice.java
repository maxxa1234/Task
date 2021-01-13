package com.tech1.task.exceptionHandler;

import com.tech1.task.dto.ErrorDto;
import com.tech1.task.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    void handleException(UserNotFoundException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorDto> errors = new ArrayList<ErrorDto>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(new ErrorDto(error.getField(), error.getDefaultMessage()));
        }

        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(new ErrorDto(error.getObjectName(), error.getDefaultMessage()));
        }


        return handleExceptionInternal(
                ex, errors, headers, HttpStatus.BAD_REQUEST, request);
    }
}
