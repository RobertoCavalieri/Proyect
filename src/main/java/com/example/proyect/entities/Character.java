package com.example.proyect.entities;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "PJ")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty
    private Long id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private int strength;
    @Column
    private int dexterity;
    @Column
    private int constitution;
    @Column
    private int intelligence;
    @Column
    private int wisdom;
    @Column
    private int charisma;
    @Column
    private int speed;

}



