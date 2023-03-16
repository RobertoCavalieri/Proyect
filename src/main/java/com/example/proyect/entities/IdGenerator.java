package com.example.proyect.entities;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;

@MappedSuperclass
@Table(name = "PJ")
public abstract class IdGenerator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty
    private Long id;

    public IdGenerator(Long id) {
        this.id = id;
    }

    public IdGenerator() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
