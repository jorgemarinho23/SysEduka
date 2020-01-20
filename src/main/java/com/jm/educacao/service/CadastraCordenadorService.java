/**
 * @author Jorge marinho on 25 de dez de 2019
 *
 * 
 */
package com.jm.educacao.service;

import java.io.Serializable;
import java.util.Calendar;

import javax.inject.Inject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jm.educacao.model.Cordenador;
import com.jm.educacao.model.Endereco;
import com.jm.educacao.repository.Cordenadores;
import com.jm.educacao.util.jpa.Transactional;

public class CadastraCordenadorService implements Serializable { 

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cordenadores cordenadores;
	
	@Transactional
	public Cordenador salvar(Cordenador cordenador) throws NegocioException{
		String cepFormat;
		
		cepFormat = cordenador.getCep().replace("-", "");
		
		cordenador.setCep(cepFormat);
		
		if (cordenador.getNome() == null || cordenador.getNome().trim().equals("")) {
			throw new NegocioException("Nome obrigatorio !");
		}
		
		if (cordenador.getCodigo() == null) {
			cordenador.setDataCadastro(Calendar.getInstance());
		}
		
		return cordenadores.salvar(cordenador);
		
	}
	
	public Cordenador buscarEnderecoPor(String urlJson) throws NegocioException{
		System.out.println("CHAMOU O SERVIÇO....");
		
		
		final GsonBuilder gsonBuilder = new GsonBuilder();
		final Gson gson = gsonBuilder.create();
		Gson g = new Gson();		
		Cordenador retornoEndereco = gson.fromJson(urlJson, Cordenador.class);	
		System.out.println(retornoEndereco.getCodigo());
		return retornoEndereco;
	}

}
