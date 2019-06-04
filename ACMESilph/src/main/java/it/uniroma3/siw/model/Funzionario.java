package it.uniroma3.siw.model;

import javax.persistence.*;

@Entity
public class Funzionario {

	@Id
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	

	public boolean checkPassword(String pwd) {
		if(!this.password.equals(pwd)) {
			throw new InvalidPasswordRuntimeException("Password errata");
		}
		return true;
		
	}
	
	
	
	
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	
	
	
}
