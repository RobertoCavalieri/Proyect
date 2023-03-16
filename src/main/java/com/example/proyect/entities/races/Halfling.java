package com.example.proyect.entities.races;

import com.example.proyect.entities.Stats;
import jakarta.persistence.Entity;

@Entity
public class Halfling extends Stats {


    public Halfling(Long id, String name, int age, int level, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(id, name, age, level, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.dexterity += 2;
    }
    public Halfling() {
    }
}
