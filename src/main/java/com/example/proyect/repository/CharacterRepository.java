package com.example.proyect.repository;
import com.example.proyect.entities.CharacterCreator;
import com.example.proyect.entities.races.Elf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterCreator, Longgiut> {
}

