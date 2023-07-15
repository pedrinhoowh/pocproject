package com.poc.projectregister.validators.impl;

import com.poc.projectregister.domain.MembrosDomain;
import com.poc.projectregister.exception.ErrorObject;
import com.poc.projectregister.repository.entity.PessoaEntity;
import com.poc.projectregister.repository.repository.PessoaRepository;
import com.poc.projectregister.validators.CriaMembrosValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Order(2)
@Component
public class PessoaFuncionarioValidator implements CriaMembrosValidator {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public List<ErrorObject> valida(MembrosDomain membrosDomain) {

        List<ErrorObject> errors = new ArrayList<>();

        Optional<PessoaEntity> optional = pessoaRepository.findById(membrosDomain.getPessoa());

        if (optional.isEmpty())
            errors.add(ErrorObject.builder().mensagemError("Nao existe pessoa cadastrada na base para o ID pessoa: " + membrosDomain.getPessoa()).build());

        if(optional.isPresent() && !optional.get().isFuncionario())
            errors.add(ErrorObject.builder().mensagemError("So e possivel associar um funcionario como membro de um projeto").build());

        return errors;
    }

}
