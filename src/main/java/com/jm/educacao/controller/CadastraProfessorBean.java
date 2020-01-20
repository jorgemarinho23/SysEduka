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

import com.jm.educacao.model.Professor;
import com.jm.educacao.service.CadastraProfessorService;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastraProfessorBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Professor professor;
	
	@Inject
	private CadastraProfessorService professorService;
	
	public CadastraProfessorBean() {
		
	}
	

	public void salvar() {
	if (professor.getCodigo() !=  null) {
		
		try {
			this.professor = professorService.salvar(this.professor);
			System.out.println(professor.getNome());
			FacesUtil.addInfoMessage("Atualizado com sucesso !");
			
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}

	}else {
		try {
			this.professor = professorService.salvar(this.professor);
			System.out.println(professor.getNome());
			FacesUtil.addInfoMessage("Salvo com sucesso !");
			
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		
		this.limpar();
	}
	
	}
	
	public boolean isEditando(){
		return this.professor.getCodigo() !=  null;
	}
	
	
	@PostConstruct
	public void init() {
		this.limpar();
	}
	
	public void limpar() {
		this.professor = new Professor();
	}

	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
