/**
 * @author Jorge marinho on 25 de dez de 2019
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

import com.jm.educacao.model.Turma;
import com.jm.educacao.repository.Turmas;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaTurmaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Turma> turmas = new ArrayList<>();
	private Turma turmaSelecionada;
	@Inject
	private Turmas turmasRep;
	
	public void excluir() {
		
		try {
			this.turmasRep.excluir(turmaSelecionada);
			this.turmas.remove(turmaSelecionada);
			FacesUtil.addInfoMessage("Excluido com sucesso !");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		
	}
	
	
	@PostConstruct
	public void buscarTodos() {
		this.turmas = turmasRep.buscarTodos();
	}
	
	public Turma getTurmaSelecionada() {
		return turmaSelecionada;
	}
	public void setTurmaSelecionada(Turma turmaSelecionada) {
		this.turmaSelecionada = turmaSelecionada;
	}
	public List<Turma> getTurmas() {
		return turmas;
	}
	
	
	
	

}
