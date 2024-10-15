package com.tecup.eva02Chocce.service.tourment;

import com.tecup.eva02Chocce.domain.entities.Tourment;

import java.util.List;

public interface TourmentService {
    public void grabar(Tourment tourment);
    public void eliminar(int id);
    public Tourment buscar(Integer id);
    public List<Tourment> listar();
}
