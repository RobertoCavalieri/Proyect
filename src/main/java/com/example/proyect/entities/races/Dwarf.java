package com.example.proyect.entities.races;

import com.example.proyect.entities.Stats;
import jakarta.persistence.Entity;

@Entity
public class Dwarf extends Stats {
    public Dwarf(Long id, String name, int age, int level, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(id, name, age, level, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.constitution = constitution +2;
    }
    public Dwarf() {

    }
}
