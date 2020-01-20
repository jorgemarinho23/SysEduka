/**
 * @author Jorge marinho on 7 de jan de 2020
 *
 * 
 */
package com.jm.educacao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import org.hibernate.Session;

import com.jm.educacao.model.Turma;
import com.jm.educacao.repository.Turmas;
import com.jm.educacao.util.jsf.FacesUtil;
import com.jm.educacao.util.report.ExecutorRelatorio;
import com.mysql.jdbc.Connection;

@Named
@RequestScoped
public class RelAlunoTurmaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Turma> turmas = new ArrayList<>();
	private Turma turma;
	@Inject
	private Turmas turmasRep;
	@Inject
	private FacesContext facesContext;
	@Inject
	private HttpServletResponse response;
	@Inject
	private EntityManager manager;
	
	public void emitir() {	
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		parametros.put("nome_turma", turma.getDescricao());
		ExecutorRelatorio executor= new ExecutorRelatorio("/relatorios/relatorio_aluno_turma.jasper",
				this.response,parametros,"Alunos por turma.pdf");
		
		Session session = manager.unwrap(Session.class);
		session.doWork(executor);
		
		if (executor.isRelatorioGerado()) {
			facesContext.responseComplete();
		}else {
			FacesUtil.addErrorMessage("A execução do relatório não retornou dados !");
		}
		
		
		
	}
	
	
	@PostConstruct
	public void iniciar() {
		this.turmas = turmasRep.buscarTodos();
	}
	
	@NotNull
	public Turma getTurma() {
		return turma;
	}

	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}


}
