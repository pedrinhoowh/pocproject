package com.poc.projectregister.validators.impl;

import com.poc.projectregister.domain.ProjetoDomain;
import com.poc.projectregister.enumerators.StatusProjeto;
import com.poc.projectregister.exception.ErrorObject;
import com.poc.projectregister.validators.AlteraProjetoValidator;
import com.poc.projectregister.validators.CriaAlteraProjetoValidator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjetoStatusValidator implements CriaAlteraProjetoValidator, AlteraProjetoValidator {

    @Override
    public List<ErrorObject> valida(ProjetoDomain projetoDomain) {
        List<ErrorObject> errorObjects = new ArrayList<>();

        if(projetoDomain.getStatus() != null && !StatusProjeto.exist(projetoDomain.getStatus()))
            errorObjects.add(ErrorObject.builder().mensagemError("Nao foi possivel encontra um status com a descricao: " + projetoDomain.getStatus()).build());

        return errorObjects;
    }
}
