/**
 * @author Jorge marinho on 24 de dez de 2019
 *
 * 
 */
package com.jm.educacao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


import com.jm.educacao.model.Matricula;
import com.jm.educacao.repository.Matriculas;
import com.jm.educacao.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Matricula.class)
public class MatriculaConverter implements Converter {
	
	//@Inject
		private Matriculas matriculas;
		
		public MatriculaConverter() {
			this.matriculas = (Matriculas) CDIServiceLocator.getBean(Matriculas.class);
		}
		
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			Matricula retorno = null;

			if (value != null) {
				retorno = this.matriculas.porCodigo(new Long(value));
			}

			return retorno;
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if (value != null) {
				Long codigo = ((Matricula) value).getCodigo();
				String retorno = (codigo == null ? null : codigo.toString());
				
				return retorno;
			}
			
			return "";
		}
}
