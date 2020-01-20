/**
 * @author Jorge marinho on 20 de dez de 2019
 *
 * 
 */
package com.jm.educacao.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.jm.educacao.model.Usuario;
import com.jm.educacao.util.jpa.Transactional;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	
	public Usuario salvar(Usuario usuario) {
		return this.em.merge(usuario);
		
	}


	public List<Usuario> buscarTodos() {
		
		return em.createQuery("from Usuario").getResultList();
	}


	@Transactional
	public void Excluir(Usuario usuario) {
		
		Usuario usuTemp = em.find(Usuario.class,usuario.getCodigo());
		
		em.remove(usuTemp);
        em.flush();		
	}


	public Usuario porCodigo(Long codigo) {
		
		return em.find(Usuario.class, codigo);
	}


	public Usuario porUsuario(String usu) {
Usuario usuario = null;
		
		try {
			usuario = this.em.createQuery("from Usuario where usuario = :usu", Usuario.class)
				.setParameter("usu", usu).getSingleResult();
		} catch (NoResultException e) {
			// nenhum usuário encontrado com o usuario informado
		}
		
		return usuario;
	}

}
