package com.poc.projectregister.validators.impl;

import com.poc.projectregister.domain.MembrosDomain;
import com.poc.projectregister.exception.ErrorObject;
import com.poc.projectregister.validators.CriaMembrosValidator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Order(1)
@Component
public class CampoObrigatorioCriaMembrosValidator implements CriaMembrosValidator {

    @Override
    public List<ErrorObject> valida(MembrosDomain membrosDomain) {
        List<ErrorObject> errors = new ArrayList<>();

        if(membrosDomain.getPessoa() == null)
            errors.add(ErrorObject.builder().mensagemError("O campo pessoa e obrigatorio").build());

        if(membrosDomain.getProjeto() == null)
            errors.add(ErrorObject.builder().mensagemError("O campo projeto e obrigatorio").build());

        return errors;
    }

}
