package com.poc.projectregister.validators;

import com.poc.projectregister.domain.MembrosDomain;
import com.poc.projectregister.exception.ErrorObject;

import java.util.List;

public interface CriaMembrosValidator {

    List<ErrorObject> valida(MembrosDomain membrosDomain);

}
