package com.example.proyect.entities;

import jakarta.persistence.*;

@Entity
public class CharacterCreator extends IdGenerator {

    private String name;
    private int age;
    private String clase;
    private int level;

    public CharacterCreator(Long id, String name, int age, int level) {
        super(id);
        this.name = name;
        this.age = age;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public CharacterCreator(Long id) {
        super(id);
    }

    public CharacterCreator() {
        super();
    }
}

