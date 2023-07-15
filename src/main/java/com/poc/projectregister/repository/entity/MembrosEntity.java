package com.poc.projectregister.repository.entity;

import com.poc.projectregister.domain.MembrosDomain;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "membros")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MembrosEntity implements Serializable {

    private static final long serialVersionUID = -4329644525211720779L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idpessoa", nullable = false)
    private PessoaEntity pessoa;

    @ManyToOne
    @JoinColumn(name = "idprojeto", nullable = false)
    private ProjetoEntity projeto;

    public MembrosDomain toDomain() {
        MembrosDomain membrosDomain = MembrosDomain.builder()
                .id(this.id)
                .projeto(this.projeto.getId())
                .pessoa(this.pessoa.getId())
                .build();

        return membrosDomain;
    }

}
