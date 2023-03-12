package com.example.proyect.entities;

import jakarta.persistence.*;
import io.swagger.annotations.ApiModelProperty;
@Entity
@Table(name = "PJ")

public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty
    private Long id;
    private String name;
    private int age;
    private String clase;
    private int level;
    private int stats;

    public Character(Long id, String name, int age, int level, int stats) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.level = level;
        this.stats = stats;
    }

    public Character() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        this.clase = "Brujo";
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStats() {
        return stats;
    }

    public void setStats(int stats) {
        this.stats = stats;
    }
}
