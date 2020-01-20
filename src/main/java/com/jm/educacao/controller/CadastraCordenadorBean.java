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
import com.jm.educacao.service.CadastraCordenadorService;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jsf.FacesUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;



@Named
@ViewScoped
public class CadastraCordenadorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Cordenador cordenador;
	private List<Cordenador> cordenadores = new ArrayList<>();
	private String cep;
	@Inject
	private CadastraCordenadorService cordenadorService;
	
	public void salvar() {
		
		if (cordenador.getCodigo() == null) {
			
			try {
				
				this.cordenador = cordenadorService.salvar(cordenador);
				FacesUtil.addInfoMessage("Cadastrado com sucesso !");
				this.limpar();
				this.cep = null;
				
			} catch (NegocioException e) {
				FacesUtil.addErrorMessage(e.getMessage());
			}
			
		}else {
	       try {
				
				this.cordenador = cordenadorService.salvar(cordenador);
				FacesUtil.addInfoMessage("Atualizado com sucesso !");
				
				
			} catch (NegocioException e) {
				FacesUtil.addErrorMessage(e.getMessage());
			}
		}
		
	
		
	}
	
	public Cordenador carregarEndereco() {
		
		 System.out.println("codigo: "+cordenador.getCodigo());
		try {
			 cep = cordenador.getCep();
			Client c = Client.create();
			WebResource wr = c.resource("http://viacep.com.br/ws/" + this.cep + "/json/");
			System.out.println("CHAMOU O URI....");
			
			this.cordenador = cordenadorService.buscarEnderecoPor(wr.get(String.class));
			String JSON = wr.get(String.class);
			System.out.println(JSON);
			System.out.println("codigo: "+cordenador.getCodigo());
			
		} catch (UniformInterfaceException e) {
			FacesUtil.addErrorMessage("Cep não encontrado");
			System.out.println(this.cordenador.getCodigo());
		}
		
		
		return cordenador;

	}
	
	public boolean isEditando() {
		return this.cordenador.getCodigo() != null;
		
	}
	
	@PostConstruct
	public void init() {
		this.limpar();
	}
	
	public void limpar() {
		this.cordenador = new  Cordenador();
	}

	public Cordenador getCordenador() {
		return cordenador;
	}
	public void setCordenador(Cordenador cordenador) {
		this.cordenador = cordenador;
	}

	public List<Cordenador> getCordenadores() {
		return cordenadores;
	}

	public void setCordenadores(List<Cordenador> cordenadores) {
		this.cordenadores = cordenadores;
	}
	/*
    @NotNull
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	*/
	

}
