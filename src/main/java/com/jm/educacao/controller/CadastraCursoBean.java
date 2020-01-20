/**
 * @author Jorge marinho on 20 de dez de 2019
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

import com.jm.educacao.model.Cordenador;
import com.jm.educacao.model.Curso;
import com.jm.educacao.model.Nivel;
import com.jm.educacao.model.Unidade;
import com.jm.educacao.repository.Cordenadores;
import com.jm.educacao.repository.Unidades;
import com.jm.educacao.service.CadastraCursoService;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastraCursoBean implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	private Curso curso;
	private List<Nivel> niveis;
	private List<Cordenador> Cordenadores = new ArrayList<>();
	private List<Unidade> unidades = new ArrayList<>();
	
	@Inject
	private CadastraCursoService cursoService;
	@Inject
	private Cordenadores cordenadoresRep; 
	@Inject
	private Unidades unidadesRep;

	public  CadastraCursoBean() {
		
	}
	
    public void salvar() {
    	
    	if (curso.getCodigo() == null) {
    		
    		   try {
    			   
    			   this.curso = this.cursoService.salvar(this.curso);
    			   FacesUtil.addInfoMessage("Salvo com sucesso !");
    			   System.out.println(curso.getNome());
    			   this.limpar();
    			
    		} catch (NegocioException e) {
    			FacesUtil.addErrorMessage(e.getMessage());
    		}
			
		}else {
			   try {
				   
				   this.curso = this.cursoService.salvar(this.curso);
				   FacesUtil.addInfoMessage("Atualizado com sucesso !");
				   System.out.println(curso.getNome());
				   
				
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
		this.curso = new Curso();
		this.niveis = Arrays.asList(Nivel.values());
		this.Cordenadores = cordenadoresRep.buscarTodos();
		this.unidades = unidadesRep.buscarTodos();
	}
	
	public boolean isEditando() {
		return this.curso.getCodigo() != null;
	}
	
	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	public List<Nivel> getNiveis() {
		return niveis;
	}

	public List<Cordenador> getCordenadores() {
		return Cordenadores;
	}

	public List<Unidade> getUnidades() {
		return unidades;
	}

    
	

}
