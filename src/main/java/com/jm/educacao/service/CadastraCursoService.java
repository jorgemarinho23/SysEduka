package com.jm.educacao.service;

import java.io.Serializable;
import java.util.Calendar;

import javax.inject.Inject;

import com.jm.educacao.model.Curso;
import com.jm.educacao.repository.Cursos;
import com.jm.educacao.util.jpa.Transactional;

public class CadastraCursoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cursos cursos;
	
	@Transactional
	public Curso salvar(Curso curso)  throws NegocioException {

		if (curso.getNome() == null || curso.getNome().trim().equals("")) {
			
			new NegocioException("Nome obrigatório");
			
		}
		
		if (curso.getCodigo() == null) {
			curso.setDataCadastro(Calendar.getInstance());
		}
		
		return cursos.salvar(curso);
		
	}

}
