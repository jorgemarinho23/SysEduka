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


import com.jm.educacao.model.Cordenador;
import com.jm.educacao.repository.Cordenadores;
import com.jm.educacao.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Cordenador.class)
public class CordenadorConverter implements Converter {

	//@Inject
		private Cordenadores cordenadores;
		
		public CordenadorConverter() {
			this.cordenadores = (Cordenadores) CDIServiceLocator.getBean(Cordenadores.class);
		}
		
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			Cordenador retorno = null;

			if (value != null) {
				retorno = this.cordenadores.porCodigo(new Long(value));
			}

			return retorno;
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if (value != null) {
				Long codigo = ((Cordenador) value).getCodigo();
				String retorno = (codigo == null ? null : codigo.toString());
				
				return retorno;
			}
			
			return "";
		}


}
