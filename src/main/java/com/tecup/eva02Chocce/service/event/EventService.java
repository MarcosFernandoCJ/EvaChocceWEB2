package com.tecup.eva02Chocce.service.event;

import com.tecup.eva02Chocce.domain.entities.Event;

import java.util.List;

public interface EventService {
    public void grabar(Event event);
    public void eliminar(int id);
    public Event buscar(Integer id);
    public List<Event> listar();
}
