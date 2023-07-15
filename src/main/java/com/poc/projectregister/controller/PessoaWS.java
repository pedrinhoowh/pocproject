package com.poc.projectregister.controller;

import com.poc.projectregister.business.projeto.CriaPessoa;
import com.poc.projectregister.domain.PessoaDomain;
import com.poc.projectregister.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaWS {

    @Autowired
    private CriaPessoa criaPessoa;

    @PostMapping("/cria/pessoa")
    public PessoaDomain cria(@RequestParam("nome") String nome, @RequestParam("is_funcionario") String isFunciomario) {
        if(!"S".equalsIgnoreCase(isFunciomario) && !"N".equalsIgnoreCase(isFunciomario))
            throw new BusinessException("O parametro is_funcionario precisa ser preenchido com S ou N");

        return criaPessoa.cria(PessoaDomain.builder().nome(nome).isFuncionario("S".equalsIgnoreCase(isFunciomario)).build());
    }
}
