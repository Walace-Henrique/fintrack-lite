package com.walace.fintrack.exception;

// Exceção de domínio para "não encontrado"
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
