package com.googlecode.exemplos;

/**
 * Interface de acesso a informa��es persistentes de Usuario.
 *
 */
public interface UsuarioRepository {
	Usuario getFromUserId(String userid);
}
