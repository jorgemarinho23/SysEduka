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

import com.jm.educacao.model.Disciplina;
import com.jm.educacao.repository.Disciplinas;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaDisciplinaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Disciplina> disciplinas = new ArrayList<>();
	private Disciplina disciplinaSelecionada;
	private String descricao;
	@Inject
	private Disciplinas disciplinasRep;
	
	
	public void excluir() {
		
		this.disciplinasRep.Excluir(disciplinaSelecionada);
		this.disciplinas.remove(disciplinaSelecionada);
		FacesUtil.addInfoMessage("Excluido com sucesso !");
	}
	
	@PostConstruct
	public void buscarTodos() {
		this.disciplinas = disciplinasRep.buscarTodos();
	}
	
	public void buscarPorNome() {
		this.disciplinas = disciplinasRep.buscarPorNome(this.descricao);
	}
	
	public Disciplina getDisciplinaSelecionada() {
		return disciplinaSelecionada;
	}
	public void setDisciplinaSelecionada(Disciplina disciplinaSelecionada) {
		this.disciplinaSelecionada = disciplinaSelecionada;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
 
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
