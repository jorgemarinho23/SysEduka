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


import com.jm.educacao.model.Disciplina;
import com.jm.educacao.repository.Disciplinas;
import com.jm.educacao.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Disciplina.class)
public class DisciplinaConverter implements Converter {
	

	//@Inject
	private Disciplinas disciplinas;
	
	public DisciplinaConverter() {
		this.disciplinas = (Disciplinas) CDIServiceLocator.getBean(Disciplinas.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Disciplina retorno = null;

		if (value != null) {
			retorno = this.disciplinas.porCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Disciplina) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}
