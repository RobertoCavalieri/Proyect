package com.example.proyect;

import com.example.proyect.entities.Character;


import com.example.proyect.repository.ICharacterRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProyectApplication {
    public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(ProyectApplication.class, args);
    ICharacterRepository CharacterRepository = context.getBean(ICharacterRepository.class);

    Character characterJuan = new Character(null, "Humano", "Juan", 60, 5, 12, 8, 4, 12, 16, 30);
        Character characterPedro = new Character(null, "Humano", "Pedro", 60, 5, 12, 8, 4, 12, 16, 30);
        Character juancito = Character.builder()
                    .id(null)
                    .age(58)
                    .speed(12)
                    .name("Pedro")
                    .wisdom(14)
                    .dexterity(16)
                    .constitution(20)
                    .intelligence(7)
                    .charisma(16)
                    .strength(11)
                    .build();

        CharacterRepository.save(characterJuan);
        CharacterRepository.save(characterPedro);
        CharacterRepository.save(juancito);
        System.out.println("Heroes creados en base de datos: " + CharacterRepository.findAll().size());


    }
}
