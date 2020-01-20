/**
 * @author Jorge marinho on 20 de dez de 2019
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

import com.jm.educacao.model.Professor;
import com.jm.educacao.repository.Professores;

@Named
@ViewScoped
public class PesquisaProfessorBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Professor> professores = new ArrayList<>();
	
	private Professor professorSelecionado;
	private String nome;
	
	@Inject
	private Professores professoresRep;
	
	
	public void excluir() {
		this.professoresRep.Excluir(professorSelecionado);
		this.professores.remove(professorSelecionado);
	}


@PostConstruct
 public void buscarTodos() {
	 this.professores = professoresRep.buscarTodos();
 }

public void buscarPorNome() {
	this.professores = professoresRep.buscarPorNome(this.nome);
}
	
	public Professor getProfessorSelecionado() {
		return professorSelecionado;
	}


	public void setProfessorSelecionado(Professor professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}


	public List<Professor> getProfessores() {
		return professores;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
