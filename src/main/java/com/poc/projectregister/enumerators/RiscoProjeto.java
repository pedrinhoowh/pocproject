package com.poc.projectregister.enumerators;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum RiscoProjeto {

    BAIXO_RISCO("baixo risco"),
    MEDIO_RISCO("médio risco"),
    ALTO_RISCO("alto risco");

    private String descricao;

    public static Boolean exist(String descricao) {
        return Stream.of(RiscoProjeto.values())
                .anyMatch(statusProjeto -> statusProjeto.getDescricao().equalsIgnoreCase(descricao));
    }

}
