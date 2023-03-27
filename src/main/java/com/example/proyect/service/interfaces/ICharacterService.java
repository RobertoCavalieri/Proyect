package com.example.proyect.service.interfaces;

import com.example.proyect.entities.Character;

import java.util.List;
import java.util.Optional;

public interface ICharacterService {
    List<Character> getAllCharacter();

    Optional<Character> getCharacterByID(Long id);
    void deleteCharacterById(Long id);
    Character save (Character character);
}
