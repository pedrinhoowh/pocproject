package com.poc.projectregister.business.projeto.impl;

import com.poc.projectregister.business.projeto.BuscaPessoa;
import com.poc.projectregister.business.projeto.BuscaProjeto;
import com.poc.projectregister.business.projeto.CriaMembros;
import com.poc.projectregister.domain.MembrosDomain;
import com.poc.projectregister.exception.BusinessException;
import com.poc.projectregister.exception.ErrorObject;
import com.poc.projectregister.repository.entity.MembrosEntity;
import com.poc.projectregister.repository.repository.MembrosRepository;
import com.poc.projectregister.validators.CriaMembrosValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CriaMembrosBusiness implements CriaMembros {

    @Autowired
    private MembrosRepository membrosRepository;

    @Autowired
    private List<CriaMembrosValidator> validators;

    @Autowired
    private BuscaProjeto buscaProjeto;

    @Autowired
    private BuscaPessoa buscaPessoa;

    @Override
    public MembrosDomain cria(MembrosDomain membrosDomain) {

        List<ErrorObject> errors = new ArrayList<>();

        validators.forEach(validator -> errors.addAll(validator.valida(membrosDomain)));

        if(!CollectionUtils.isEmpty(errors))
            throw new BusinessException(String.join(", ", errors.stream().map(error -> error.getMensagemError()).collect(Collectors.toList())));

        buscaProjeto.busca(membrosDomain.getProjeto());

        buscaPessoa.busca(membrosDomain.getPessoa());

        if(membrosRepository.findFirstByPessoa_IdAndProjeto_Id(membrosDomain.getPessoa(), membrosDomain.getProjeto()).isPresent())
            throw new BusinessException("Ja existe um projeto associado a esta pessoa.");

        MembrosEntity membrosEntity = membrosRepository.save(membrosDomain.toEntity());

        return membrosEntity.toDomain();
    }

}
