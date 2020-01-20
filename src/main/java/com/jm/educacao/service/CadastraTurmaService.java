/**
 * @author Jorge marinho on 24 de dez de 2019
 *
 * 
 */
package com.jm.educacao.service;

import java.io.Serializable;
import java.util.Calendar;

import javax.inject.Inject;

import com.jm.educacao.model.Turma;
import com.jm.educacao.repository.Turmas;
import com.jm.educacao.util.jpa.Transactional;

public class CadastraTurmaService implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private Turmas turmas;
	
	@Transactional
	public Turma salvar(Turma turma) throws NegocioException{
		
		if (turma.getDescricao() == null || turma.getDescricao().trim().equals("")) {
			
			throw new NegocioException("Descrição obrigatória !");
			
		}
		
		if (turma.getCodigo() == null) {
			turma.setDataCadastro(Calendar.getInstance());
		}
		
		if (turma.getHoraFim().getHours() < turma.getHoraInicio().getHours()) {
			
			throw new NegocioException("Hora final não pode ser menor que a inicial");
		}
		

		
		return this.turmas.salvar(turma);
		
	}

}
