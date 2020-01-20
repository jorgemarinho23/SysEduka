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

import com.jm.educacao.model.Cordenador;
import com.jm.educacao.repository.Cordenadores;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaCordenadorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Cordenador> cordenadores = new ArrayList<>();
	private Cordenador cordenadorSelecionado;
	private String nome;
	@Inject
	private Cordenadores cordenadoresRep;
	
	public void excluir() {
		
		try {
			this.cordenadoresRep.Excluir(cordenadorSelecionado);
			this.cordenadores.remove(cordenadorSelecionado);
			FacesUtil.addInfoMessage("Excluido com sucesso !");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
	}
	
	
	@PostConstruct
	public void buscarTodos() { 
		this.cordenadores = cordenadoresRep.buscarTodos();
	}
	
	public void buscarPorNome() {
		this.cordenadores = cordenadoresRep.buscarPorNome(this.nome);
	}
	
	
	public Cordenador getCordenadorSelecionado() {
		return cordenadorSelecionado;
	}
	public void setCordenadorSelecionado(Cordenador cordenadorSelecionado) {
		this.cordenadorSelecionado = cordenadorSelecionado;
	}
	public List<Cordenador> getCordenadores() {
		return cordenadores;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}                                    
	
	
	

}
