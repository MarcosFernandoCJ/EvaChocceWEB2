package com.tecup.eva02Chocce.domain.persistence;


import com.tecup.eva02Chocce.domain.entities.Tourment;
import org.springframework.data.repository.CrudRepository;

public interface TourmentDao extends CrudRepository<Tourment, Integer> {
}
