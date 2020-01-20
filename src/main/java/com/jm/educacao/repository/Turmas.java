/**
 * @author Jorge marinho on 24 de dez de 2019
 *
 * 
 */
package com.jm.educacao.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.jm.educacao.model.Turma;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jpa.Transactional;

public class Turmas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public Turma salvar(Turma turma) {
		return this.em.merge(turma);
	}

	public List<Turma> buscarTodos() {
		
		return em.createQuery("from Turma").getResultList();
	}

	@Transactional
	public void excluir(Turma turma) throws NegocioException{
		
		Turma turTemp = em.find(Turma.class, turma.getCodigo());
		try {
			em.remove(turTemp);
			em.flush();	
		} catch (PersistenceException e) {
			throw new NegocioException("Existem registros dependentes localizados");
		}
	
	}

	public Turma porCodigo(Long codigo) {
		
		return em.find(Turma.class, codigo);
	}

}
