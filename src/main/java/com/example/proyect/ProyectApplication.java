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

    Character characterJuan = new Character(null, "Juan", 60, 5, 12, 8, 4, 12, 16, 30);
        Character characterPedro = new Character(null, "Pedro", 60, 5, 12, 8, 4, 12, 16, 30);
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
      /*  Stats stats = new Stats(null, " JOSE", 68, 6, 8, 7 , 9, 8, 7);
        Human PJ1 = new Human(null, "Lopez", 68, 9, 15, 16, 5, 16, 19);
        HighElf PJ2 = new HighElf(null, "Aelar", 40, 8, 1, 14, 16, 18, 8);
        System.out.println("Datos de " + PJ1.getName() +" " + PJ1);
        System.out.println("Datos de " + PJ2.getName() +" " + PJ2);
        repository.save(PJ1);
        repository.save(PJ2);
        repository.save(stats);
        System.out.println("Heroes creados en base de datos: " + repository.findAll().size());*/

    }
}
