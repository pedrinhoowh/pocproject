package com.poc.projectregister.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.poc.projectregister.repository.entity.PessoaEntity;
import com.poc.projectregister.repository.entity.ProjetoEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ProjetoDomain implements Serializable {

    private static final long serialVersionUID = -4329644525211720779L;

    private Long id;

    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPrevisaoFim;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim;

    private String descricao;

    private String status;

    private Double orcamento;

    private String risco;

    private Long idGerente;

    public ProjetoEntity toEntity() {
        ProjetoEntity projetoEntity = ProjetoEntity.builder()
                .dataFim(this.dataFim)
                .id(this.id)
                .nome(this.nome)
                .dataInicio(this.dataInicio)
                .dataPrevisaoFim(this.dataPrevisaoFim)
                .descricao(this.descricao)
                .status(this.status)
                .orcamento(this.orcamento)
                .risco(this.risco)
                .idGerente(PessoaEntity.builder().id(this.idGerente).build())
                .build();

        return projetoEntity;
    }

}
