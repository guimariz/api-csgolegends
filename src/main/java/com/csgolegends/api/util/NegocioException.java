package com.csgolegends.api.util;

public class NegocioException extends RuntimeException {

    public NegocioException(String errorMessage, Throwable err) {
        super(errorMessage, err);    }


    public NegocioException(String errorMessage) {
        super(errorMessage);
    }
}
