package com.tecup.eva02Chocce.service.depart;

import com.tecup.eva02Chocce.domain.entities.Depart;
import com.tecup.eva02Chocce.domain.persistence.DepartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService{
    @Autowired
    private DepartDao dao;

    @Override
    @Transactional
    public void grabar(Depart depart) {
        dao.save(depart);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Depart buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Depart> listar() {
        return (List<Depart>)dao.findAll();
    }
}
