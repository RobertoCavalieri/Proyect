package com.example.proyect.entities.races.subraces;

import com.example.proyect.entities.races.Elf;
import jakarta.persistence.Entity;

@Entity
public class DarkElf extends Elf {
    public DarkElf(Long id, String name, int age, int level, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.charisma++;
    }

    public DarkElf() {
    }

}