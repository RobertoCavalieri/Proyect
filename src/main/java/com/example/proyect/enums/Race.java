package com.example.proyect.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Race {


    DRAGONBORN("Dragonborn", "dragonborn"),
    DWARF ("Dwarf", "dwarf"),
    ELF("Elf", "elf"),
    GNOME ("Gnome", "gnome"),
    HALFORC ("HalfOrc", "halforc"),
    HALFLING ("Halfling", "halfling"),
    HUMAN ("Human", "human"),
    HALFELF ("Halfelf", "halfelf"),
    TIEFLING ("Tiefling", "tiefling");
    private String name;
    private String sigla;

   }

