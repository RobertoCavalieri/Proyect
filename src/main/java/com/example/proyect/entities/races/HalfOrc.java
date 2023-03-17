package com.example.proyect.entities.races;

import com.example.proyect.entities.Stats;
import jakarta.persistence.Entity;

@Entity
public class HalfOrc extends Stats {
    public HalfOrc(Long id, String name, int age, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.strength = strength +2;
        this.constitution ++;
        setClase("Half Orc");
    }


    public HalfOrc() {
        this.strength = strength +2;
        this.constitution ++;
    }
}
