package com.example.proyect.controller;
import com.example.proyect.entities.Character;
import com.example.proyect.DTO.CharacterDTO;
import com.example.proyect.service.CharacterService;
import com.example.proyect.repository.ICharacterRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class CharacterController {
    public static Logger log = LoggerFactory.getLogger(CharacterController.class);
    private ICharacterRepository characterRepository;

    public CharacterController(ICharacterRepository characterRepository) {
        this.characterRepository = characterRepository;


    }
    @Autowired
    private CharacterService characterService;

    @GetMapping("/characters")
    //Encontrar todos los pj
    public List<Character> findAll() {return characterRepository.findAll();}

    //encontrar pj por ID
    @ApiOperation(value = "Get character by ID", notes = "Get character by ID from the database")
    @GetMapping("/characters/{id}")
    public ResponseEntity<?> getCharacterById(@PathVariable Long id) {
        return ResponseEntity.ok().body(characterService.getCharacterByID(id));
    }

    //Actualiza un personaje existente
    @ApiOperation(value = "Update character", notes = "Update an existing character in the database")
    @PutMapping("/characters/update") //Poner MIN para que no se puedan pasar parametros menores a 1
    public ResponseEntity<Character> updateCharacter(@RequestBody  Character characterCreator, @RequestHeader HttpHeaders headers) {
        Character result = characterService.updateCharacter(characterCreator);
        return ResponseEntity.ok(result);
    }

    //Crea un personaje
    @ApiOperation(value = "Create character", notes = "Create a new character in the database")
    @PostMapping("/characters/pj")
    public ResponseEntity<String> createPj(@Valid @RequestBody CharacterDTO characterDTO) {
      characterService.createCharacter(characterDTO);
        return ResponseEntity.ok("Personaje creado exitosamente");
    }

    // Crear un personaje aleatorio
    @ApiOperation(value = "Create random character", notes = "Create a new random character in the database")
    @PostMapping("/characters/random/Pj")
    public ResponseEntity<String> randomPj() {
       characterService.characterRandom();
        return ResponseEntity.ok("Personaje aleatorio creado exitosamente");
    }

    //Crea un grupo de 5 personajes aleatorios
    @ApiOperation(value = "Create random party of characters", notes = "Create a new random party of characters in the database")
    @PostMapping("/characters/random/Party")
    public ResponseEntity<String> randomParty() {
        characterService.generateARandomParty();
        return ResponseEntity.ok("Party aleatoria creada exitosamente");
    }
}





