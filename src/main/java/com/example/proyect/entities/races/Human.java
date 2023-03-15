package com.example.proyect.entities.races;
import com.example.proyect.entities.Stats;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Human extends Stats {

    public Human(Long id, String name, int age, int level, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(id, name, age, level, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.strength++;
        this.wisdom ++;
        this.intelligence ++;
        this. charisma ++;
        this.constitution ++;
        this.dexterity ++;
        this.speed = 30;
    }
    public Human() {

    }
}


