/**
 * @author Jorge marinho on 24 de dez de 2019
 *
 * 
 */
package com.jm.educacao.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private String Descricao;
	@NotNull
	private Turno turno;
	private Calendar dataCadastro;
	private Date HoraInicio;
	private Date HoraFim;
	@NotNull
	private Curso curso;
	private int capacidade;
	
	@Id
	@GeneratedValue
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@NotBlank
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
	
	@Enumerated(EnumType.STRING)
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
	
	@Temporal(TemporalType.DATE)
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	@NotNull
	@Temporal(TemporalType.TIME)
	public Date getHoraInicio() {
		return HoraInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		HoraInicio = horaInicio;
	}
	@NotNull
	@Temporal(TemporalType.TIME)
	public Date getHoraFim() {
		return HoraFim;
	}
	public void setHoraFim(Date horaFim) {
		HoraFim = horaFim;
	}
	
	@ManyToOne
	@JoinColumn(name="codigo_curso")
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
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
		Turma other = (Turma) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	
	
	

}
