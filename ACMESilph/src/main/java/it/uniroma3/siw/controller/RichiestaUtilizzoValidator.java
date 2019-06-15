package it.uniroma3.siw.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.RichiestaUtilizzo;


@Component
public class RichiestaUtilizzoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RichiestaUtilizzo.class.equals(clazz); 
	}

	@Override
	public void validate(Object target, Errors errors) {
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");	
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");			

	}

}
