package it.uniroma3.siw.model;

import java.time.LocalDate;

import java.util.*;

import javax.persistence.*;


@Entity
public class Album {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String titolo;
	
	@Column
	private LocalDate annoPubblicazione;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Fotografo fotografo;

	@JoinColumn(name = "album")
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	private List<Foto> foto;
	
	
	
	
	public Album(String titolo, LocalDate annoPubblicazione, Fotografo fotografo) {
		super();
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.fotografo = fotografo;
		this.foto = new ArrayList<>();
	}
	
	public Album() {
		this.foto=new ArrayList<Foto>();
	}
	
	public void aggiungiFoto(String titolo, Long prezzo) {
		this.foto.add(new Foto(titolo,prezzo, this.fotografo));
	}
	
	public void addFoto(Foto foto) {
		this.foto.add(foto);
	}
	
	

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Fotografo getFotografo() {
		return fotografo;
	}

	public void setFotografo(Fotografo fotografo) {
		this.fotografo = fotografo;
	}

	public List<Foto> getFoto() {
		return foto;
	}


	public void setFoto(List<Foto> foto) {
		this.foto = foto;
	}
	
	
	
	
}
