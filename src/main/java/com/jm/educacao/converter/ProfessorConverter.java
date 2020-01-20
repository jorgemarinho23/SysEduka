package com.jm.educacao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


import com.jm.educacao.model.Professor;
import com.jm.educacao.repository.Professores;
import com.jm.educacao.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Professor.class)
public class ProfessorConverter implements Converter {
	
	//@Inject
		private Professores professores;
		
		public ProfessorConverter() {
			this.professores = (Professores) CDIServiceLocator.getBean(Professores.class);
		}
		
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			Professor retorno = null;

			if (value != null) {
				retorno = this.professores.porCodigo(new Long(value));
			}

			return retorno;
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if (value != null) {
				Long codigo = ((Professor) value).getCodigo();
				String retorno = (codigo == null ? null : codigo.toString());
				
				return retorno;
			}
			
			return "";
		}


}
