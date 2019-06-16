package it.uniroma3.siw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class SorgenteImmagine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Lob
	@Column(nullable = false)
	private byte[] sorgente;

	public SorgenteImmagine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SorgenteImmagine(byte[] arrayPic) {
		this.sorgente = arrayPic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getSorgente() {
		return sorgente;
	}

	public void setSorgente(byte[] sorgenteImmagine) {
		this.sorgente = sorgenteImmagine;
	}

}
