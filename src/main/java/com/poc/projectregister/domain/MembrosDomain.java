package com.poc.projectregister.domain;

import com.poc.projectregister.repository.entity.MembrosEntity;
import com.poc.projectregister.repository.entity.PessoaEntity;
import com.poc.projectregister.repository.entity.ProjetoEntity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MembrosDomain implements Serializable {

    private static final long serialVersionUID = -4329644525211720779L;

    private Long id;

    private Long pessoa;

    private Long projeto;

    public MembrosEntity toEntity() {
        MembrosEntity membrosEntity = MembrosEntity.builder()
                .id(this.id)
                .projeto(ProjetoEntity.builder().id(this.projeto).build())
                .pessoa(PessoaEntity.builder().id(this.pessoa).build())
                .build();

        return membrosEntity;
    }
}
