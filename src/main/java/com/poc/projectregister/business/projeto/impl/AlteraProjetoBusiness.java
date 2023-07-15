package com.poc.projectregister.business.projeto.impl;

import com.poc.projectregister.business.projeto.AlteraProjeto;
import com.poc.projectregister.business.projeto.BuscaPessoa;
import com.poc.projectregister.business.projeto.CriaProjeto;
import com.poc.projectregister.domain.ProjetoDomain;
import com.poc.projectregister.exception.BusinessException;
import com.poc.projectregister.exception.ErrorObject;
import com.poc.projectregister.exception.NotFoundException;
import com.poc.projectregister.repository.entity.ProjetoEntity;
import com.poc.projectregister.repository.repository.ProjetoRepository;
import com.poc.projectregister.validators.AlteraProjetoValidator;
import com.poc.projectregister.validators.CriaAlteraProjetoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AlteraProjetoBusiness implements AlteraProjeto {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private List<AlteraProjetoValidator> validators;

    @Autowired
    private BuscaPessoa buscaPessoa;

    @Override
    @Transactional
    public ProjetoDomain altera(ProjetoDomain projetoDomain) {

        Optional<ProjetoEntity> optional = projetoRepository.findById(projetoDomain.getId());

        ProjetoEntity projetoEntity = optional.orElseThrow(() -> new NotFoundException("Projeto nao encontrato com ID: " + projetoDomain.getId().toString()));

        List<ErrorObject> erros = new ArrayList<>();

        validators.forEach(validator -> erros.addAll(validator.valida(projetoDomain)));

        if(!CollectionUtils.isEmpty(erros))
            throw new BusinessException(String.join(", ", erros.stream().map(error -> error.getMensagemError()).collect(Collectors.toList())));

        buscaPessoa.busca(projetoDomain.getIdGerente());

        projetoEntity.update(projetoDomain);

        ProjetoEntity projetoEntityDb = projetoRepository.save(projetoEntity);

        return projetoEntityDb.toDomain();
    }

}
