package com.tecup.eva02Chocce.domain.persistence;

import com.tecup.eva02Chocce.domain.entities.Auditoria;
import org.springframework.data.repository.CrudRepository;

public interface AuditoriaDao extends CrudRepository<Auditoria, Integer> {
}
