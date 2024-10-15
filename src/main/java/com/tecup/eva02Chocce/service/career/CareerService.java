package com.tecup.eva02Chocce.service.career;

import com.tecup.eva02Chocce.domain.entities.Career;

import java.util.List;

public interface CareerService {
    public void grabar(Career career);
    public void eliminar(int id);
    public Career buscar(Integer id);
    public List<Career> listar();
}
