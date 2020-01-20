/**
 * @author Jorge marinho on 24 de dez de 2019
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

import com.jm.educacao.model.Matricula;
import com.jm.educacao.repository.Matriculas;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaMatriculaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Matricula> matriculas = new ArrayList<>();
	
	private Matricula matriculaSelecionada;
	
	@Inject
	private Matriculas matriculasRep;
	
	public void excluir() {
		this.matriculasRep.Excluir(matriculaSelecionada);
		this.matriculas.remove(matriculaSelecionada);
		FacesUtil.addInfoMessage("Matricula do aluno "
		+matriculaSelecionada.getAluno().getNome()+" excluida com sucesso !");
	}
	
	
	
	@PostConstruct
	public void buscarTodos() { 
		this.matriculas = matriculasRep.buscarTodos();
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public Matricula getMatriculaSelecionada() {
		return matriculaSelecionada;
	}

	public void setMatriculaSelecionada(Matricula matriculaSelecionada) {
		this.matriculaSelecionada = matriculaSelecionada;
	}
	
	

}
