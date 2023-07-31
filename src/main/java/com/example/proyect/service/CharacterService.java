package com.example.proyect.service;

import com.example.proyect.entities.Character;
import com.example.proyect.enums.Race;
import com.example.proyect.repository.ICharacterRepository;
import com.example.proyect.service.interfaces.ICharacterService;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.proyect.DTO.CharacterDTO;
import java.util.List;
import java.util.Optional;
import static com.example.proyect.controller.CharacterController.log;


@Service
public class CharacterService implements ICharacterService {

    private final ICharacterRepository characterRepository;

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
    public Character saveCharacter(@NotNull Character character) {
            log.warn("trying to create a character with id");
            System.out.println("trying to create a character with id");
            return (Character) ResponseEntity.badRequest();
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

    public void DragonBornCreator(Character dragonborn, @Valid CharacterDTO dragonbornDto) {
        dragonbornDto.setStrength(dragonbornDto.getStrength() + 2);
        dragonbornDto.setCharisma(dragonbornDto.getCharisma() + 1);
        BeanUtils.copyProperties(dragonbornDto, dragonborn);
        dragonborn.setSpeed(30);
    }

    public void DwarfCreator(Character dwarf, @Valid CharacterDTO dwarfDto) {
        dwarfDto.setConstitution(dwarfDto.getConstitution() + 2);
        BeanUtils.copyProperties(dwarfDto, dwarf);
        dwarf.setSpeed(25);
    }


    public void ElfCreator(Character elf, @Valid CharacterDTO elfDto) {
        elfDto.setDexterity(elfDto.getDexterity() + 2);
        BeanUtils.copyProperties(elfDto, elf);
        elf.setSpeed(30);
        // Puedes guardar el objeto creado en la base de datos o hacer cualquier otra operación que necesites
        // ...

    }

    public void GnomeCreator(Character gnome, @Valid CharacterDTO gnomeDto) {
        gnomeDto.setIntelligence(gnomeDto.getIntelligence() + 2);
        BeanUtils.copyProperties(gnomeDto, gnome);
        gnome.setSpeed(25);
    }

    public void HalfElfCreator(Character halfElf, @Valid CharacterDTO halfElfDto) {;
        halfElfDto.setCharisma(halfElfDto.getCharisma() + 2);
        BeanUtils.copyProperties(halfElfDto, halfElf);
        halfElf.setSpeed(30);
    }

    public void HalflingCreator(Character halfling, @Valid CharacterDTO halflingDto) {
        halflingDto.setDexterity(halflingDto.getDexterity()+2);
        BeanUtils.copyProperties(halflingDto, halfling);
        halfling.setSpeed(25);
    }

    public void HalfOrcCreator(Character halfOrc, @Valid CharacterDTO halfOrcDto) {
        halfOrcDto.setStrength(halfOrcDto.getStrength() + 2);
        halfOrcDto.setConstitution(halfOrcDto.getConstitution() +1);
        BeanUtils.copyProperties(halfOrcDto, halfOrc);
        halfOrc.setSpeed(30);
    }

    public void HumanCreator(Character human, CharacterDTO humanDto) {
        BeanUtils.copyProperties(humanDto, human);
        human.setStrength(humanDto.getStrength() + 1);
        human.setDexterity(humanDto.getDexterity() + 1);
        human.setConstitution(humanDto.getConstitution() + 1);
        human.setIntelligence(humanDto.getIntelligence() + 1);
        human.setWisdom(humanDto.getWisdom() + 1);
        human.setCharisma(humanDto.getCharisma() + 1);
        human.setSpeed(30);
    }

    public void TieflingCreator(Character tiefling, @Valid CharacterDTO tieflingDto) {
        tieflingDto.setDexterity(tieflingDto.getDexterity() + 2);
        BeanUtils.copyProperties(tieflingDto, tiefling);
        tiefling.setSpeed(30);
    }

    public void createCharacter(CharacterDTO characterDto) {
        Character character = new Character();
        switch (Race.valueOf(characterDto.getRace().toUpperCase())) {
            case DRAGONBORN -> DragonBornCreator(character, characterDto);
            case DWARF -> DwarfCreator(character, characterDto);
            case ELF -> ElfCreator(character, characterDto);
            case GNOME-> GnomeCreator(character, characterDto);
            case HALFELF -> HalfElfCreator(character, characterDto);
            case HALFORC-> HalfOrcCreator(character, characterDto);
            case HALFLING -> HalflingCreator(character, characterDto);
            case HUMAN -> HumanCreator(character, characterDto);
            case TIEFLING -> TieflingCreator(character, characterDto);
        }
        characterRepository.save(character);
    }

 public void characterRandom(){
        CharacterDTO characterDTO = new CharacterDTO();
        Character randomCharacter = RandomCharacterGenerator.generateRandomCharacter(characterDTO);
     characterRepository.save(randomCharacter);

 }

    public Object generateARandomParty() {
       int numCharacters = 5;
        CharacterDTO characterDTO = new CharacterDTO();
        for (int i = 0; i < numCharacters; i++) {
            Character randomCharacter =RandomCharacterGenerator.generateRandomCharacter(characterDTO);
            characterRepository.save(randomCharacter);
        }
        return null;
    }
}










