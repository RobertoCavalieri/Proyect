package com.example.proyect;

import com.example.proyect.entities.races.Dwarf;
import com.example.proyect.entities.races.Human;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class ProyectApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    public void testDwarfConstructor() {
        Long id = 1L;
        String name = "Thorin";
        int age = 75;
        int strength = 8;
        int dexterity = 10;
        int constitution = 12;
        int intelligence = 6;
        int wisdom = 10;
        int charisma = 6;

        Dwarf dwarf = new Dwarf(id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);

        assertEquals(id, dwarf.getId());
        assertEquals(name, dwarf.getName());
        assertEquals(age, dwarf.getAge());
        assertEquals(strength, dwarf.getStrength());
        assertEquals(dexterity, dwarf.getDexterity());
        assertEquals(constitution + 2, dwarf.getConstitution());
        assertEquals(intelligence, dwarf.getIntelligence());
        assertEquals(wisdom, dwarf.getWisdom());
        assertEquals(charisma, dwarf.getCharisma());
    }

    @Test
    public void testDefaultDwarfConstructor() {
        Dwarf dwarf = new Dwarf();

        assertNull(dwarf.getId());
        assertNull(dwarf.getName());
        assertEquals(0, dwarf.getAge());
        assertEquals(0, dwarf.getStrength());
        assertEquals(0, dwarf.getDexterity());
        assertEquals(2, dwarf.getConstitution());
        assertEquals(0, dwarf.getIntelligence());
        assertEquals(0, dwarf.getWisdom());
        assertEquals(0, dwarf.getCharisma());
    }

    @Test
    public void testDefaultHumanConstructor() {
        Human human = new Human();

        assertNull(human.getId());
        assertNull(human.getName());
        assertEquals(0, human.getAge());
        assertEquals(1, human.getStrength());
        assertEquals(1, human.getDexterity());
        assertEquals(1, human.getConstitution());
        assertEquals(1, human.getIntelligence());
        assertEquals(1, human.getWisdom());
        assertEquals(1, human.getCharisma());
    }
    @Test
    public void testHumanConstructor() {
        Long id = 1L;
        String name = "Josecito Lopez";
        int age = 75;
        int level = 10;
        int strength = 8;
        int dexterity = 10;
        int constitution = 12;
        int intelligence = 6;
        int wisdom = 10;
        int charisma = 6;
        Human human = new Human(id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);

        assertEquals(id, human.getId());
        assertEquals(name, human.getName());
        assertEquals(age, human.getAge());
        assertEquals(strength + 1, human.getStrength());
        assertEquals(dexterity + 1, human.getDexterity());
        assertEquals(constitution + 1, human.getConstitution());
        assertEquals(intelligence + 1, human.getIntelligence());
        assertEquals(wisdom + 1, human.getWisdom());
        assertEquals(charisma + 1, human.getCharisma());
    }

    @Test
    public void testToString() {
        Long id = 1L;
        String name = "John Doe";
        int age = 25;
        int strength = 10;
        int dexterity = 10;
        int constitution = 10;
        int intelligence =10;
        int wisdom = 10;
        int charisma = 10;
        int speed = 30;

        Human human = new Human(id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);


        String expectedString = "Human id =" + id + ", name =" + name + ", age =" + age +
                "strength=" + 11 +
                ", dexterity=" + 11 +
                ", constitution=" + 11 +
                ", intelligence=" + 11 +
                ", wisdom=" + 11 +
                ", charisma=" + 11 +
                ", speed=" + speed +
                " ";

        String actualString = human.toString();

        assertEquals(expectedString, actualString);
    }
}
