package com.example.proyect;
import com.example.proyect.entities.Character;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class ProyectApplicationTests {
    @Test
    public void testGettersAndSetters() {
        Character character = new Character();

        Long id = 1L;
        character.setId(id);
        assertEquals(id, character.getId());

        String name = "Alice";
        character.setName(name);
        assertEquals(name, character.getName());

        int age = 25;
        character.setAge(age);
        assertEquals(age, character.getAge());

        int strength = 10;
        character.setStrength(strength);
        assertEquals(strength, character.getStrength());

        int dexterity = 12;
        character.setDexterity(dexterity);
        assertEquals(dexterity, character.getDexterity());

        int constitution = 8;
        character.setConstitution(constitution);
        assertEquals(constitution, character.getConstitution());

        int intelligence = 15;
        character.setIntelligence(intelligence);
        assertEquals(intelligence, character.getIntelligence());

        int wisdom = 13;
        character.setWisdom(wisdom);
        assertEquals(wisdom, character.getWisdom());

        int charisma = 16;
        character.setCharisma(charisma);
        assertEquals(charisma, character.getCharisma());

        int speed = 30;
        character.setSpeed(speed);
        assertEquals(speed, character.getSpeed());
    }
}

