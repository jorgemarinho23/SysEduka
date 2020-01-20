/**
 * @author Jorge marinho on 24 de dez de 2019
 *
 * 
 */
package com.jm.educacao.service;

import java.io.Serializable;
import java.util.Calendar;

import javax.inject.Inject;

import com.jm.educacao.model.Matricula;
import com.jm.educacao.repository.Matriculas;
import com.jm.educacao.util.jpa.Transactional;

public class CadastraMatriculaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Matriculas matriculas;
	
	@Transactional
	public Matricula salvar(Matricula matricula) throws NegocioException {
		
		if (matricula.getAluno() == null || matricula.getAluno().equals("")) {
			
			throw new NegocioException("Aluno obrigatório!");
		}
		
		if (matricula.getCodigo() == null) {
			
			String verificaCadastro = matriculas.porCpf(matricula.getAluno().getCpf()); 
			
			System.out.println(verificaCadastro);
			
			if (matricula.getAluno().getCpf().equals(verificaCadastro)) {
				
				throw new NegocioException("Cpf já matriculado");
			}
			
			matricula.setDataCadastro(Calendar.getInstance());
		}
		
		return this.matriculas.salvar(matricula);
		
	}

}
