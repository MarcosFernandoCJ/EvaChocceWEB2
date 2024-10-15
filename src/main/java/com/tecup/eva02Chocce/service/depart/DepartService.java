package com.tecup.eva02Chocce.service.depart;

import com.tecup.eva02Chocce.domain.entities.Depart;

import java.util.List;

public interface DepartService {
    public void grabar(Depart depart);
    public void eliminar(int id);
    public Depart buscar(Integer id);
    public List<Depart> listar();
}
