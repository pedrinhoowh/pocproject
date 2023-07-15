package com.poc.projectregister.business.projeto.impl;

import com.poc.projectregister.business.projeto.DeletaMembros;
import com.poc.projectregister.repository.entity.MembrosEntity;
import com.poc.projectregister.repository.repository.MembrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class DeletaMembrosBusiness implements DeletaMembros {

    @Autowired
    private MembrosRepository membrosRepository;

    @Override
    @Transactional
    public void deleteByProjeto(Long idProjeto) {

        List<MembrosEntity> membros = membrosRepository.findByProjeto_Id(idProjeto);

        if(!CollectionUtils.isEmpty(membros))
            membros.forEach(membro -> membrosRepository.delete(membro));

    }

}
