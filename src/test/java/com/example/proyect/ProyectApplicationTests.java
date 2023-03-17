package com.example.proyect;

import com.example.proyect.entities.Stats;
import com.example.proyect.entities.races.*;
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
        String clase = "Human";
        String name = "John Doe";
        int age = 25;
        int strength = 10;
        int dexterity = 10;
        int constitution = 10;
        int intelligence =10;
        int wisdom = 10;
        int charisma = 10;
        int speed = 0;

        Stats stats = new Stats(id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);


        String expectedString = "Race: " + null + ", name = " + name + ", age = " + age+
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", charisma=" + charisma +
                ", speed=" + speed +
                " ";

        String actualString = stats.toString();

        assertEquals(expectedString, actualString);
    }
    @Test
    public void testHalfOrcConstructor() {
        Long id = 1L;
        String name = "Thorin";
        int age = 75;
        int strength = 8;
        int dexterity = 10;
        int constitution = 12;
        int intelligence = 6;
        int wisdom = 10;
        int charisma = 6;

        HalfOrc halfOrc = new HalfOrc(id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);

        assertEquals(id, halfOrc.getId());
        assertEquals(name, halfOrc.getName());
        assertEquals(age, halfOrc.getAge());
        assertEquals(strength +2, halfOrc.getStrength());
        assertEquals(dexterity, halfOrc.getDexterity());
        assertEquals(constitution +1, halfOrc.getConstitution());
        assertEquals(intelligence, halfOrc.getIntelligence());
        assertEquals(wisdom, halfOrc.getWisdom());
        assertEquals(charisma, halfOrc.getCharisma());
    }

    @Test
    public void testDefaultHalfOrcConstructor() {
        HalfOrc halfOrc = new HalfOrc();

        assertNull(halfOrc.getId());
        assertNull(halfOrc.getName());
        assertEquals(0, halfOrc.getAge());
        assertEquals(2, halfOrc.getStrength());
        assertEquals(0, halfOrc.getDexterity());
        assertEquals(1, halfOrc.getConstitution());
        assertEquals(0, halfOrc.getIntelligence());
        assertEquals(0, halfOrc.getWisdom());
        assertEquals(0, halfOrc.getCharisma());
    }
    @Test
    public void testHalflingConstructor() {
        Long id = 1L;
        String name = "Thorin";
        int age = 75;
        int strength = 8;
        int dexterity = 10;
        int constitution = 12;
        int intelligence = 6;
        int wisdom = 10;
        int charisma = 6;

        Halfling halfling = new Halfling(id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);

        assertEquals(id, halfling.getId());
        assertEquals(name, halfling.getName());
        assertEquals(age, halfling.getAge());
        assertEquals(strength , halfling.getStrength());
        assertEquals(dexterity +2, halfling.getDexterity());
        assertEquals(constitution, halfling.getConstitution());
        assertEquals(intelligence, halfling.getIntelligence());
        assertEquals(wisdom, halfling.getWisdom());
        assertEquals(charisma, halfling.getCharisma());
    }

    @Test
    public void testDefaulthalflingConstructor() {
        Halfling halfling = new Halfling();

        assertNull(halfling.getId());
        assertNull(halfling.getName());
        assertEquals(0, halfling.getAge());
        assertEquals(0, halfling.getStrength());
        assertEquals(2, halfling.getDexterity());
        assertEquals(0, halfling.getConstitution());
        assertEquals(0, halfling.getIntelligence());
        assertEquals(0, halfling.getWisdom());
        assertEquals(0, halfling.getCharisma());
    }
    @Test
    public void testGnomeConstructor() {
        Long id = 1L;
        String name = "Thorin";
        int age = 75;
        int strength = 8;
        int dexterity = 10;
        int constitution = 12;
        int intelligence = 6;
        int wisdom = 10;
        int charisma = 6;

        Gnome gnome = new Gnome (id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);

        assertEquals(id, gnome.getId());
        assertEquals(name, gnome.getName());
        assertEquals(age, gnome.getAge());
        assertEquals(strength , gnome.getStrength());
        assertEquals(dexterity, gnome.getDexterity());
        assertEquals(constitution, gnome.getConstitution());
        assertEquals(intelligence +2, gnome.getIntelligence());
        assertEquals(wisdom, gnome.getWisdom());
        assertEquals(charisma, gnome.getCharisma());
    }

    @Test
    public void testDefaultGnomeConstructor() {
        Gnome gnome = new Gnome();

        assertNull(gnome.getId());
        assertNull(gnome.getName());
        assertEquals(0, gnome.getAge());
        assertEquals(0, gnome.getStrength());
        assertEquals(0, gnome.getDexterity());
        assertEquals(0, gnome.getConstitution());
        assertEquals(2, gnome.getIntelligence());
        assertEquals(0, gnome.getWisdom());
        assertEquals(0, gnome.getCharisma());
    }
    @Test
    public void testTieflingConstructor() {
        Long id = 1L;
        String name = "Thorin";
        int age = 75;
        int strength = 8;
        int dexterity = 10;
        int constitution = 12;
        int intelligence = 6;
        int wisdom = 10;
        int charisma = 6;

        Tiefling tiefling = new Tiefling (id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);

        assertEquals(id, tiefling.getId());
        assertEquals(name, tiefling.getName());
        assertEquals(age, tiefling.getAge());
        assertEquals(strength , tiefling.getStrength());
        assertEquals(dexterity, tiefling.getDexterity());
        assertEquals(constitution, tiefling.getConstitution());
        assertEquals(intelligence +1, tiefling.getIntelligence());
        assertEquals(wisdom, tiefling.getWisdom());
        assertEquals(charisma +2, tiefling.getCharisma());
    }

    @Test
    public void testDefaultTieflingConstructor() {
        Tiefling tiefling = new Tiefling();

        assertNull(tiefling.getId());
        assertNull(tiefling.getName());
        assertEquals(0, tiefling.getAge());
        assertEquals(0, tiefling.getStrength());
        assertEquals(0, tiefling.getDexterity());
        assertEquals(0, tiefling.getConstitution());
        assertEquals(1, tiefling.getIntelligence());
        assertEquals(0, tiefling.getWisdom());
        assertEquals(2, tiefling.getCharisma());
    }
}
