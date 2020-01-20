/**
 * @author Jorge marinho on 20 de dez de 2019
 *
 * 
 */
package com.jm.educacao.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.jm.educacao.model.Unidade;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jpa.Transactional;

public class Unidades implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	
	public Unidade salvar(Unidade unidade) {
		return this.em.merge(unidade);
		
	}


	public List<Unidade> buscarTodos() {
		
		return em.createQuery("from Unidade").getResultList();
	}


	@Transactional
	public void Excluir(Unidade unidade) throws NegocioException {
		Unidade uniTemp = em.find(Unidade.class, unidade.getCodigo());
		try {
			em.remove(uniTemp);
			em.flush();
			
		} catch (PersistenceException e) {
			throw new NegocioException("Existem registros dependentes localizados");
		}
		
	}


	public Unidade porCodigo(Long codigo) {

		return em.find(Unidade.class, codigo);
	}

}
