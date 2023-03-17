package com.example.proyect.entities.races.subraces;

import com.example.proyect.entities.races.Elf;
import jakarta.persistence.Entity;
import org.springframework.data.repository.cdi.Eager;

@Entity
public class HighElf extends Elf {
    public HighElf(Long id, String name, int age, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.intelligence ++;
        setClase("HighElf");

    }

    public HighElf() {
    }
    public HighElf(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El número debe ser positivo");
        }
        this.strength = numero;

    }
}
