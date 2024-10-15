package com.tecup.eva02Chocce.domain.persistence;


import com.tecup.eva02Chocce.domain.entities.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventDao extends CrudRepository<Event, Integer> {
}
