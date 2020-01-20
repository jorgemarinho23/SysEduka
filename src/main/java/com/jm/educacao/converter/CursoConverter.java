package com.jm.educacao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


import com.jm.educacao.model.Curso;
import com.jm.educacao.repository.Cursos;
import com.jm.educacao.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Curso.class)
public class CursoConverter implements Converter {
	
	

	//@Inject
	private Cursos cursos;
	
	public CursoConverter() {
		this.cursos = (Cursos) CDIServiceLocator.getBean(Cursos.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Curso retorno = null;

		if (value != null) {
			retorno = this.cursos.porCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Curso) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}


}
