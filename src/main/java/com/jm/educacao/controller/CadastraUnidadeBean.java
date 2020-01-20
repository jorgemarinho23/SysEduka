/**
 * @author Jorge marinho on 20 de dez de 2019
 *
 * 
 */
package com.jm.educacao.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jm.educacao.model.Unidade;
import com.jm.educacao.service.CadastraUnidadeService;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastraUnidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Unidade unidade;
	
	@Inject
	private CadastraUnidadeService unidadeService;
	
	public CadastraUnidadeBean() {
		
	}
	
	public void salvar() {
		
		if (unidade.getCodigo() == null) {
			try {
				
				this.unidade = unidadeService.salvar(unidade);
				FacesUtil.addInfoMessage("Cadastrado com sucesso !");
				this.limpar();
				
			} catch (NegocioException e) {
				FacesUtil.addErrorMessage(e.getMessage());	
			}
		}else {
			try {
				
				this.unidade = unidadeService.salvar(unidade);
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
		this.unidade = new Unidade();
	}
	
	public boolean isEditando() {
		return this.unidade.getDataCadastro() !=null;
		
	}
	
	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
}
