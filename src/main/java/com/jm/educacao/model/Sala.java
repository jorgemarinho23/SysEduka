/**
 * @author Jorge marinho on 27 de dez de 2019
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Sala implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	@NotBlank
	private String nome;
	private String localizacao;
	@NotNull
	private Unidade unidade;
	private Calendar dataCadastro;
	private int capacidade;
	
	
	
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
	
	
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	@ManyToOne
	@JoinColumn(name="codigo_unidade")
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	@Temporal(TemporalType.DATE)
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	

}
