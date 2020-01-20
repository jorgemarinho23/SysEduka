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

import com.jm.educacao.model.Unidade;
import com.jm.educacao.repository.Unidades;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaUnidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Unidade> unidades = new ArrayList<>();
	private Unidade unidadeSelesionada; 
	
	@Inject
	private Unidades unidadesRep;
	
	public void excluir() {
		
		try {
			this.unidadesRep.Excluir(unidadeSelesionada);
			this.unidades.remove(unidadeSelesionada);
			FacesUtil.addInfoMessage("Excluido com sucesso !");
			
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
	}
	
	
	@PostConstruct
	public void buscarTodos() {
		this.unidades = unidadesRep.buscarTodos();
	}

	public Unidade getUnidadeSelesionada() {
		return unidadeSelesionada;
	}

	public void setUnidadeSelesionada(Unidade unidadeSelesionada) {
		this.unidadeSelesionada = unidadeSelesionada;
	}

	public List<Unidade> getUnidades() {
		return unidades;
	}
	
	
	

}
