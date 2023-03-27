package com.example.proyect.service;

import com.example.proyect.entities.Character;
import com.example.proyect.repository.ICharacterRepository;
import com.example.proyect.service.interfaces.ICharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.proyect.controller.CharacterController.log;

@Service
public class CharacterService implements ICharacterService {

    private ICharacterRepository characterRepository;

    public CharacterService(ICharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<Character> getAllCharacter() {
        return characterRepository.findAll();
    }

    @Override
    public Optional<Character> getCharacterByID(Long id) {
        return characterRepository.findById(id);
    }

    @Override
    public void deleteCharacterById(Long id) {
        characterRepository.deleteById(id);
    }

    @Override
    public Character saveCharacter(Character character) {
        if(character.getId() != null){
            log.warn("trying to create a character with id");
            System.out.println("trying to create a character with id");
            return (Character) ResponseEntity.badRequest();
        }
        return characterRepository.save(character);
    }


    public Character updateCharacter(Character character) {
        if (character.getId() == null) { // si no tiene id quiere decir que sí es una creación
            log.warn("Trying to update a non existent character");
            return (Character) ResponseEntity.badRequest();
        }
        if (!characterRepository.existsById(character.getId())) {
            log.warn("Trying to update a non existent character");
            return characterRepository.save(character);
        }
        return characterRepository.save(character);
}
}





