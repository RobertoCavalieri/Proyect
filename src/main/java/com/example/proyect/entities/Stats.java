package com.example.proyect.entities;


import jakarta.persistence.Entity;

@Entity
public class Stats extends CharacterCreator {

    protected int strength;
    protected int dexterity;
    protected int constitution;
    protected int intelligence;
    protected int wisdom;
    protected int charisma;
    protected int speed;


    public Stats() {

    }

    public Stats(Long id, String name, int age, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(id, name, age);

        if (strength <= 0) {
            throw new IllegalArgumentException("La fuerza debe ser un número positivo");
        }
        this.strength = strength;

        if (dexterity <= 0) {
            throw new IllegalArgumentException("La destreza debe ser un número positivo");
        }
        this.dexterity = dexterity;

        if (constitution <= 0) {
            throw new IllegalArgumentException("La constitución debe ser un número positivo");
        }
        this.constitution = constitution;

        if (intelligence <= 0) {
            throw new IllegalArgumentException("La inteligencia debe ser un número positivo");
        }
        this.intelligence = intelligence;

        if (wisdom <= 0) {
            throw new IllegalArgumentException("La sabiduría debe ser un número positivo");
        }
        this.wisdom = wisdom;

        if (charisma <= 0) {
            throw new IllegalArgumentException("El carisma debe ser un número positivo");
        }
        this.charisma = charisma;
    }



    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    @Override
    public String toString() {
        return "Race: " + getClase() + ", name = " + getName() + ", age = " + getAge() +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", charisma=" + charisma +
                ", speed=" + speed +
                " ";
    }
}