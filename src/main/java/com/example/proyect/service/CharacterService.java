package com.example.proyect.service;

import com.example.proyect.entities.Character;
import com.example.proyect.repository.ICharacterRepository;
import com.example.proyect.service.interfaces.ICharacterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Character save(Character character) {
        return null;
    }

}





