package com.example.proyect.entities;

import jakarta.persistence.*;
import io.swagger.annotations.ApiModelProperty;
@Entity
@Table(name = "PJ")


public class CharacterCreator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty
    private Long id;
    private String name;
    private int age;
    private String clase;
    private int level;
    @OneToOne
    @JoinColumn(name = "stats_id", referencedColumnName = "id")
    private Stats stats;

    public CharacterCreator(Long id, String name, int age, int level, Stats stats) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.level = level;
    }

    public CharacterCreator() {

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


    }

