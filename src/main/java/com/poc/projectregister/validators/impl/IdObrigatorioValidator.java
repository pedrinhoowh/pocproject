package com.poc.projectregister.validators.impl;

import com.poc.projectregister.domain.ProjetoDomain;
import com.poc.projectregister.exception.ErrorObject;
import com.poc.projectregister.validators.AlteraProjetoValidator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IdObrigatorioValidator implements AlteraProjetoValidator {

    @Override
    public List<ErrorObject> valida(ProjetoDomain projetoDomain) {
        List<ErrorObject> erros = new ArrayList<>();

        if(projetoDomain.getId() == null)
            erros.add(ErrorObject.builder().mensagemError("O campo ID é obrigatório").build());

        return erros;
    }
}
