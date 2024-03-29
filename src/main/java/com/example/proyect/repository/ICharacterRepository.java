package com.example.proyect.repository;

import com.example.proyect.entities.Character;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ICharacterRepository extends JpaRepository<Character, Long> {
    @NotNull List<Character> findAll();
    Optional<Character> findById(Long id);

}

