/**
 * @author Jorge marinho on 24 de dez de 2019
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

import com.jm.educacao.model.Aluno;
import com.jm.educacao.model.Matricula;
import com.jm.educacao.model.Turma;
import com.jm.educacao.repository.Alunos;
import com.jm.educacao.repository.Turmas;
import com.jm.educacao.service.CadastraMatriculaService;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastraMatriculaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Matricula matricula;
	private List<Aluno> alunos = new ArrayList<>();
	private List<Turma> turmas = new ArrayList<>();
	
	@Inject
	private CadastraMatriculaService matriculaService;
	@Inject
	private Alunos alunosRep;
	@Inject
	private Turmas turmasRep;
	
	public CadastraMatriculaBean() {
		
	}
	
	public void salvar() {
		
		if (matricula.getCodigo() == null) {
			try {
				this.matricula = matriculaService.salvar(matricula);
				FacesUtil.addInfoMessage("Salvo com sucesso !");
				this.limpar();
				
			} catch (NegocioException e) {
				FacesUtil.addErrorMessage(e.getMessage());
			}
			
		}else {
			try {
				this.matricula = matriculaService.salvar(matricula);
				FacesUtil.addInfoMessage("Atualizado com sucesso !");
				
				
			} catch (NegocioException e) {
				FacesUtil.addErrorMessage(e.getMessage());
			}
			
		}
}
		
	
	@PostConstruct
	public void init() {
		this.limpar();
		this.alunos = alunosRep.buscarTodos();
		this.turmas = turmasRep.buscarTodos();
	}
	
	public void limpar() {
		this.matricula = new Matricula();
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	
	public List<Turma> getTurmas() {
		return turmas;
	}

	public boolean isCampoeditavel() {
		return matricula.getCodigo() != null;
		
	}
	
	public boolean isEditando() {
		return this.matricula.getCodigo() != null;
	}


}
