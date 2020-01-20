/**
 * @author Jorge marinho on 20 de dez de 2019
 *
 * 
 */
package com.jm.educacao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jm.educacao.model.Usuario;
import com.jm.educacao.repository.Usuarios;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Usuario> usuarios = new ArrayList<>();
	private Usuario usuarioSelecionado;
	
	@Inject
	private Usuarios usuariosRep;
	
	public void excluir() { 
		this.usuariosRep.Excluir(usuarioSelecionado);
		this.usuarios.remove(usuarioSelecionado);
		FacesUtil.addInfoMessage("Excluido com sucesso !");
	}
	
	@PostConstruct
	public void buscarTodos() {
		this.usuarios = usuariosRep.buscarTodos();
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	
	

}
