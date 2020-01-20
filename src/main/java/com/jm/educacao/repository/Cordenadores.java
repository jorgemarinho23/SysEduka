/**
 * @author Jorge marinho on 25 de dez de 2019
 *
 * 
 */
package com.jm.educacao.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.jm.educacao.model.Cordenador;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jpa.Transactional;

public class Cordenadores implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public Cordenador salvar(Cordenador cordenador) {
		return em.merge(cordenador);
	}

	public List<Cordenador> buscarTodos() {
		
		return em.createQuery("from Cordenador").getResultList();
	}

	@Transactional
	public void Excluir(Cordenador cordenador) {
	
		Cordenador corTemp = em.find(Cordenador.class, cordenador.getCodigo());
		try {
			em.remove(corTemp);
	        em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Existem registros dependentes localizados");
		}
				
	}

	public Cordenador porCodigo(Long codigo) {
		
		return em.find(Cordenador.class, codigo);
	}

	public List<Cordenador> buscarPorNome(String nome) {
		
		return em.createQuery("from Cordenador where upper(nome) like :nome",Cordenador.class)
		.setParameter("nome", nome.toUpperCase() + "%").getResultList();		
	}

}
