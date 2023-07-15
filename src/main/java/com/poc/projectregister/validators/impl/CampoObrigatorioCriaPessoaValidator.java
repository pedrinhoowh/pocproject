package com.poc.projectregister.validators.impl;

import com.poc.projectregister.domain.PessoaDomain;
import com.poc.projectregister.exception.ErrorObject;
import com.poc.projectregister.validators.CriaPessoaValidator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampoObrigatorioCriaPessoaValidator implements CriaPessoaValidator {

    @Override
    public List<ErrorObject> valida(PessoaDomain pessoaDomain) {
        List<ErrorObject> erros = new ArrayList<>();

        if(pessoaDomain.getNome() == null || pessoaDomain.getNome().length() > 100)
            erros.add(ErrorObject.builder().mensagemError("Campo nome informado se encontra invalido. Ele e obrigatorio e precisa ser menor que 100").build());

        return erros;
    }

}
