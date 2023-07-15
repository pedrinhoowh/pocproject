package com.poc.projectregister.controller;

import com.poc.projectregister.business.projeto.CriaMembros;
import com.poc.projectregister.domain.MembrosDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/membros")
public class MembrosController {

    @Autowired
    private CriaMembros criaMembros;

    @PostMapping
    public ResponseEntity<MembrosDomain> cria(@RequestBody MembrosDomain membrosDomain) {
        return new ResponseEntity<>(criaMembros.cria(membrosDomain), HttpStatus.CREATED);
    }

}
