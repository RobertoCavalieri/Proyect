package com.example.proyect.service;

import com.example.proyect.entities.Character;
import com.example.proyect.repository.ICharacterRepository;
import com.example.proyect.service.interfaces.ICharacterService;
import jakarta.validation.Valid;
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

    public void DragonBornCreator(Character dragonborn, @Valid CharacterDTO dragonbornDto) {
        dragonborn.setRace(dragonbornDto.getRace());
        dragonborn.setName(dragonbornDto.getName());
        dragonborn.setAge(dragonbornDto.getAge());
        dragonborn.setStrength(dragonbornDto.getStrength() + 2);
        dragonborn.setDexterity(dragonbornDto.getDexterity());
        dragonborn.setConstitution(dragonbornDto.getConstitution());
        dragonborn.setIntelligence(dragonbornDto.getIntelligence());
        dragonborn.setWisdom(dragonbornDto.getWisdom());
        dragonborn.setCharisma(dragonbornDto.getCharisma() + 1);
        dragonborn.setSpeed(30);
    }

    public void DwarfCreator(Character dwarf, @Valid CharacterDTO dwarfDto) {
        dwarf.setRace(dwarfDto.getRace());
        dwarf.setName(dwarfDto.getName());
        dwarf.setAge(dwarfDto.getAge());
        dwarf.setStrength(dwarfDto.getStrength());
        dwarf.setDexterity(dwarfDto.getDexterity());
        dwarf.setConstitution(dwarfDto.getConstitution() + 2);
        dwarf.setIntelligence(dwarfDto.getIntelligence());
        dwarf.setWisdom(dwarfDto.getWisdom());
        dwarf.setCharisma(dwarfDto.getCharisma());
        dwarf.setSpeed(25);
    }


    public void ElfCreator(Character elf, @Valid CharacterDTO elfDto) {
        elf.setRace(elfDto.getRace());
        elf.setName(elfDto.getName());
        elf.setAge(elfDto.getAge());
        elf.setStrength(elfDto.getStrength());
        elf.setDexterity(elfDto.getDexterity() + 2); // aumentar dexterity en 2
        elf.setConstitution(elfDto.getConstitution());
        elf.setIntelligence(elfDto.getIntelligence());
        elf.setWisdom(elfDto.getWisdom());
        elf.setCharisma(elfDto.getCharisma());
        elf.setSpeed(30);
        // Puedes guardar el objeto creado en la base de datos o hacer cualquier otra operación que necesites
        // ...

    }

    public void GnomeCreator(Character gnome, @Valid CharacterDTO gnomeDto) {
        gnome.setRace(gnomeDto.getRace());
        gnome.setName(gnomeDto.getName());
        gnome.setAge(gnomeDto.getAge());
        gnome.setStrength(gnomeDto.getStrength());
        gnome.setDexterity(gnomeDto.getDexterity());
        gnome.setConstitution(gnomeDto.getConstitution());
        gnome.setIntelligence(gnomeDto.getIntelligence() + 2);
        gnome.setWisdom(gnomeDto.getWisdom());
        gnome.setCharisma(gnomeDto.getCharisma());
        gnome.setSpeed(25);
    }

    public void HalfElfCreator(Character halfElf, @Valid CharacterDTO halfElfDto) {
        halfElf.setRace(halfElfDto.getRace());//+1 a una estadistica aleatoria
        halfElf.setName(halfElfDto.getName());
        halfElf.setAge(halfElfDto.getAge());
        halfElf.setStrength(halfElfDto.getStrength());
        halfElf.setDexterity(halfElfDto.getDexterity());
        halfElf.setConstitution(halfElfDto.getConstitution());
        halfElf.setIntelligence(halfElfDto.getIntelligence());
        halfElf.setWisdom(halfElfDto.getWisdom());
        halfElf.setCharisma(halfElfDto.getCharisma() + 2);
        halfElf.setSpeed(30);
    }

    public void HalflingCreator(Character halfling, @Valid CharacterDTO halflingDto) {
        halfling.setRace(halflingDto.getRace());
        halfling.setName(halflingDto.getName());
        halfling.setAge(halflingDto.getAge());
        halfling.setStrength(halflingDto.getStrength());
        halfling.setDexterity(halflingDto.getDexterity() + 2);
        halfling.setConstitution(halflingDto.getConstitution());
        halfling.setIntelligence(halflingDto.getIntelligence());
        halfling.setWisdom(halflingDto.getWisdom());
        halfling.setCharisma(halflingDto.getCharisma());
        halfling.setSpeed(25);
    }

    public void HalfOrcCreator(Character halfOrc, @Valid CharacterDTO halfOrcDto) {
        halfOrc.setRace(halfOrcDto.getRace());
        halfOrc.setName(halfOrcDto.getName());
        halfOrc.setAge(halfOrcDto.getAge());
        halfOrc.setStrength(halfOrcDto.getStrength() + 2);
        halfOrc.setDexterity(halfOrcDto.getDexterity());
        halfOrc.setConstitution(halfOrcDto.getConstitution() + 1);
        halfOrc.setIntelligence(halfOrcDto.getIntelligence());
        halfOrc.setWisdom(halfOrcDto.getWisdom());
        halfOrc.setCharisma(halfOrcDto.getCharisma());
        halfOrc.setSpeed(30);
    }

    public void HumanCreator(Character human, CharacterDTO humanDto) {
        human.setRace(humanDto.getRace());
        human.setName(humanDto.getName());
        human.setAge(humanDto.getAge());
        human.setStrength(humanDto.getStrength() + 1);
        human.setDexterity(humanDto.getDexterity() + 1);
        human.setConstitution(humanDto.getConstitution() + 1);
        human.setIntelligence(humanDto.getIntelligence() + 1);
        human.setWisdom(humanDto.getWisdom() + 1);
        human.setCharisma(humanDto.getCharisma() + 1);
        human.setSpeed(30);
        // Puedes guardar el objeto creado en la base de datos o hacer cualquier otra operación que necesites
        // ...

    }

    public void TieflingCreator(Character tiefling, @Valid CharacterDTO tieflingDto) {
        tiefling.setRace(tieflingDto.getRace());
        tiefling.setName(tieflingDto.getName());
        tiefling.setAge(tieflingDto.getAge());
        tiefling.setStrength(tieflingDto.getStrength());
        tiefling.setDexterity(tieflingDto.getDexterity() + 2);
        tiefling.setConstitution(tieflingDto.getConstitution());
        tiefling.setIntelligence(tieflingDto.getIntelligence());
        tiefling.setWisdom(tieflingDto.getWisdom());
        tiefling.setCharisma(tieflingDto.getCharisma());
        tiefling.setSpeed(30);
    }

    public void createCharacter(CharacterDTO characterDto) {
        Character character = new Character();
        switch (characterDto.getRace()) {
            case "DRAGONBORN" -> DragonBornCreator(character, characterDto);
            case "DWARF" -> DwarfCreator(character, characterDto);
            case "ELF" -> ElfCreator(character, characterDto);
            case "GNOME"-> GnomeCreator(character, characterDto);
            case "HALFELF" -> HalfElfCreator(character, characterDto);
            case "HALFORC"-> HalfOrcCreator(character, characterDto);
            case "HALFLING" -> HalflingCreator(character, characterDto);
            case "HUMAN" -> HumanCreator(character, characterDto);
            case "TIEFLING" -> TieflingCreator(character, characterDto);
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










