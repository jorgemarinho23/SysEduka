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

import com.jm.educacao.model.Aluno;
import com.jm.educacao.service.CadastraAlunoService;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jsf.FacesUtil;


@Named
@ViewScoped
public class CadastraAlunoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Aluno aluno = new Aluno();
	
	@Inject
	private CadastraAlunoService alunoService;
	
	public CadastraAlunoBean() {
		
	}
	
	public void salvar() {

		if (aluno.getCodigo() == null) {
			try {
				this.aluno = alunoService.salvar(this.aluno);
				FacesUtil.addInfoMessage("Cadastrado com sucesso !");
				this.limpar();
				System.out.println(this.aluno.getNome());
				
			} catch (NegocioException e) {
				FacesUtil.addErrorMessage(e.getMessage());
			}
		}else {
			try {
				this.aluno = alunoService.salvar(this.aluno);
				FacesUtil.addInfoMessage("Atualizado com sucesso !");
				System.out.println(this.aluno.getNome());
				
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
		
		this.aluno = new Aluno();
	}
	
	public boolean isEditando() {
		return this.aluno.getCodigo() != null;
		
	}

	
	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
