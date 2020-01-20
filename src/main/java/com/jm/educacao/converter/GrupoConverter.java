/**
 * @author Jorge marinho on 30 de dez de 2019
 *
 * 
 */
package com.jm.educacao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jm.educacao.model.Grupo;
import com.jm.educacao.repository.Grupos;
import com.jm.educacao.util.cdi.CDIServiceLocator;

@FacesConverter("grupoConverter")
public class GrupoConverter implements Converter {
	

	//@Inject
	private Grupos grupos;
	
	public GrupoConverter() {
		this.grupos = (Grupos) CDIServiceLocator.getBean(Grupos.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Grupo retorno = null;

		if (value != null) {
			retorno = this.grupos.porCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Grupo) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}


}
