package com.poc.projectregister.enumerators;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum StatusProjeto {

    ANALISE("em análise"),
    ANALISE_REALIZADA("análise realizada"),
    ANALISE_APROVADA("análise aprovada"),
    INICIADO("iniciado"),
    PLANEJADO("planejado"),
    EM_ANDAMENTO("em andamento"),
    ENCERRADO("encerrado"),
    CANCELADO("cancelado");

    private String descricao;

    public static Boolean exist(String descricao) {
        return Stream.of(StatusProjeto.values())
                .anyMatch(statusProjeto -> statusProjeto.getDescricao().equalsIgnoreCase(descricao));
    }

}
