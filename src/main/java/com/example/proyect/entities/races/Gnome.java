package com.example.proyect.entities.races;

import com.example.proyect.entities.Stats;

public class Gnome extends Stats {
    public Gnome() {
    }

    public Gnome(Long id, String name, int age, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.intelligence +=2;
    }
}
