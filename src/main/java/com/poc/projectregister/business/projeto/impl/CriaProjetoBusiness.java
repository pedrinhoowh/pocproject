package com.poc.projectregister.business.projeto.impl;

import com.poc.projectregister.business.projeto.BuscaPessoa;
import com.poc.projectregister.business.projeto.CriaProjeto;
import com.poc.projectregister.domain.ProjetoDomain;
import com.poc.projectregister.exception.BusinessException;
import com.poc.projectregister.exception.ErrorObject;
import com.poc.projectregister.repository.entity.ProjetoEntity;
import com.poc.projectregister.repository.repository.ProjetoRepository;
import com.poc.projectregister.validators.CriaAlteraProjetoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CriaProjetoBusiness implements CriaProjeto {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private List<CriaAlteraProjetoValidator> validators;

    @Autowired
    private BuscaPessoa buscaPessoa;

    @Override
    @Transactional
    public ProjetoDomain cria(ProjetoDomain projetoDomain) {

        List<ErrorObject> erros = new ArrayList<>();

        validators.forEach(validator -> erros.addAll(validator.valida(projetoDomain)));

        if(!CollectionUtils.isEmpty(erros))
            throw new BusinessException(String.join(", ", erros.stream().map(error -> error.getMensagemError()).collect(Collectors.toList())));

        buscaPessoa.busca(projetoDomain.getIdGerente());

        ProjetoEntity projetoEntity = projetoRepository.save(projetoDomain.toEntity());

        return projetoEntity.toDomain();
    }

}
