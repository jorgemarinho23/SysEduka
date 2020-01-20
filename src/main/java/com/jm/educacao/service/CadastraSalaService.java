/**
 * @author Jorge marinho on 27 de dez de 2019
 *
 * 
 */
package com.jm.educacao.service;

import java.io.Serializable;
import java.util.Calendar;

import javax.inject.Inject;

import com.jm.educacao.model.Sala;
import com.jm.educacao.repository.Salas;
import com.jm.educacao.util.jpa.Transactional;

public class CadastraSalaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Salas salas;
	
	@Transactional
	public Sala salvar(Sala sala) throws NegocioException {
		
		if (sala.getNome() == null || sala.getNome().trim().equals("")) {
			throw new NegocioException("Nome obrigatório!");
		}
		
		
		
		if (sala.getCodigo()==null) {
			sala.setDataCadastro(Calendar.getInstance());
		}
		
		
		
		return salas.salvar(sala);
		
	}

}
