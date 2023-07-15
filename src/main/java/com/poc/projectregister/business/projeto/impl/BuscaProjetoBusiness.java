package com.poc.projectregister.business.projeto.impl;

import com.poc.projectregister.business.projeto.BuscaProjeto;
import com.poc.projectregister.domain.ProjetoDomain;
import com.poc.projectregister.exception.NotFoundException;
import com.poc.projectregister.repository.entity.ProjetoEntity;
import com.poc.projectregister.repository.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class BuscaProjetoBusiness implements BuscaProjeto {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Override
    @Transactional(readOnly = true)
    public ProjetoDomain busca(Long id) {
        Optional<ProjetoEntity> optional = projetoRepository.findById(id);

        return optional
                .orElseThrow(() -> new NotFoundException("Projeto nao encontrato com ID: " + id.toString()))
                .toDomain();
    }

}
