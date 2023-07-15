package com.poc.projectregister.business.projeto.impl;

import com.poc.projectregister.business.projeto.CriaPessoa;
import com.poc.projectregister.domain.PessoaDomain;
import com.poc.projectregister.exception.BusinessException;
import com.poc.projectregister.exception.ErrorObject;
import com.poc.projectregister.repository.entity.PessoaEntity;
import com.poc.projectregister.repository.repository.PessoaRepository;
import com.poc.projectregister.validators.CriaPessoaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CriaPessoaBusiness implements CriaPessoa {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private List<CriaPessoaValidator> validators;

    @Override
    public PessoaDomain cria(PessoaDomain pessoaDomain) {

        List<ErrorObject> erros = new ArrayList<>();

        validators.forEach(validator -> erros.addAll(validator.valida(pessoaDomain)));

        if(!CollectionUtils.isEmpty(erros))
            throw new BusinessException(String.join(", ", erros.stream().map(error -> error.getMensagemError()).collect(Collectors.toList())));

        PessoaEntity pessoaEntity = pessoaRepository.save(pessoaDomain.toEntity());

        return pessoaEntity.toDomain();
    }

}
