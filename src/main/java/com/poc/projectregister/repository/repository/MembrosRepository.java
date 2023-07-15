package com.poc.projectregister.repository.repository;

import com.poc.projectregister.repository.entity.MembrosEntity;
import com.poc.projectregister.repository.entity.ProjetoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembrosRepository extends CrudRepository<MembrosEntity, Long> {

    List<MembrosEntity> findByProjeto_Id(Long idProjeto);

    Optional<MembrosEntity> findFirstByPessoa_IdAndProjeto_Id(Long idPessoa, Long idProjeto);

}
