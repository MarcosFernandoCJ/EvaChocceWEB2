package com.tecup.eva02Chocce.service.usuario;

import com.tecup.eva02Chocce.domain.entities.Usuario;
import com.tecup.eva02Chocce.domain.persistence.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service

public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioDao dao;

    @Override
    @Transactional
    public void grabar(Usuario usuario) {
        dao.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listar() {
        return (List<Usuario>)dao.findAll();
    }
}
