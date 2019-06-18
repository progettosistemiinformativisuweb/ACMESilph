package it.uniroma3.siw.model;

import javax.persistence.*;

@Entity
public class Funzionario {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String username; 
	
	@Column(length = 255)
	private String password;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@Column
	private String ruolo;
	
	

	public boolean checkPassword(String pwd) {
		if(!this.password.equals(pwd)) {
			throw new InvalidPasswordRuntimeException("Password errata");
		}
		return true;
		
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	
	
	
}
