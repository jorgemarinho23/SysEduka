package com.jm.educacao.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jm.educacao.model.Professor;
import com.jm.educacao.util.jpa.Transactional;

public class Professores implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public Professor salvar(Professor professor) {
		return this.em.merge(professor);
		
	}

	public List<Professor> buscarTodos() {
		
		return em.createQuery("from Professor").getResultList();
	}

	@Transactional
	public void Excluir(Professor professorSelecionado) {
		
		Professor ProTemp = em.find(Professor.class, professorSelecionado.getCodigo());
		
		em.remove(ProTemp);
		em.flush();
	}

	public Professor porCodigo(Long codigo) {
		
		return em.find(Professor.class, codigo);
	}

	public List<Professor> buscarPorNome(String nome) {
		
		return em.createQuery("from Professor where upper(nome) like :nome",Professor.class)
		.setParameter("nome", nome.toUpperCase() + "%").getResultList();		
	}

}
