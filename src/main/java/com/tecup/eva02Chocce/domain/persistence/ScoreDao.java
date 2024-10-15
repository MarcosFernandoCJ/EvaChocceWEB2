package com.tecup.eva02Chocce.domain.persistence;


import com.tecup.eva02Chocce.domain.entities.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreDao extends CrudRepository<Score, Integer> {
}
