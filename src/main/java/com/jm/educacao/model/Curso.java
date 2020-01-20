package com.jm.educacao.model;

import java.io.Serializable;
import java.util.Calendar;


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
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	@NotBlank
	private String nome;
	@NotNull
	private Nivel nivel;
	private Calendar dataCadastro;
	@NotNull
	private Cordenador cordenador;
	@NotNull
	private Unidade unidade;


	
	@Id
	@GeneratedValue
	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
    @Enumerated(EnumType.STRING)
	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	
    @Temporal(TemporalType.DATE)
	public Calendar getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
    @ManyToOne
    @JoinColumn(name= "codigo_cordenador")
	public Cordenador getCordenador() {
		return cordenador;
	}


	public void setCordenador(Cordenador cordenador) {
		this.cordenador = cordenador;
	}


    @ManyToOne
    @JoinColumn(name="codigo_unidade")
	public Unidade getUnidade() {
		return unidade;
	}


	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
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
		Curso other = (Curso) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
