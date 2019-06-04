package it.uniroma3.siw.model;

public class InvalidPasswordRuntimeException extends RuntimeException {
	

	private static final long serialVersionUID = 1L;

	public InvalidPasswordRuntimeException(String message) {
		super(message);
	}

}
