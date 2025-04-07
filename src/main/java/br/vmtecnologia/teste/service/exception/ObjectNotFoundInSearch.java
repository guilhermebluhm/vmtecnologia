package br.vmtecnologia.teste.service.exception;

public class ObjectNotFoundInSearch extends RuntimeException {

    public ObjectNotFoundInSearch(String message) {
        super(message);
    }

}
