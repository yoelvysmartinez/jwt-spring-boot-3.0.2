package com.autenticacion.servicios;

import com.autenticacion.dto.UsuarioDTO;
import com.autenticacion.dto.UsuarioLoginDTO;

public interface UsuarioService  {
	public UsuarioDTO login(UsuarioLoginDTO usuarioLoginDTO);

	public UsuarioDTO crear(UsuarioDTO usuarioDTO) throws Exception;

	
}
