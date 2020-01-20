/**
 * @author Jorge marinho on 27 de dez de 2019
 *
 * 
 */
package com.jm.educacao.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jm.educacao.model.Sala;
import com.jm.educacao.util.jpa.Transactional;

public class Salas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public Sala salvar(Sala sala) {
		return em.merge(sala);
		
	}

	@SuppressWarnings("unchecked")
	public List<Sala> buscaTodos() {
		
		return em.createQuery("from Sala").getResultList();
	}

	@Transactional
	public void Excluir(Sala sala) {
		
		Sala salTemp = em.find(Sala.class, sala.getCodigo());
		
		em.remove(salTemp);
        em.flush();		
	}

	public Sala porCodigo(Long codigo) {
		
		return em.find(Sala.class, codigo);
	}

}
