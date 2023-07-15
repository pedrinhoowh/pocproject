package com.poc.projectregister.repository.repository;

import com.poc.projectregister.repository.entity.ProjetoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends CrudRepository<ProjetoEntity, Long> {
}
