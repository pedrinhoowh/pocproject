package com.poc.projectregister.business.projeto.impl;

import com.poc.projectregister.business.projeto.DeletaMembros;
import com.poc.projectregister.business.projeto.DeletaProjeto;
import com.poc.projectregister.exception.BusinessException;
import com.poc.projectregister.exception.ErrorObject;
import com.poc.projectregister.exception.NotFoundException;
import com.poc.projectregister.repository.entity.ProjetoEntity;
import com.poc.projectregister.repository.repository.ProjetoRepository;
import com.poc.projectregister.validators.ExcluiProjetoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeletaProjetoBusiness implements DeletaProjeto {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private DeletaMembros deletaMembros;

    @Autowired
    private List<ExcluiProjetoValidator> validators;

    @Override
    @Transactional
    public void delete(Long id) {
        ProjetoEntity projeto = projetoRepository.findById(id).orElseThrow(() -> new NotFoundException("Projeto nao encontrato com ID: " + id));

        List<ErrorObject> errorObjects = new ArrayList<>();

        validators.forEach(validator -> errorObjects.addAll(validator.valida(projeto)));

        if(!CollectionUtils.isEmpty(errorObjects))
            throw new BusinessException(String.join(", ", errorObjects.stream().map(error -> error.getMensagemError()).collect(Collectors.toList())));

        deletaMembros.deleteByProjeto(id);

        projetoRepository.delete(projeto);
    }

}
