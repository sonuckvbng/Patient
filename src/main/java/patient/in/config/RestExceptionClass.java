package patient.in.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import patient.in.exception.NotFoundException;


@RestControllerAdvice
public class RestExceptionClass {

    @ExceptionHandler(value= NotFoundException.class)
    public ApiError handleException(NotFoundException e){


        String message = e.getMessage();
        ApiError error=new ApiError(message,"no");




        return error;
    }



    }

