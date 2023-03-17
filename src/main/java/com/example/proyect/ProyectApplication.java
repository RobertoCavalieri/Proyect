package com.example.proyect;

import com.example.proyect.entities.Stats;
import com.example.proyect.entities.races.Human;
import com.example.proyect.entities.races.subraces.DarkElf;
import com.example.proyect.entities.races.subraces.HighElf;
import com.example.proyect.repository.CharacterRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProyectApplication {
    public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(ProyectApplication.class, args);
    CharacterRepository repository = context.getBean(CharacterRepository.class);


        Stats stats = new Stats(null, " JOSE", 68, 6, 8, 7 , 9, 8, 7);
        Human PJ1 = new Human(null, "Lopez", 68, 9, 15, 16, 5, 16, 19);
        HighElf PJ2 = new HighElf(null, "Aelar", 40, 8, 1, 14, 16, 18, 8);
        System.out.println("Datos de " + PJ1.getName() +" " + PJ1);
        System.out.println("Datos de " + PJ2.getName() +" " + PJ2);
        repository.save(PJ1);
        repository.save(PJ2);
        repository.save(stats);
        System.out.println("Heroes creados en base de datos: " + repository.findAll().size());

    }
}
