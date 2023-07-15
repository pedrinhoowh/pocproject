package com.poc.projectregister.controller;

import com.poc.projectregister.business.projeto.AlteraProjeto;
import com.poc.projectregister.business.projeto.BuscaProjeto;
import com.poc.projectregister.business.projeto.CriaProjeto;
import com.poc.projectregister.business.projeto.DeletaProjeto;
import com.poc.projectregister.domain.ProjetoDomain;
import com.poc.projectregister.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/projetos")
public class ProjetoController {

    @Autowired
    private CriaProjeto criaProjeto;

    @Autowired
    private AlteraProjeto alteraProjeto;

    @Autowired
    private BuscaProjeto buscaProjeto;

    @Autowired
    private DeletaProjeto deletaProjeto;

    @PostMapping
    public ResponseEntity<ProjetoDomain> cria(@RequestBody ProjetoDomain projetoDomain) {
        return new ResponseEntity<>(criaProjeto.cria(projetoDomain), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoDomain> altera(@PathVariable("id") Long id,
                                                @RequestBody ProjetoDomain projetoDomain) {

        if(!id.equals(projetoDomain.getId()))
            throw new BusinessException("A variavel ID precisa ser a mesma especificada dentro do body da requisicao de alteracao");

        return ResponseEntity.ok(alteraProjeto.altera(projetoDomain));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleta(@PathVariable("id") Long id) {
        deletaProjeto.delete(id);
        return new ResponseEntity<>(Void.class, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDomain> busca(@PathVariable("id") Long id) {
        return ResponseEntity.ok(buscaProjeto.busca(id));
    }

}
