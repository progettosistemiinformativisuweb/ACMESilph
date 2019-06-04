package it.uniroma3.siw.model;

import javax.persistence.*;

@Entity
public class Foto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String titolo;
	
	@Column
	private Long prezzo;
	
	@ManyToOne
	private Fotografo fotografo;
	
	

	public Foto(String titolo, Long prezzo, Fotografo fotografo) {
		super();
		this.titolo = titolo;
		this.prezzo = prezzo;
		this.fotografo = fotografo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	

	public Long getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Long prezzo) {
		this.prezzo = prezzo;
	}

	public Fotografo getFotografo() {
		return fotografo;
	}

	public void setFotografo(Fotografo fotografo) {
		this.fotografo = fotografo;
	}

	

}
