package com.autenticacion.modelos.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.autenticacion.modelos.NombreRol;
import com.autenticacion.modelos.Rol;


public interface RolRepository extends CrudRepository<Rol, Long> {
	Optional<Rol> findByNombreRol(NombreRol nombreRol);
}
