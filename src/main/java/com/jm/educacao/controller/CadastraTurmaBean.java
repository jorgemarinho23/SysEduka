/**
 * @author Jorge marinho on 24 de dez de 2019
 *
 * 
 */
package com.jm.educacao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jm.educacao.model.Curso;
import com.jm.educacao.model.Turma;
import com.jm.educacao.model.Turno;
import com.jm.educacao.repository.Cursos;
import com.jm.educacao.service.CadastraTurmaService;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastraTurmaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Turma turma;
	private List<Turno> turnos;
	private List<Curso> cursos = new ArrayList<>();
	
	@Inject
	private CadastraTurmaService turmaService;
	@Inject
	private Cursos cursosRep;
	
	public void salvar() {
		
		if (turma.getCodigo() == null) {
			
			try {
				this.turma = turmaService.salvar(turma);
				FacesUtil.addInfoMessage("Salvo com sucesso !");
				this.limpar();
			} catch (NegocioException e) {
				FacesUtil.addErrorMessage(e.getMessage());
			}
			
		}else {
			try {
				this.turma = turmaService.salvar(turma);
				FacesUtil.addInfoMessage("Atualizado com sucesso !");
				
			} catch (NegocioException e) {
				FacesUtil.addErrorMessage(e.getMessage());
			}
		}

	}
	
	@PostConstruct
	public void init() {
		this.limpar();
		this.turnos = Arrays.asList(Turno.values());
		this.cursos = cursosRep.buscarTodos();
				
	}
	
	public void limpar() {
		this.turma = new Turma();
	}
	
	public boolean isEditando() {
		return this.turma.getCodigo() !=null;
	}
	
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public List<Curso> getCursos() {
		return cursos;
	}
	
}
