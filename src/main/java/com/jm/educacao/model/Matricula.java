/**
 * @author Jorge marinho on 24 de dez de 2019
 *
 * 
 */
package com.jm.educacao.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Matricula implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	@NotNull
	private Aluno aluno;
	@NotNull
	private Turma turma;
	private Calendar dataCadastro;
	
	@Id
	@GeneratedValue
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@OneToOne
	@JoinColumn(name ="codigo_aluno")
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@ManyToOne
	@JoinColumn(name="codigo_turma")
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	@Temporal(TemporalType.DATE)
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

	
	
	

}
