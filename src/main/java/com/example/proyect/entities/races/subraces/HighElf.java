package com.example.proyect.entities.races.subraces;

import com.example.proyect.entities.races.Elf;

public class HighElf extends Elf {
    public HighElf(Long id, String name, int age, int level, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.intelligence ++;

    }

    public HighElf() {
    }
}
