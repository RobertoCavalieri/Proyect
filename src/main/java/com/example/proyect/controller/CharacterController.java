package com.example.proyect.controller;
import com.example.proyect.entities.CharacterCreator;
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
public class CharacterController {
    private static final Logger log = LoggerFactory.getLogger(CharacterController.class);
    private CharacterRepository characterRepository;

    public CharacterController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @GetMapping("/characters")
    //Encontrar todos los pj
    public List<CharacterCreator> findAll() {return characterRepository.findAll();}

    @GetMapping("/characters/{id}") //encontrar pj por ID
    @ApiOperation("Buscar un personaje por clave primaria id Long")
    public ResponseEntity<CharacterCreator> findOneById(@ApiParam("Clave primaria tipo Long") @PathVariable Long id) {

        Optional<CharacterCreator> characterOpt = characterRepository.findById(id);
        return characterOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

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
    public ResponseEntity<CharacterCreator> update(@RequestBody CharacterCreator characterCreator){
        if(characterCreator.getId() == null ){ // si no tiene id quiere decir que sí es una creación
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if(!characterRepository.existsById(characterCreator.getId())){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }

        // El proceso de actualización
        CharacterCreator result = characterRepository.save(characterCreator);
        return ResponseEntity.ok(result); // el personaje devuelto tiene una clave primaria
    }

    @ApiIgnore
    @DeleteMapping("/characters/{id}")
    public ResponseEntity<CharacterCreator> delete(@PathVariable Long id){

        if(!characterRepository.existsById(id)){
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }

        characterRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    @ApiIgnore
    @DeleteMapping("/characters")
    public ResponseEntity<CharacterCreator> deleteAll(){
        log.info("REST Request for delete all books");
        characterRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}


