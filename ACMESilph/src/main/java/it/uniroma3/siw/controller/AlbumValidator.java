package it.uniroma3.siw.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Album;

@Component

public class AlbumValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Album.class.equals(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titolo", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "annoPubblicazione", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fotografo", "required");


	}

}
