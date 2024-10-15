package com.tecup.eva02Chocce.domain.persistence;

import com.tecup.eva02Chocce.domain.entities.Career;
import org.springframework.data.repository.CrudRepository;


public interface CareerDao extends CrudRepository<Career, Integer> {

}
