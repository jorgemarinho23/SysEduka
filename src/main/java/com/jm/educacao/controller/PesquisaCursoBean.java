package com.jm.educacao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jm.educacao.model.Curso;
import com.jm.educacao.repository.Cursos;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaCursoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Curso> cursos = new ArrayList<>();
	private Curso cursoSelecionado;
	
	@Inject
	private Cursos cursosRep;
	
	public void excluir() {
		try {
			this.cursosRep.Excluir(cursoSelecionado);
			this.cursos.remove(cursoSelecionado);
			FacesUtil.addInfoMessage("Excluido com sucesso !");
			
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
	}

	@PostConstruct
	public void buscarTodos() {
		this.cursos = cursosRep.buscarTodos();
	}
	
	public Curso getCursoSelecionado() {
		return cursoSelecionado;
	}
	/**
	 * @param cursoSelecionado the cursoSelecionado to set
	 */
	public void setCursoSelecionado(Curso cursoSelecionado) {
		this.cursoSelecionado = cursoSelecionado;
	}
	/**
	 * @return the cursos
	 */
	public List<Curso> getCursos() {
		return cursos;
	}

}
