package com.autenticacion.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class UsuarioLoginDTO {

	@NotNull
	@NotBlank
	private String nombreUsuario;

	@NotNull
	@NotBlank
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String clave;

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getClave() {
		return clave;
	}
	
	
	
}
