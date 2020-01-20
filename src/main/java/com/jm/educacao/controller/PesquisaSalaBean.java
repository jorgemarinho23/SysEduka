/**
 * @author Jorge marinho on 27 de dez de 2019
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

import com.jm.educacao.model.Sala;
import com.jm.educacao.repository.Salas;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaSalaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Sala> salas = new ArrayList<>();
	private Sala salaSelecionada;
	@Inject
	private Salas salasRep;
	
	public void excluir() { 
		this.salasRep.Excluir(salaSelecionada);
		this.salas.remove(salaSelecionada);
		FacesUtil.addInfoMessage("Excluido com sucesso !");
	}
	
	@PostConstruct
	public void buscarTodos() {
		this.salas = salasRep.buscaTodos();
	}
	
	
	public Sala getSalaSelecionada() {
		return salaSelecionada;
	}
	public void setSalaSelecionada(Sala salaSelecionada) {
		this.salaSelecionada = salaSelecionada;
	}
	public List<Sala> getSalas() {
		return salas;
	}
	

}
