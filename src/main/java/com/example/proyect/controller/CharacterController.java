package com.example.proyect.controller;
import com.example.proyect.entities.Character;
import com.example.proyect.DTO.CharacterDTO;
import com.example.proyect.exceptions.ExcepcionHandler;
import com.example.proyect.service.CharacterService;
import com.example.proyect.repository.ICharacterRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    public static Logger log = LoggerFactory.getLogger(CharacterController.class);
    private ICharacterRepository characterRepository;

    public CharacterController(ICharacterRepository characterRepository) {
        this.characterRepository = characterRepository;


    }

    @Autowired
    private CharacterService characterService;

    @GetMapping("")
    //Encontrar todos los pj
    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    //encontrar pj por ID
    @GetMapping("/{id}")
    public Character getCharacter(@PathVariable Long id) {
        return characterService.getCharacterByID(id).orElse(null);
    }

    //Actualiza un personaje existente
    @PutMapping("/characters/update/{characterId}")
        public ResponseEntity<String> updateCharacter(@PathVariable Long characterId, @RequestBody CharacterDTO characterDTO) {
            try {
                Character updatedCharacter = characterService.updateCharacter(characterId, characterDTO);
                return ResponseEntity.ok("Personaje actualizado exitosamente");
            } catch (ExcepcionHandler ex) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("ID de personaje inválido");
            }
        }


    //Crea un personaje
    @Operation(summary = "Create a new character in the database")
    @PostMapping("/pj")
    public ResponseEntity<String> createPj(@Valid @RequestBody CharacterDTO characterDTO) {
        characterService.createCharacter(characterDTO);
        return ResponseEntity.ok("Personaje creado exitosamente");
    }

    // Crear un personaje aleatorio
    @ApiOperation(value = "Create random character", notes = "Create a new random character in the database")
    @PostMapping("/random/Pj")
    public ResponseEntity<String> randomPj() {
        characterService.characterRandom();
        return ResponseEntity.ok("Personaje aleatorio creado exitosamente");
    }

    //Crea un grupo de 5 personajes aleatorios
    @PostMapping("/random/Party")
    public ResponseEntity<String> randomParty() {
        characterService.generateARandomParty();
        return ResponseEntity.ok("Party aleatoria creada exitosamente");
    }

    //Eliminar un personaje
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        characterService.deleteCharacterById(id);
        return ResponseEntity.ok("Personaje eliminado exitosamente");

    }

    }






