package com.example.proyect.DTO;


import com.example.proyect.enums.Race;
import com.example.proyect.enums.RaceDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CharacterDTO {
    @JsonDeserialize(using = RaceDeserializer.class)
    private Race race;
    @NotBlank(message= "Debe contener un nombre")
    @NotNull
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

    public String getRace() {
        return String.valueOf(this.race);
    }


}
