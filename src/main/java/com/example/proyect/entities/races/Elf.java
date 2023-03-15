package com.example.proyect.entities.races;

import com.example.proyect.entities.Stats;
import jakarta.persistence.Entity;

@Entity
public class Elf extends Stats {
    public Elf(Long id, String name, int age, int level, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(id, name, age, level, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.strength = strength;
        this.dexterity = dexterity +2;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.speed = 30;
    }

    public Elf() {

    }
}
