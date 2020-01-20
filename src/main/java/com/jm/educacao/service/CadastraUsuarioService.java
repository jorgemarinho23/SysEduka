/**
 * @author Jorge marinho on 20 de dez de 2019
 *
 * 
 */
package com.jm.educacao.service;

import java.io.Serializable;
import java.util.Calendar;

import javax.inject.Inject;

import com.jm.educacao.model.Usuario;
import com.jm.educacao.repository.Usuarios;
import com.jm.educacao.util.jpa.Transactional;

public class CadastraUsuarioService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuarios;
	
	@Transactional
	public Usuario salvar(Usuario usuario) throws NegocioException {
		
		if (usuario.getNome() == null || usuario.getNome().trim().equals("")) {
			
			throw new NegocioException("Nome obrigatório !");
		}
		
		if (usuario.getCodigo() == null) {
			usuario.setDataCadastro(Calendar.getInstance());
		}
		
		return usuarios.salvar(usuario);
		
	}

}
