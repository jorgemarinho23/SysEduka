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

import com.jm.educacao.model.Unidade;
import com.jm.educacao.repository.Unidades;
import com.jm.educacao.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Unidade.class)
public class UnidadeConverter implements Converter {
	
	//@Inject
	private Unidades unidades;
	
	public UnidadeConverter() {
		this.unidades = (Unidades) CDIServiceLocator.getBean(Unidades.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Unidade retorno = null;

		if (value != null) {
			retorno = this.unidades.porCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Unidade) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}


}
