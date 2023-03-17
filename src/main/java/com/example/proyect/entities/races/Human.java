package com.example.proyect.entities.races;
import com.example.proyect.entities.Stats;
import jakarta.persistence.Entity;

@Entity
public class Human extends Stats {


    public Human(Long id, String name, int age, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(id, name, age, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.strength++;
        this.wisdom ++;
        this.intelligence ++;
        this. charisma ++;
        this.constitution ++;
        this.dexterity ++;
        this.speed += 30;
        setClase("Human");
    }


    public Human() {
        this.strength++;
        this.wisdom ++;
        this.intelligence ++;
        this. charisma ++;
        this.constitution ++;
        this.dexterity ++;
        this.speed += 30;
        setClase("Human");
    }
    }


