package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.*;

@Entity
public class Fotografo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@Column
	private String email;
	
	@Column
	private LocalDate dataNascita;
	
	@OneToMany(mappedBy="fotografo")
	private Map<Long, Album> album;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Map<Long, Album> getAlbum() {
		return album;
	}

	public void setAlbum(Map<Long, Album> album) {
		this.album = album;
	}
	
	
	

}
