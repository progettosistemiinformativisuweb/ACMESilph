package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class RichiestaUtilizzo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	@Column
	private LocalDate data;
	@Column
	private LocalTime time;
	@Column
	private String nome; 
	@Column
	private String cognome; 
	@Column
	private String email; 
	@Column
	private String nota; 
	

	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Foto> foto; 
	

	
	
	
	public RichiestaUtilizzo(LocalDate data, String nome, String cognome, String email) {
		super();
		this.data = data;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}


	public RichiestaUtilizzo() {
		super();
		this.foto = new ArrayList<>();
		
	}





	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	
	public List<Foto> getFoto() {
		return foto;
	}

	public void setFoto(List<Foto> foto) {
		this.foto = foto;
	}

	

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


	public void aggiungiFoto(Foto foto) {
		this.foto.add(foto); 	
	}


	public void setDati(String nome, String cognome, String email) {
		this.cognome = cognome; 
		this.nome =nome; 
		this.email = email; 
		
	}


	public String getNota() {
		return nota;
	}


	public void setNota(String nota) {
		this.nota = nota;
	}


	public LocalTime getTime() {
		return time;
	}


	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	
	

}
