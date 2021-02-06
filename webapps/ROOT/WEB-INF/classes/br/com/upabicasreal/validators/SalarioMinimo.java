package br.com.upabicasreal.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator("SalarioMinimo")
public class SalarioMinimo {
	public void validate(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException {
		Double valor = Double.parseDouble(value.toString());
		if (valor<5000) {
			throw new ValidatorException(new FacesMessage("O Salario abaixo do Mínimo exigido!"));
		}
	}
}
