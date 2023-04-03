package com.example.proyect.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExceptions extends RuntimeException{
    //esto no debería ser un String, ya que extiende de la SuperClase RuntimeException propia de Java
    public String NotFoundException(String message){
        //Esto debería ser super(message); para sobrescribir la Runtime
        return message;
    }
}
