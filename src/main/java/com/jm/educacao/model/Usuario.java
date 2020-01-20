/**
 * @author Jorge marinho on 20 de dez de 2019
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
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	@NotBlank
	private String nome;
	@NotBlank
	private String usuario;
	@NotBlank
	private String senha;
	private Calendar dataCadastro;
	@NotNull
	private Grupo grupo;
	
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
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@ManyToOne
	@JoinColumn(name="codigo_grupo")
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	@Temporal(TemporalType.DATE)
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
