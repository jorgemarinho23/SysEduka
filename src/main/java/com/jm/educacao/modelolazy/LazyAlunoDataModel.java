/**
 * @author Jorge marinho on 4 de jan de 2020
 *
 * 
 */
package com.jm.educacao.modelolazy;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.jm.educacao.model.Aluno;
import com.jm.educacao.repository.Alunos;

public class LazyAlunoDataModel extends LazyDataModel<Aluno> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Alunos alunos;
	private Map<String, String> parametros;
	
	public LazyAlunoDataModel(Alunos alunos, Map<String, String> parametros) {
		this.alunos = alunos;
		this.parametros = parametros;
	}
	
	
	@Override
	public List<Aluno> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map <String, String> filtros) {

		filtros = parametros;
		
		if (filtros == null) {
			List<Aluno> alunosList = alunos.buscarComPaginacao(first,pageSize); 
			
			this.setRowCount(this.alunos.encontrarQuantidadeAlunos().intValue());
			
			return alunosList;
		}else { 
			
			List<Aluno> alunosListParam = alunos.buscarComPaginacao(first,pageSize,filtros.get("nome"));
			
			this.setRowCount(this.alunos.encontrarQuantidadeAlunos().intValue());
			
			System.out.println(filtros.get("nome"));
			return alunosListParam;
			
		}
		
	
	}
	
	

}
