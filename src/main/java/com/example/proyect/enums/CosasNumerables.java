package com.example.proyect.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum CosasNumerables {
    MESA("MESA", "MS"),
    SILLA("SILLA", "SA"),
    TELEVISION("TELEVISION", "TV");

    private String name;
    private String sigla;

    public static CosasNumerables fromSigla(String sigla) {
        for (CosasNumerables cosasNumerables : CosasNumerables.values()) {
            if (cosasNumerables.getSigla().equals(sigla)) {
                return cosasNumerables;
            }
        }
        throw new RuntimeException();
    }

    public static CosasNumerables fromName(String name){
        return CosasNumerables.valueOf(name);
    }
}
