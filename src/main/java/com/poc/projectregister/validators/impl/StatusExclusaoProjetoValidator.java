package com.poc.projectregister.validators.impl;

import com.poc.projectregister.enumerators.StatusProjeto;
import com.poc.projectregister.exception.ErrorObject;
import com.poc.projectregister.repository.entity.ProjetoEntity;
import com.poc.projectregister.validators.ExcluiProjetoValidator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StatusExclusaoProjetoValidator implements ExcluiProjetoValidator {

    @Override
    public List<ErrorObject> valida(ProjetoEntity projeto) {
        List<ErrorObject> errors = new ArrayList<>();

        if(StatusProjeto.INICIADO.getDescricao().equals(projeto.getStatus())
                || StatusProjeto.EM_ANDAMENTO.getDescricao().equals(projeto.getStatus())
        || StatusProjeto.ENCERRADO.getDescricao().equals(projeto.getStatus()))
            errors.add(ErrorObject.builder().mensagemError("Nao e possivel excluir um projeto com STATUS: " + projeto.getStatus()).build());

        return errors;
    }

}
