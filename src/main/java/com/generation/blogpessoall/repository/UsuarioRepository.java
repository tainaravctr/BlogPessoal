package com.generation.blogpessoall.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.generation.blogpessoall.model.Usuario;


@Component
public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {

	Optional<Usuario> findByUsuario(String userName);


	<S> S save(Usuario usuario);

	List<Usuario> findAll();

	Object findById(Usuario usuario);

}
