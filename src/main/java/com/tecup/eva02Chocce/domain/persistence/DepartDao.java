package com.tecup.eva02Chocce.domain.persistence;

import com.tecup.eva02Chocce.domain.entities.Depart;
import org.springframework.data.repository.CrudRepository;

public interface DepartDao extends CrudRepository<Depart, Integer> {
}
