package com.poc.projectregister.validators.impl;

import com.poc.projectregister.domain.ProjetoDomain;
import com.poc.projectregister.enumerators.RiscoProjeto;
import com.poc.projectregister.exception.ErrorObject;
import com.poc.projectregister.validators.AlteraProjetoValidator;
import com.poc.projectregister.validators.CriaAlteraProjetoValidator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RiscoProjetoValidator implements CriaAlteraProjetoValidator, AlteraProjetoValidator {

    @Override
    public List<ErrorObject> valida(ProjetoDomain projetoDomain) {
        List<ErrorObject> errorObjects = new ArrayList<>();

        if(projetoDomain.getRisco() != null && RiscoProjeto.exist(projetoDomain.getRisco()))
            errorObjects.add(ErrorObject.builder().mensagemError("Nao foi possivel encontra um risco com a descricao: " + projetoDomain.getRisco()).build());

        return errorObjects;
    }
}
