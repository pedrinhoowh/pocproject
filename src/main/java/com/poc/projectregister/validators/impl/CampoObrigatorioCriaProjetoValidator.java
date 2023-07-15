package com.poc.projectregister.validators.impl;

import com.poc.projectregister.domain.ProjetoDomain;
import com.poc.projectregister.exception.ErrorObject;
import com.poc.projectregister.validators.AlteraProjetoValidator;
import com.poc.projectregister.validators.CriaAlteraProjetoValidator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampoObrigatorioCriaProjetoValidator implements CriaAlteraProjetoValidator, AlteraProjetoValidator {

    @Override
    public List<ErrorObject> valida(ProjetoDomain projetoDomain) {
        List<ErrorObject> errorObjects = new ArrayList<>();

        if(projetoDomain.getDataInicio() == null)
            errorObjects.add(ErrorObject.builder().mensagemError("dataInicio é obrigatório e precisa ter no máximo 200 caracteres").build());

        if(projetoDomain.getDataPrevisaoFim() == null)
            errorObjects.add(ErrorObject.builder().mensagemError("dataPrevisaoFim é obrigatório e precisa ter no máximo 200 caracteres").build());

        if(projetoDomain.getDataFim() == null)
            errorObjects.add(ErrorObject.builder().mensagemError("dataFim é obrigatório e precisa ter no máximo 200 caracteres").build());

        if(projetoDomain.getNome() == null || projetoDomain.getNome().length() > 200)
            errorObjects.add(ErrorObject.builder().mensagemError("Nome é obrigatório e precisa ter no máximo 200 caracteres").build());

        if(projetoDomain.getDescricao() != null && projetoDomain.getDescricao().length() > 5000)
            errorObjects.add(ErrorObject.builder().mensagemError("Descricao precisa ter no maximo 5000 caracteres").build());

        if(projetoDomain.getIdGerente() == null)
            errorObjects.add(ErrorObject.builder().mensagemError("idGerente é obrigatório").build());

        return errorObjects;
    }
}
