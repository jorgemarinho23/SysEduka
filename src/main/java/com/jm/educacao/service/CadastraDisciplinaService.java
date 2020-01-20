/**
 * @author Jorge marinho on 20 de dez de 2019
 *
 * 
 */
package com.jm.educacao.service;

import java.io.Serializable;
import java.util.Calendar;

import javax.inject.Inject;

import com.jm.educacao.model.Disciplina;
import com.jm.educacao.repository.Disciplinas;
import com.jm.educacao.util.jpa.Transactional;

public class CadastraDisciplinaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Disciplinas disciplinas;
	
	@Transactional
	public Disciplina salvar(Disciplina disciplina) throws NegocioException {
		
		if (disciplina.getDescricao() == null || disciplina.getDescricao().trim().equals("")) {
			
			throw new NegocioException("Nome obrigatório");
			
		}
		
		if (disciplina.getCodigo() == null) {
			
		disciplina.setDataCadastro(Calendar.getInstance());
		
		}
		
		
		return this.disciplinas.salvar(disciplina);
		
	}

}
