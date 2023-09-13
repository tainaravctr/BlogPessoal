package com.generation.blogpessoall.repository;

import java.util.Optional;

import com.generation.blogpessoall.model.Usuario;

public interface UsuarioRepository {

	Optional<Usuario> findByUsuario(String userName);

	Optional<Usuario> findById(Long id);

	Object save(Usuario usuario);

	Object findAll();

}
