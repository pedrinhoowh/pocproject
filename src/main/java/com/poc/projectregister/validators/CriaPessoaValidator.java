package com.poc.projectregister.validators;

import com.poc.projectregister.domain.PessoaDomain;
import com.poc.projectregister.exception.ErrorObject;

import java.util.List;

public interface CriaPessoaValidator {

    List<ErrorObject> valida(PessoaDomain pessoaDomain);

}
