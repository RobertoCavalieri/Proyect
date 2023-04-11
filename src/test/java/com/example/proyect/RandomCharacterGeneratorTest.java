/*
package com.example.proyect;

import com.example.proyect.entities.Character;
import com.example.proyect.enums.Race;
import com.example.proyect.repository.ICharacterRepository;
import com.example.proyect.service.CharacterService;
import com.example.proyect.service.RandomCharacterGenerator;
import com.example.proyect.service.interfaces.ICharacterService;
import com.example.proyect.DTO.CharacterDTO;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class CharacterTest {

    @Test
    public void testGettersAndSetters() {
        Character character = new Character();

        character.setId(1L);
        assertEquals(1L, character.getId().longValue());

        character.setRace("Elf");
        assertEquals("Elf", character.getRace());

        character.setName("Legolas");
        assertEquals("Legolas", character.getName());

        character.setAge(2931);
        assertEquals(2931, character.getAge());

        character.setStrength(18);
        assertEquals(18, character.getStrength());

        character.setDexterity(20);
        assertEquals(20, character.getDexterity());

        character.setConstitution(16);
        assertEquals(16, character.getConstitution());

        character.setIntelligence(14);
        assertEquals(14, character.getIntelligence());

        character.setWisdom(12);
        assertEquals(12, character.getWisdom());

        character.setCharisma(16);
        assertEquals(16, character.getCharisma());

        character.setSpeed(30);
        assertEquals(30, character.getSpeed());
    }

    @Test
    public void testConstructor() {
        Character character = new Character(2L, "Dwarf", "Gimli", 139, 20, 14, 18, 10, 8, 12, 25);

        assertEquals(2L, character.getId().longValue());
        assertEquals("Dwarf", character.getRace());
        assertEquals("Gimli", character.getName());
        assertEquals(139, character.getAge());
        assertEquals(20, character.getStrength());
        assertEquals(14, character.getDexterity());
        assertEquals(18, character.getConstitution());
        assertEquals(10, character.getIntelligence());
        assertEquals(8, character.getWisdom());
        assertEquals(12, character.getCharisma());
        assertEquals(25, character.getSpeed());
    }


        private ICharacterRepository characterRepository;
        private ICharacterService characterService;

        @BeforeEach
        void setUp() {
            characterRepository = Mockito.mock(ICharacterRepository.class);
            characterService = new CharacterService(characterRepository);
        }

        @Test
        @DisplayName("Test getAllCharacter")
        void getAllCharacterTest() {
            List<Character> expectedCharacters = List.of(
                    new Character(1L, "Elf", "Legolas", 100, 18, 20, 10, 14, 16, 12, 20),
                    new Character(2L, "Human", "Aragorn", 120, 20, 16, 18, 12, 14, 30, 30)
            );
            when(characterRepository.findAll()).thenReturn(expectedCharacters);

            List<Character> actualCharacters = characterService.getAllCharacter();

            Assertions.assertEquals(expectedCharacters, actualCharacters);
        }

        @Test
        @DisplayName("Test getCharacterByID")
        void getCharacterByIDTest() {
            Character expectedCharacter = new Character(1L, "Elf", "Legolas", 100, 18, 20, 10, 14, 16, 30, 30);
            when(characterRepository.findById(1L)).thenReturn(Optional.of(expectedCharacter));

            Optional<Character> actualCharacter = characterService.getCharacterByID(1L);

            Assertions.assertEquals(Optional.of(expectedCharacter), actualCharacter);
        }

        @Test
        @DisplayName("Test deleteCharacterById")
        void deleteCharacterByIdTest() {
            characterService.deleteCharacterById(1L);

            verify(characterRepository, times(1)).deleteById(anyLong());
        }

        @Test
        @DisplayName("Test saveCharacter with new Character")
        void saveCharacterNewTest() {
            Character expectedCharacter = new Character(null, "Human", "Boromir", 40, 18, 14, 16, 10, 12, 30, 30);
            when(characterRepository.save(expectedCharacter)).thenReturn(expectedCharacter);

            Character actualCharacter = characterService.saveCharacter(expectedCharacter);

            Assertions.assertEquals(expectedCharacter, actualCharacter);
        }

            @Test
            public void testGenerateRandomCharacter() {
                CharacterDTO characterDTO = new CharacterDTO();
                Character randomCharacter = RandomCharacterGenerator.generateRandomCharacter(characterDTO);

                // Verificar que el personaje generado no sea null
                assertNotNull(randomCharacter);

                // Verificar que el nombre del personaje no sea null o vacío
                assertNotNull(randomCharacter.getName());
                assertFalse(randomCharacter.getName().isEmpty());

                // Verificar que los atributos del personaje estén en el rango adecuado
                assertTrue(randomCharacter.getStrength() >= 6);
                assertTrue(randomCharacter.getStrength() <= 16);
                assertTrue(randomCharacter.getDexterity() >= 6);
                assertTrue(randomCharacter.getDexterity() <= 16);
                assertTrue(randomCharacter.getIntelligence() >= 6);
                assertTrue(randomCharacter.getIntelligence() <= 16);
            }
    @Test
    public void testGettersAndSettersCharacterDTO() {
        CharacterDTO characterDTO = new CharacterDTO();

        characterDTO.setRace(Race.ELF);
        assertEquals("ELF", characterDTO.getRace());

        characterDTO.setName("Legolas");
        assertEquals("Legolas", characterDTO.getName());

        characterDTO.setAge(2931);
        assertEquals(2931, characterDTO.getAge());

        characterDTO.setStrength(18);
        assertEquals(18, characterDTO.getStrength());

        characterDTO.setDexterity(20);
        assertEquals(20, characterDTO.getDexterity());

        characterDTO.setConstitution(16);
        assertEquals(16, characterDTO.getConstitution());

        characterDTO.setIntelligence(14);
        assertEquals(14, characterDTO.getIntelligence());

        characterDTO.setWisdom(12);
        assertEquals(12, characterDTO.getWisdom());

        characterDTO.setCharisma(16);
        assertEquals(16, characterDTO.getCharisma());

        characterDTO.setSpeed(30);
        assertEquals(30, characterDTO.getSpeed());
    }

    @Test
    public void testBuilder() {
        CharacterDTO characterDTO = CharacterDTO.builder()
                .race(Race.DWARF)
                .name("Gimli")
                .age(139)
                .strength(20)
                .dexterity(14)
                .constitution(18)
                .intelligence(10)
                .wisdom(8)
                .charisma(12)
                .speed(25)
                .build();

        assertEquals("DWARF", characterDTO.getRace());
        assertEquals("Gimli", characterDTO.getName());
        assertEquals(139, characterDTO.getAge());
        assertEquals(20, characterDTO.getStrength());
        assertEquals(14, characterDTO.getDexterity());
        assertEquals(18, characterDTO.getConstitution());
        assertEquals(10, characterDTO.getIntelligence());
        assertEquals(8, characterDTO.getWisdom());
        assertEquals(12, characterDTO.getCharisma());
        assertEquals(25, characterDTO.getSpeed());
    }

    @Test
    public void testInvalidAge() {
        try {
            CharacterDTO characterDTO = new CharacterDTO();
            characterDTO.setAge(5);
            fail("No debería haber llegado aquí");
        } catch (IllegalArgumentException e) {
            assertEquals("Las edad no puede ser menor a 10", e.getMessage());
        }
    }

    @Test
    public void testInvalidStat() {
        try {
            CharacterDTO characterDTO = new CharacterDTO();
            characterDTO.setStrength(0);
            fail("No debería haber llegado aquí");
        } catch (IllegalArgumentException e) {
            assertEquals("Las estadística de fuerza no puede ser menor a 1", e.getMessage());
        }
    }

    @Test
    public void testInvalidName() {
        try {
            CharacterDTO characterDTO = new CharacterDTO();
            characterDTO.setName("");
            fail("No debería haber llegado aquí");
        } catch (IllegalArgumentException e) {
            assertEquals("Debe contener un nombre", e.getMessage());
        }
    }
}


*/
