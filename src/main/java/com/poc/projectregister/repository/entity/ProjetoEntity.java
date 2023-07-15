package com.poc.projectregister.repository.entity;

import com.poc.projectregister.domain.ProjetoDomain;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "projeto")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ProjetoEntity implements Serializable {

    private static final long serialVersionUID = -4329644525211720779L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 200, nullable = false)
    private String nome;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_previsao_fim")
    private LocalDate dataPrevisaoFim;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @Column(name = "descricao", length = 5000)
    private String descricao;

    @Column(name = "status", length = 45)
    private String status;

    @Column(name = "orcamento")
    private Double orcamento;

    @Column(name = "risco", length = 45)
    private String risco;

    @ManyToOne
    @JoinColumn(name = "idgerente", nullable = false)
    private PessoaEntity idGerente;

    public ProjetoDomain toDomain() {
        ProjetoDomain projetoDomain = ProjetoDomain.builder()
                .id(this.id)
                .nome(this.nome)
                .dataInicio(this.dataInicio)
                .dataPrevisaoFim(this.dataPrevisaoFim)
                .dataFim(this.dataFim)
                .descricao(this.descricao)
                .status(this.status)
                .orcamento(this.orcamento)
                .risco(this.risco)
                .idGerente(this.idGerente.getId())
                .build();

        return projetoDomain;
    }

    public void update(ProjetoDomain projetoDomain) {
        this.setNome(projetoDomain.getNome());
        this.setDataInicio(projetoDomain.getDataInicio());
        this.setDataPrevisaoFim(projetoDomain.getDataPrevisaoFim());
        this.setDataFim(projetoDomain.getDataFim());
        this.setDescricao(projetoDomain.getDescricao());
        this.setDescricao(projetoDomain.getDescricao());
        this.setStatus(projetoDomain.getStatus());
        this.setOrcamento(projetoDomain.getOrcamento());
        this.setRisco(projetoDomain.getRisco());
        this.setIdGerente(PessoaEntity.builder().id(projetoDomain.getIdGerente()).build());
    }

}
