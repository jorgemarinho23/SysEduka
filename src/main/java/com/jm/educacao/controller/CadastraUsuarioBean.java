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

import com.jm.educacao.model.Grupo;
import com.jm.educacao.model.Usuario;
import com.jm.educacao.repository.Grupos;
import com.jm.educacao.service.CadastraUsuarioService;
import com.jm.educacao.service.NegocioException;
import com.jm.educacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastraUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private List<Grupo> grupos = new ArrayList<>();
	
	@Inject
	private CadastraUsuarioService usuarioService;
	@Inject
	private Grupos gruposRep;
	
	
	
	public void salvar() {
		
		if (usuario.getCodigo() == null) {
			
			try {
				this.usuario = usuarioService.salvar(usuario);
				FacesUtil.addInfoMessage("Salvo com sucesso !");
				this.limpar();
			} catch (NegocioException e) {
				FacesUtil.addErrorMessage(e.getMessage());
			}
			
		}else {
			try {
				this.usuario = usuarioService.salvar(usuario);
				FacesUtil.addInfoMessage("Atualizado com sucesso !");
				
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
		this.usuario = new Usuario();
		this.grupos = gruposRep.buscarTodos();
	}
	
	public boolean isEditando() {
		return this.usuario.getCodigo() != null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}
	
	
	

}
