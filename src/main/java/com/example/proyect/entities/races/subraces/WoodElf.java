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
    @Override
    public String toString() {
        return "Race: Wood Elf" + ", name = " + getName() + ", age = " + getAge() +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", charisma=" + charisma +
                ", speed=" + speed +
                " ";
    }
    public WoodElf() {
    }
}
