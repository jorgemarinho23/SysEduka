/**
 * @author Jorge marinho on 27 de dez de 2019
 *
 * 
 */
package com.jm.educacao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jm.educacao.model.Sala;
import com.jm.educacao.repository.Salas;
import com.jm.educacao.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Sala.class)
public class SalaConverter implements Converter {
	
	
	//@Inject
			private Salas salas;
			
			public SalaConverter() {
				this.salas = (Salas) CDIServiceLocator.getBean(Salas.class);
			}
			
			@Override
			public Object getAsObject(FacesContext context, UIComponent component, String value) {
				Sala retorno = null;

				if (value != null) {
					retorno = this.salas.porCodigo(new Long(value));
				}

				return retorno;
			}

			@Override
			public String getAsString(FacesContext context, UIComponent component, Object value) {
				if (value != null) {
					Long codigo = ((Sala) value).getCodigo();
					String retorno = (codigo == null ? null : codigo.toString());
					
					return retorno;
				}
				
				return "";
			}


}
