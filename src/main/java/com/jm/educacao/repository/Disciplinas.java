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

import com.jm.educacao.model.Disciplina;
import com.jm.educacao.util.jpa.Transactional;

public class Disciplinas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	
	public Disciplina salvar(Disciplina disciplina) {
		return this.em.merge(disciplina);
	}


	public List<Disciplina> buscarTodos() {
		
		return this.em.createQuery("from Disciplina").getResultList();
	}

    @Transactional
	public void Excluir(Disciplina disciplina) {
		
		Disciplina discTemp = em.find(Disciplina.class, disciplina.getCodigo());
		
		em.remove(discTemp);
		em.flush();
	}


	public Disciplina porCodigo(Long codigo) {
		
		return em.find(Disciplina.class, codigo);
	}


	public List<Disciplina> buscarPorNome(String descricao) {
		
		return em.createQuery("from Disciplina where upper(descricao) like :descricao",Disciplina.class)
		.setParameter("descricao", descricao.toUpperCase() + "%").getResultList();		
	}

}
