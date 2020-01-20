package com.jm.educacao.security;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Named
@RequestScoped
public class Seguranca {
    @Inject
	private ExternalContext externalContext;
	
	public String getNomeUsuario() {
		String nome = null;
		
		UsuarioSistema usuarioLogado = getUsuarioLogado();
		
		if (usuarioLogado != null) {
			nome = usuarioLogado.getUsuario().getNome();
		}
		
		return nome;
	}
	
	public String getData() {
		Date data = new Date(System.currentTimeMillis()); 
		SimpleDateFormat formatarDate = new SimpleDateFormat("HH:mm:ss"); 
		String d = formatarDate.format(Calendar.getInstance().getTime());
		System.out.print(formatarDate.format(data));
		return d;
	}

	private UsuarioSistema getUsuarioLogado() {
		UsuarioSistema usuario = null;
		
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) 
				FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		
		if (auth != null && auth.getPrincipal() != null) {
			usuario = (UsuarioSistema) auth.getPrincipal();
		}
		
		return usuario;
	}
	
	public boolean isExcluirRegistro() {
		return this.externalContext.isUserInRole("FUNCIONARIOS");
		
	}
	
	public boolean isEditarRegistro() {
		return this.externalContext.isUserInRole("FUNCIONARIOS");
		
	}
	
	public boolean isPesquisarRegistro() {
		return this.externalContext.isUserInRole("FUNCIONARIOS");
		
	}
	
}
