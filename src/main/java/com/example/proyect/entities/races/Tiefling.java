package com.example.proyect.entities.races;

import com.example.proyect.entities.Stats;
import jakarta.persistence.Entity;

@Entity
public class Tiefling extends Stats {
    public Tiefling() {
        this.intelligence ++;
        this.charisma +=2;
    }

    public Tiefling(Long id, String name, int age, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.intelligence ++;
        this.charisma +=2;
        setClase("Tiefling");
    }
}
