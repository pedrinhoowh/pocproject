package com.poc.projectregister.repository.entity;

import com.poc.projectregister.domain.PessoaDomain;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pessoa")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaEntity implements Serializable {

    private static final long serialVersionUID = -4329644525211720779L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "datanascimento")
    private LocalDate dataNascimento;

    @Column(name = "cpf", length = 14)
    private String cpf;

    @Column(name = "funcionario")
    private boolean isFuncionario;

    public PessoaDomain toDomain() {
        PessoaDomain pessoaDomain = PessoaDomain.builder()
                .id(this.id)
                .nome(this.nome)
                .dataNascimento(this.dataNascimento)
                .cpf(this.cpf)
                .isFuncionario(this.isFuncionario)
                .build();

        return pessoaDomain;
    }
}
