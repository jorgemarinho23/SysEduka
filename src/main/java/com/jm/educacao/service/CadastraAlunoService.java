package com.jm.educacao.service;

import java.io.Serializable;

import javax.inject.Inject;


import com.jm.educacao.model.Aluno;
import com.jm.educacao.repository.Alunos;
import com.jm.educacao.util.jpa.Transactional;



public class CadastraAlunoService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private Alunos alunos;
	
	@Transactional
	public Aluno salvar(Aluno aluno) throws NegocioException {
		
		if (aluno.getNome() == null || aluno.getNome().trim().equals("")) {
			
		throw new NegocioException("Nome do aluno obrigatorio");
			
		}

		return alunos.salvar(aluno);
		
	}

}
