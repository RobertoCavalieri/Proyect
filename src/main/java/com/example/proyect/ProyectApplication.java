package com.example.proyect;

import com.example.proyect.entities.CharacterCreator;
import com.example.proyect.entities.Stats;
import com.example.proyect.entities.races.Elf;
import com.example.proyect.entities.races.Human;
import com.example.proyect.repository.CharacterRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProyectApplication {
    public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(ProyectApplication.class, args);
    CharacterRepository repository = context.getBean(CharacterRepository.class);


        //CharacterCreator characterCreator1 = new CharacterCreator(null, "Palagroxor", 39, 6, new Stats(12, 9, 15, 10, 10, 8));
        //CharacterCreator characterCreator2 = new CharacterCreator(null, "Palagroxor el segundo", 45, 8, new Stats(12, 9, 15, 10, 10, 8));
        Stats stats = new Stats(null, " JOSE", 5, 6, 8, 7 , 9, 8, 7, 4);
        Human PJ1 = new Human(null, "Lopez", 68, 12, 9, 15, 16, 5, 16, 19);
        Elf PJ2 = new Elf(null, "Aelar", 40, 3, 12, 15, 14, 16, 18, 8);
        System.out.println("estadísticas de " + PJ1.getName() +" " + PJ1);
        System.out.println("estadísticas de " + PJ2.getName() +" " + PJ2);
        repository.save(PJ1);
        repository.save(PJ2);
        repository.save(stats);
     /*repository.save(characterCreator1);
        repository.save(characterCreator2);
        System.out.println("Personaje 1 " + characterCreator1.toString());*/
        System.out.println("Num libros en base de datos: " + repository.findAll().size());

    }
}
