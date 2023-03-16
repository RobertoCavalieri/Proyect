package com.example.proyect.entities.races.subraces;

import com.example.proyect.entities.races.Elf;
import jakarta.persistence.Entity;

@Entity
public class WoodElf extends Elf {
    public WoodElf(Long id, String name, int age, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.wisdom ++;
        this.speed = 35;
    }

    public WoodElf() {
    }
}
