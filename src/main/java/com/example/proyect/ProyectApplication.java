package com.example.proyect;

import com.example.proyect.DTO.CharacterDTO;
import com.example.proyect.entities.Character;


import com.example.proyect.repository.ICharacterRepository;
import com.example.proyect.service.CharacterService;
import com.example.proyect.service.RandomCharacterGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ProyectApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ProyectApplication.class, args);
        ICharacterRepository CharacterRepository = context.getBean(ICharacterRepository.class);



        CharacterDTO characterDTO = new CharacterDTO();
        Character randomCharacter = RandomCharacterGenerator.generateRandomCharacter(characterDTO);

        CharacterService partyGenerator = new CharacterService(CharacterRepository);
        List<Character> party = (List<Character>) partyGenerator.generateARandomParty();





        CharacterRepository.save(randomCharacter);

        System.out.println("Heroes creados en base de datos: " + CharacterRepository.findAll().size());


    }

}
