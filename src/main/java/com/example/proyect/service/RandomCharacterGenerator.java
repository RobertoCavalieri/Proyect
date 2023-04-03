package com.example.proyect.service;

import com.example.proyect.entities.Character;
import com.example.proyect.DTO.CharacterDTO;
import com.example.proyect.repository.ICharacterRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RandomCharacterGenerator {

    private static final Random random = new Random();

    public static Character generateRandomCharacter(CharacterDTO characterDTO) {
        Character character = new Character();

        character.setRace(generateRandomRace());
        character.setName(generateRandomName());
        character.setAge(generateRandomAge());
        character.setStrength(generateRandomStat(characterDTO.getStrength()));
        character.setDexterity(generateRandomStat(characterDTO.getDexterity()));
        character.setConstitution(generateRandomStat(characterDTO.getConstitution()));
        character.setIntelligence(generateRandomStat(characterDTO.getIntelligence()));
        character.setWisdom(generateRandomStat(characterDTO.getWisdom()));
        character.setCharisma(generateRandomStat(characterDTO.getCharisma()));
        character.setSpeed(speedAsignator());

        return character;
    }

    private static String generateRandomRace() {
        List<String> races = Arrays.asList("Dragonborn", "Dwarf", "Elf", "Gnome", "HalfElf", "HalfOrc", "Halfling", "Human", "Tiefling");
        int randomIndex = random.nextInt(races.size());
        return races.get(randomIndex);
    }

    private static String generateRandomName() {
        List<String> names = Arrays.asList("Malvus", "Trystrame", "Frandomi", "Malkon", "Junbledor", "Armagrog", "Kanakato", "Ricardo", "Estunislao", "Santino", "Lopez", "Laucian");
        int randomIndex = random.nextInt(names.size());
        return names.get(randomIndex);
    }


    private static int generateRandomAge() {
        // Se puede ajustar los valores mínimo y máximo de la edad para que se adapten al rango deseado
        int minAge = 18;
        int maxAge = 90;
        return random.nextInt(maxAge - minAge + 1) + minAge;
    }

    private static int generateRandomStat(int baseStat) {
        // Aquí se puede ajustar el rango de valores aleatorios para que se adapten al rango deseado
        int minStat = 6;
        int maxStat = 16;
        return baseStat + random.nextInt(maxStat - minStat + 1) + minStat;
    }

    private static int speedAsignator() {
        int speed = 30;
        if (Objects.equals(generateRandomRace(), "Halfling") || Objects.equals(generateRandomRace(), "Gnome") || Objects.equals(generateRandomRace(), "Dwarf")) {
            speed = 25;
        }
        return speed;
    }

    /*public Object generateRandomParty() {
        int numCharacters = 5;
        CharacterDTO characterDTO = new CharacterDTO();
        for (int i = 0; i < numCharacters; i++) {
            Character randomCharacter = (Character) RandomCharacterGenerator.generateRandomCharacter(characterDTO);
            characterRepository.save(randomCharacter);
        }
        return null;
    }*/
}

