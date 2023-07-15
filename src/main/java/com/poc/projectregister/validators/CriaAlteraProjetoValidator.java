package com.poc.projectregister.validators;

import com.poc.projectregister.domain.ProjetoDomain;
import com.poc.projectregister.exception.ErrorObject;

import java.util.List;

public interface CriaAlteraProjetoValidator {

    List<ErrorObject> valida(ProjetoDomain projetoDomain);
}