/**
 * @author Jorge marinho on 6 de jan de 2020
 *
 * 
 */
package com.jm.educacao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.jm.educacao.model.Aluno;
import com.jm.educacao.model.Curso;
import com.jm.educacao.model.Turma;
import com.jm.educacao.repository.Alunos;
import com.jm.educacao.repository.Cursos;
import com.jm.educacao.repository.Turmas;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class RelatorioAlunoPorTurmaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Aluno> alunos = new ArrayList<>();
	private List<Turma> turmas;
	private Turma turma;
	@Inject
	private Alunos alunosRep;
	@Inject
	private Turmas turmasRep;
	
	
	public void executar() {
		if (turma ==null) {
			FacesUtil.addErrorMessage("Seleciona a turma");
		}
		this.alunos = alunosRep.buscarPorTurma(turma);
	}

	@PostConstruct
	public void iniciar() {
		this.turmas = turmasRep.buscarTodos();
	}




	public List<Aluno> getAlunos() {
		return alunos;
	}
	@NotNull
	public Turma getTurma() {
		return turma;
	}

	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}


  
	
	
}
