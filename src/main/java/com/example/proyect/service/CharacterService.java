package com.example.proyect.service;

import com.example.proyect.entities.Character;
import com.example.proyect.repository.ICharacterRepository;
import com.example.proyect.service.interfaces.ICharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.proyect.DTO.CharacterDTO;
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
        if (character.getId() != null) {
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

    public Object ElfCreator(Character elf, CharacterDTO elfDto) {
        elf.setRace(elfDto.getRace());
        elf.setName(elfDto.getName());
        elf.setAge(elfDto.getAge());
        elf.setStrength(elfDto.getStrength());
        elf.setDexterity(elfDto.getDexterity() + 2); // aumentar dexterity en 2
        elf.setConstitution(elfDto.getConstitution());
        elf.setIntelligence(elfDto.getIntelligence());
        elf.setWisdom(elfDto.getWisdom());
        elf.setCharisma(elfDto.getCharisma());
        elf.setSpeed(elfDto.getSpeed());
        // Puedes guardar el objeto creado en la base de datos o hacer cualquier otra operación que necesites
        // ...

        return null;
    }

    public Object HumanCreator(Character human, CharacterDTO humanDto) {
        human.setRace(humanDto.getRace());
        human.setName(humanDto.getName());
        human.setAge(humanDto.getAge());
        human.setStrength(humanDto.getStrength() + 1);
        human.setDexterity(humanDto.getDexterity() + 1); // aumentar dexterity en 2
        human.setConstitution(humanDto.getConstitution() + 1);
        human.setIntelligence(humanDto.getIntelligence() + 1);
        human.setWisdom(humanDto.getWisdom() + 1);
        human.setCharisma(humanDto.getCharisma() + 1);
        human.setSpeed(humanDto.getSpeed());
        // Puedes guardar el objeto creado en la base de datos o hacer cualquier otra operación que necesites
        // ...

        return null;
    }

    public Character createCharacter(CharacterDTO characterDto) {
        Character character = new Character();
        if (characterDto.getRace().equals("Elf")) {
          ElfCreator(character, characterDto);
        } else if (characterDto.getRace().equals("Human")) {
            HumanCreator(character, characterDto);
        }
        return characterRepository.save(character);
}
    }









