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

import com.jm.educacao.model.Disciplina;
import com.jm.educacao.service.CadastraDisciplinaService;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastraDisciplinaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Disciplina disciplina;
	
	@Inject
	private CadastraDisciplinaService disciplinaService;
	
	
	public void salvar() {
		
		if (disciplina.getCodigo() == null) {
			
			try {
				this.disciplina =disciplinaService.salvar(disciplina);
				FacesUtil.addInfoMessage("Salvo com sucesso !");
				this.limpar();
			} catch (NegocioException e) {
				FacesUtil.addErrorMessage(e.getMessage());
			}
			
		}else {
			try {
				this.disciplina =disciplinaService.salvar(disciplina);
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
		this.disciplina = new Disciplina();
	}
 
	public boolean isEditando() {
		return this.disciplina.getCodigo() != null;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
