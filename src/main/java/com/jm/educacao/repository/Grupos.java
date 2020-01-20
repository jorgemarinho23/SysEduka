/**
 * @author Jorge marinho on 30 de dez de 2019
 *
 * 
 */
package com.jm.educacao.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jm.educacao.model.Grupo;

public class Grupos implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager em;
	
	
	
	
	public List<Grupo> buscarTodos() {
		
		return em.createQuery("from Grupo").getResultList();
	}


	public Grupo porCodigo(Long codigo) {
		
		return em.find(Grupo.class, codigo);
	}

}
