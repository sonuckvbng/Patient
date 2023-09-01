package patient.in.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;


public class NotFoundException extends Exception{

    public NotFoundException(String msge){
        super(msge);
    }
}
