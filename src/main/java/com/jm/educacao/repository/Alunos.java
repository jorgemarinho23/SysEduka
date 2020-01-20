package com.jm.educacao.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.jm.educacao.model.Aluno;
import com.jm.educacao.model.Turma;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jpa.Transactional;

public class Alunos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
@Inject
private EntityManager em;

public Aluno salvar(Aluno aluno) {
	 return this.em.merge(aluno);
}

public List<Aluno> buscarTodos() {
	// TODO Auto-generated method stub
	return em.createQuery("from Aluno").getResultList();
}


@Transactional
public void Excluir(Aluno alunoSelecionado) throws NegocioException {
	
	Aluno Alunotemp= em.find(Aluno.class, alunoSelecionado.getCodigo());

	try {
		em.remove(Alunotemp);
		em.flush();
	} catch (PersistenceException e) {
		throw new NegocioException("Existem registros dependentes localizados");
	}
	

	
}

public Aluno porId(Long codigo) {
	
	return this.em.find(Aluno.class, codigo);
}



public List<Aluno> PorNome(String nome) {
	
	return em.createQuery("from Aluno where upper(nome) like :nome",Aluno.class)
	.setParameter("nome", nome.toUpperCase() + "%").getResultList();
}

@SuppressWarnings("unchecked")
public List<Aluno> buscarComPaginacao(int first, int pageSize) {
	return em.createQuery("from Aluno")
	.setFirstResult(first)
	.setMaxResults(pageSize)
	.getResultList();
}

public Long encontrarQuantidadeAlunos() {
	
	return em.createQuery("select count(a) from Aluno a",Long.class).getSingleResult();
}



public List<Aluno> buscarPorTurma(Turma turma) {
	return em.createQuery("from Aluno where matricula.turma = :turma ",Aluno.class)
			.setParameter("turma", turma).getResultList();	
}



public List<Aluno> buscarComPaginacao(int first, int pageSize, String filtro) {
	return em.createQuery("from Aluno where upper(nome) like :filtro ")
			.setFirstResult(first)
			.setMaxResults(pageSize)
			.setParameter("filtro", filtro.toUpperCase() +"%")
			.getResultList();
}



}
