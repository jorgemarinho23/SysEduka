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
import com.jm.educacao.model.Unidade;
import com.jm.educacao.repository.Unidades;
import com.jm.educacao.service.CadastraSalaService;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastraSalaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Sala sala;
	private List<Unidade> unidades = new ArrayList<>();

	@Inject
	private CadastraSalaService salaService;
	@Inject
	private Unidades unidadesRep;
	
	public void salvar() {
		
		if (sala.getCodigo() == null) {
			
			try {
				
				this.sala = salaService.salvar(sala);
				FacesUtil.addInfoMessage("Salvo com sucesso !");
				this.limpar();
				
			} catch (NegocioException e) {
				FacesUtil.addErrorMessage(e.getMessage());
			}
			
		}else {
			try {
				
				this.sala = salaService.salvar(sala);
				FacesUtil.addInfoMessage("Atualizado com sucesso !");
				
				
			} catch (NegocioException e) {
				FacesUtil.addErrorMessage(e.getMessage());
			}
		}
		
		
		
	}
	
	
	@PostConstruct
	public void init() {
		this.limpar();
	}
	
	public void limpar() {
		this.sala = new Sala();
		this.unidades = unidadesRep.buscarTodos();
	}
	
	public boolean isEditando() {
		return this.sala.getCodigo() != null;
	}
	
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public List<Unidade> getUnidades() {
		return unidades;
	}
	

}
