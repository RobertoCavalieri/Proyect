package com.example.proyect;

import com.example.proyect.entities.Character;
import com.example.proyect.repository.CharacterRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLOutput;

@SpringBootApplication
public class ProyectApplication {
    public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(ProyectApplication.class, args);
    CharacterRepository repository = context.getBean(CharacterRepository.class);


        Character character1 = new Character(null, "Palagroxor", 39, 6, 24);
        repository.save(character1);
        System.out.println("Personaje 1 " + character1);
        System.out.println("Num libros en base de datos: " + repository.findAll().size());

    }
}
