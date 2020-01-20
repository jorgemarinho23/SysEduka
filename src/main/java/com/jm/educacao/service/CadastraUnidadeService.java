/**
 * @author Jorge marinho on 20 de dez de 2019
 *
 * 
 */
package com.jm.educacao.service;

import java.io.Serializable;
import java.util.Calendar;

import javax.inject.Inject;

import com.jm.educacao.model.Unidade;
import com.jm.educacao.repository.Unidades;
import com.jm.educacao.util.jpa.Transactional;

public class CadastraUnidadeService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Unidades unidades;
	
	@Transactional
	public Unidade salvar(Unidade unidade) throws NegocioException{
		
		if (unidade.getDescricao() == null || unidade.getDescricao().trim().equals("")) {
			
			throw new NegocioException("Nome obrigatório !");
		}
		
		if (unidade.getCodigo() == null) {
			unidade.setDataCadastro(Calendar.getInstance());
		}
		
		return this.unidades.salvar(unidade);
		
	}

}
