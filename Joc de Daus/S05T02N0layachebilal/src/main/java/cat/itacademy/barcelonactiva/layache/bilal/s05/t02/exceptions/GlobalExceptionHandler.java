package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NameAlreadyExistException.class)
    public ResponseEntity<String> handlerNameAlreadyExistExcepition(NameAlreadyExistException e, WebRequest request){
        String msg = e.getMessage()+" "+request.getDescription(false);
        return new ResponseEntity<String>(msg, HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(PlayerIdNotFoundException.class)
    public ResponseEntity<String> handlerPlayerIdNotFoundException(PlayerIdNotFoundException e, WebRequest request){
        String msg = e.getMessage()+" "+request.getDescription(false);
        return new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<String> handlerPlayerNotFoundException(PlayerNotFoundException e, WebRequest request){
        String msg = e.getMessage()+" "+request.getDescription(false);
        return new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
    }
}
