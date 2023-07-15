package com.poc.projectregister.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.poc.projectregister.repository.entity.PessoaEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaDomain implements Serializable {

    private static final long serialVersionUID = -4329644525211720779L;

    private Long id;

    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String cpf;

    private boolean isFuncionario;

    public PessoaEntity toEntity() {
        PessoaEntity pessoaEntity = PessoaEntity.builder()
                .id(this.id)
                .nome(this.nome)
                .dataNascimento(this.dataNascimento)
                .cpf(this.cpf)
                .isFuncionario(this.isFuncionario)
                .build();

        return pessoaEntity;
    }
}
