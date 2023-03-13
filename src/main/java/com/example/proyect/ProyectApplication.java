package com.example.proyect;

import com.example.proyect.entities.CharacterCreator;
import com.example.proyect.entities.Stats;
import com.example.proyect.repository.CharacterRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProyectApplication {
    public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(ProyectApplication.class, args);
    CharacterRepository repository = context.getBean(CharacterRepository.class);


        CharacterCreator characterCreator1 = new CharacterCreator(null, "Palagroxor", 39, 6, new Stats(12, 9, 15, 10, 10, 8));
        CharacterCreator characterCreator2 = new CharacterCreator(null, "Palagroxor el segundo", 45, 8, new Stats(12, 9, 15, 10, 10, 8));

        repository.save(characterCreator1);
        repository.save(characterCreator2);
        System.out.println("Personaje 1 " + characterCreator1);
        System.out.println("Num libros en base de datos: " + repository.findAll().size());

    }
}
