package com.autenticacion.modelos.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.autenticacion.modelos.Usuario;



public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	@Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.rol r WHERE u.nombreUsuario = :nombreUsuario")
	public Optional<Usuario> buscarPorNombreUsuario(String nombreUsuario);
	
}
