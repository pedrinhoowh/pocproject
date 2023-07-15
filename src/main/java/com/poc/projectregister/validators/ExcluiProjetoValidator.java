package com.poc.projectregister.validators;

import com.poc.projectregister.exception.ErrorObject;
import com.poc.projectregister.repository.entity.ProjetoEntity;

import java.util.List;

public interface ExcluiProjetoValidator {

    List<ErrorObject> valida(ProjetoEntity projeto);

}
