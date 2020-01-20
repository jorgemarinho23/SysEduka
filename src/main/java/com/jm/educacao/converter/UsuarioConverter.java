/**
 * @author Jorge marinho on 20 de dez de 2019
 *
 * 
 */
package com.jm.educacao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


import com.jm.educacao.model.Usuario;
import com.jm.educacao.repository.Usuarios;
import com.jm.educacao.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Usuario.class)
public class UsuarioConverter implements Converter {
	

	//@Inject
	private Usuarios usuarios;
	
	public UsuarioConverter() {
		this.usuarios = (Usuarios) CDIServiceLocator.getBean(Usuarios.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;

		if (value != null) {
			retorno = this.usuarios.porCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Usuario) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}


}
