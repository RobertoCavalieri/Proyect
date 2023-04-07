package com.example.proyect.DTO;


import jakarta.validation.constraints.Min;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CharacterDTO {
    private String race;
    private String name;
    @Min(value = 10,message = "Las edad no puede ser menor a 10")
    private int age;
    @Min(value = 1,message = "Las estadística de fuerza no puede ser menor a 1")
    private int strength;
    @Min(value = 1,message = "Las estadística de destreza no puede ser menor a 1")
    private int dexterity;
    @Min(value = 1,message ="Las estadística de constitución no puede ser menor a 1")
    private int constitution;
    @Min(value = 1,message = "Las estadística de inteligencia no puede ser menor a 1")
    private int intelligence;
    @Min(value = 1,message = "Las estadística de sabiduría no puede ser menor a 1")
    private int wisdom;
    @Min(value = 1,message ="Las estadística de carisma no puede ser menor a 1")
    private int charisma;
    private int speed;
    
}
