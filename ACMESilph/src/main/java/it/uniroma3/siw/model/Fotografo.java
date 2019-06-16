package it.uniroma3.siw.model;

import java.util.ArrayList;
import java.util.List;
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
	

	
	@OneToOne(cascade = CascadeType.PERSIST)
	private SorgenteImmagine sorgenteAvatar;
	
	
	
	public SorgenteImmagine getSorgenteAvatar() {
		return sorgenteAvatar;
	}


	public void setSorgenteAvatar(SorgenteImmagine sorgenteAvatar) {
		this.sorgenteAvatar = sorgenteAvatar;
	}



	@OneToMany(mappedBy="fotografo", cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Album> album;
	
	
	

	public Fotografo(String nome, String cognome, String email) {
		this.nome=nome;
		this.cognome=cognome;
		this.email=email;
		this.album=new ArrayList<Album>();
	}
	
	
	
	
	

	public Fotografo() {
		super();
		// TODO Auto-generated constructor stub
	}






	public List<Album> getAlbum() {
		return album;
	}




	public void setAlbum(List<Album> album) {
		this.album = album;
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

	

}
