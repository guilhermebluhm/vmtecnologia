package br.vmtecnologia.teste.service.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class ObjectErrorNotFoundHandler extends RuntimeException {

    @ExceptionHandler(ObjectNotFoundInSearch.class)
    public ResponseEntity<FieldForHandlerError> objectErrorNotFoundHandler(ObjectNotFoundInSearch e,
                                                                           HttpServletRequest req){
        FieldForHandlerError err = new FieldForHandlerError(LocalDate.now(),
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                req.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}
