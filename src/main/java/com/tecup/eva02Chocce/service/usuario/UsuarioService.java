package com.tecup.eva02Chocce.service.usuario;

import com.tecup.eva02Chocce.domain.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    public void grabar(Usuario user);
    public void eliminar(int id);
    public Usuario buscar(Integer id);
    public List<Usuario> listar();
}
