package com.example.proyect.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExcepcionHandler extends RuntimeException {
    public ExcepcionHandler(String mensaje) {
        super(mensaje);
    }
    public class InvalidCharacterIdException extends RuntimeException {
        public InvalidCharacterIdException(String mensaje) {
            super(mensaje);
        }
    }

    public class CharacterNotFoundException extends RuntimeException {
        public CharacterNotFoundException(String mensaje) {
            super(mensaje);
        }
    }

}


