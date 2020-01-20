package com.jm.educacao.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jm.educacao.model.Professor;
import com.jm.educacao.repository.Professores;
import com.jm.educacao.util.jpa.Transactional;



public class CadastraProfessorService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private Professores professores;
	
	@Transactional
	public Professor salvar(Professor professor) throws NegocioException {
		
		if (professor.getNome() == null || professor.getNome().trim().equals("")) {
			
			throw new NegocioException("Nome obrigatório !");
		}
		
		return this.professores.salvar(professor);
		
	}

}
