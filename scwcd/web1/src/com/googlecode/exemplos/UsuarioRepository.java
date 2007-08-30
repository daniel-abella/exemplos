package com.googlecode.exemplos;

/**
 * Interface de acesso a informações persistentes de Usuario.
 *
 */
public interface UsuarioRepository {
	Usuario getFromUserId(String userid);
}
