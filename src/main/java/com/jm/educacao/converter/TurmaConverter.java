/**
 * @author Jorge marinho on 25 de dez de 2019
 *
 * 
 */
package com.jm.educacao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


import com.jm.educacao.model.Turma;
import com.jm.educacao.repository.Turmas;
import com.jm.educacao.util.cdi.CDIServiceLocator;

@FacesConverter(forClass= Turma.class)
public class TurmaConverter  implements Converter {

	//@Inject
		private Turmas turmas;
		
		public TurmaConverter() {
			this.turmas = (Turmas) CDIServiceLocator.getBean(Turmas.class);
		}
		
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			Turma retorno = null;

			if (value != null) {
				retorno = this.turmas.porCodigo(new Long(value));
			}

			return retorno;
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if (value != null) {
				Long codigo = ((Turma) value).getCodigo();
				String retorno = (codigo == null ? null : codigo.toString());
				
				return retorno;
			}
			
			return "";
		}

}
