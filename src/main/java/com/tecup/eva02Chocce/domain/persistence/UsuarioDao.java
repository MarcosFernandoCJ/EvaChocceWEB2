package com.tecup.eva02Chocce.domain.persistence;

import com.tecup.eva02Chocce.domain.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Integer> {
}
