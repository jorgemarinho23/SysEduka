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
import javax.persistence.NoResultException;

import com.jm.educacao.model.Matricula;
import com.jm.educacao.util.jpa.Transactional;

public class Matriculas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public Matricula salvar(Matricula matricula) {
		return this.em.merge(matricula);
		
	}

	public List<Matricula> buscarTodos() {
		
		return em.createQuery("from Matricula").getResultList();
	}

	public Matricula porCodigo(Long codigo) {
		
		return em.find(Matricula.class, codigo);
	}

	public String porCpf(String cpf) {
	
		try {
			return em.createQuery("select a.cpf from Matricula m JOIN m.aluno a where m.aluno.cpf = :cpf",String.class)
					.setParameter("cpf", cpf).getSingleResult();
			
		} catch (NoResultException e) {
			return null;
		}
		
				
	}

	@Transactional
	public void Excluir(Matricula matricula) {
		
		Matricula MatTemp = em.find(Matricula.class, matricula.getCodigo());
		
		em.remove(MatTemp);
		em.flush();
		
	}

	

	


}
