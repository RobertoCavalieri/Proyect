package com.example.proyect.entities.races;

import com.example.proyect.entities.CharacterCreator;
import com.example.proyect.entities.Stats;
import jakarta.persistence.Entity;

@Entity
public class Dragonborn extends Stats {
    public Dragonborn() {
    }

    public Dragonborn(Long id, String name, int age, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.strength+=2;
        this.charisma++;
    }
}
