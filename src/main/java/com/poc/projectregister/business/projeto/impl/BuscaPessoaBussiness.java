package com.poc.projectregister.business.projeto.impl;

import com.poc.projectregister.business.projeto.BuscaPessoa;
import com.poc.projectregister.domain.PessoaDomain;
import com.poc.projectregister.exception.NotFoundException;
import com.poc.projectregister.repository.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscaPessoaBussiness implements BuscaPessoa {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public PessoaDomain busca(Long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new NotFoundException("Nao foi possivel encontrar uma pessoa com ID: " + id)).toDomain();
    }

}
