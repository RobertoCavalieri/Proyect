package com.example.proyect.entities.races;

import com.example.proyect.entities.Stats;
import jakarta.persistence.Entity;

@Entity
public class Dwarf extends Stats {
    public Dwarf(Long id, String name, int age, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.constitution = constitution +2;
    }
    public Dwarf() {

    }
}
