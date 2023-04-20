package com.example.proyect.controller;
import com.example.proyect.entities.Character;
import com.example.proyect.entities.races.Human;
import com.example.proyect.repository.CharacterRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class CharacterController {
    private static final Logger log = LoggerFactory.getLogger(CharacterController.class);
    private CharacterRepository characterRepository;

    public CharacterController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @GetMapping("/characters")
    //Encontrar todos los pj
    public List<Character> findAll() {return characterRepository.findAll();}

    @GetMapping("/characters/{id}") //encontrar pj por ID
    @ApiOperation("Buscar un personaje por clave primaria id Long")
    public ResponseEntity<Character> findOneById(@ApiParam("Clave primaria tipo Long") @PathVariable Long id) {

            Optional<Character> characterOpt = characterRepository.findById(id);
            return characterOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }*/
    //encontrar pj por ID
    @ApiOperation(value = "Get character by ID", notes = "Get character by ID from the database")
    @GetMapping("/characters/{id}")
    public ResponseEntity<?> getCharacterById(@PathVariable Long id) {
        return ResponseEntity.ok().body(characterService.getCharacterByID(id));
    }
    @PostMapping("/characters")
    public ResponseEntity<Human> create(@RequestBody Human characterCreator, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        if(characterCreator.getId() != null){
            log.warn("trying to create a character with id");
            System.out.println("trying to create a character with id");
            return ResponseEntity.badRequest().build();
        }
        Human result = characterRepository.save(characterCreator);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/characters")
    public ResponseEntity<Character> update(@RequestBody Character characterCreator){
        if(characterCreator.getId() == null ){ // si no tiene id quiere decir que sí es una creación
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if(!characterRepository.existsById(characterCreator.getId())){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }

        // El proceso de actualización
        Character result = characterRepository.save(characterCreator);
        return ResponseEntity.ok(result); // el personaje devuelto tiene una clave primaria
    }

    @ApiIgnore
    @DeleteMapping("/characters/{id}")
    public ResponseEntity<Character> delete(@PathVariable Long id){

        if(!characterRepository.existsById(id)){
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }

        characterRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    @ApiIgnore
    @DeleteMapping("/characters")
    public ResponseEntity<Character> deleteAll(){
        log.info("REST Request for delete all books");
        characterRepository.deleteAll();
        return ResponseEntity.noContent().build();
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
    @PostMapping("/characters2/pj")
    public ResponseEntity<String> createPj( @Valid @RequestBody CharacterDTO characterDTO) {
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





