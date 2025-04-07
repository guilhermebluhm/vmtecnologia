package br.vmtecnologia.teste.service.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class FieldForHandlerError {

    private LocalDate timestamp;
    private Integer error;
    private String messageError;
    private String path;

    public FieldForHandlerError(LocalDate timestamp, Integer error, String messageError, String path) {
        this.timestamp = timestamp;
        this.error = error;
        this.messageError = messageError;
        this.path = path;
    }
}
