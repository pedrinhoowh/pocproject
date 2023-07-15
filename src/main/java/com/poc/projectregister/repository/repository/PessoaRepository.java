package com.poc.projectregister.repository.repository;

import com.poc.projectregister.repository.entity.PessoaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository<PessoaEntity, Long> {
}
