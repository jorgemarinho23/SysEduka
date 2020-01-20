package com.jm.educacao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jm.educacao.model.Aluno;
import com.jm.educacao.modelolazy.LazyAlunoDataModel;
import com.jm.educacao.repository.Alunos;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaAlunoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Aluno> alunos = new ArrayList<>();
	
	private LazyAlunoDataModel alunoDataModel;
	
	private Aluno alunoSelecionado;
	
	@Inject
	 private Alunos alunosRep;
	
	 private String nome;
	
	 
	

public void excluir() {
	try {
		this.alunosRep.Excluir(alunoSelecionado);
		FacesUtil.addInfoMessage("Aluno "+alunoSelecionado.getNome()+" excluido com sucesso !");
		this.alunos.remove(alunoSelecionado);
	} catch (NegocioException e) {
		FacesUtil.addErrorMessage(e.getMessage());
	}
	
}
	
	
 @PostConstruct
 public void buscarTodos() {
	//this.alunos = alunosRep.buscarTodos();
	 
	 alunoDataModel = new LazyAlunoDataModel(alunosRep,null);
		
	}

 public void buscarPorNome() {
	 Map<String, String> parametros = new HashMap<String, String>();
	 parametros.put("nome", nome);
	 alunoDataModel = new LazyAlunoDataModel(alunosRep,parametros);

 }

public Aluno getAlunoSelecionado() {
	return alunoSelecionado;
}


public void setAlunoSelecionado(Aluno alunoSelecionado) {
	this.alunoSelecionado = alunoSelecionado;
}


public List<Aluno> getAlunos() {
	return alunos;
}


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}


public LazyAlunoDataModel getAlunoDataModel() {
	return alunoDataModel;
}


}
