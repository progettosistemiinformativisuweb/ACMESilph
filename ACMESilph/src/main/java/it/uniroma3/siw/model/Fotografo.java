package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

import it.uniroma3.siw.service.AlbumServices;

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
	private List<Foto> album;
	
	private AlbumServices albumServices; 
	
	
	

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

	public Album getAlbum(long id) {
		return this.albumServices.getAlbumByIdWithFoto(id); 
	}
	
	

}
