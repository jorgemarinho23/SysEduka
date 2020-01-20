package com.jm.educacao.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;

import com.jm.educacao.model.Curso;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jpa.Transactional;
import com.jm.educacao.util.jsf.FacesUtil;

public class Cursos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private EntityManager em;
	
	public Curso salvar(Curso curso) {
		return this.em.merge(curso);
		
	}

	@Transactional
	public void Excluir(Curso curso) throws NegocioException {
		Curso cursotemp = this.em.find(Curso.class, curso.getCodigo());
		try {
			em.remove(cursotemp);
			em.flush();
			
			
		} catch (PersistenceException e) {
		throw	new NegocioException("Existem registros dependentes localizados");
		}
		
	}

	public List<Curso> buscarTodos() {
		
		return em.createQuery("from Curso").getResultList();
	}

	public Curso porCodigo(Long codigo) {
		
		return em.find(Curso.class, codigo);
	}

}
