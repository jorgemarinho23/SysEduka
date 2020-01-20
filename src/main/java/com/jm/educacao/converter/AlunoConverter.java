package com.jm.educacao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.jm.educacao.model.Aluno;
import com.jm.educacao.repository.Alunos;
import com.jm.educacao.util.cdi.CDIServiceLocator;




@FacesConverter(forClass=Aluno.class) 
public class AlunoConverter implements Converter {
	

	//@Inject
	private Alunos alunos;
	
	public AlunoConverter() {
		this.alunos = (Alunos) CDIServiceLocator.getBean(Alunos.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Aluno retorno = null;

		if (value != null) {
			retorno = this.alunos.porId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Aluno) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}
