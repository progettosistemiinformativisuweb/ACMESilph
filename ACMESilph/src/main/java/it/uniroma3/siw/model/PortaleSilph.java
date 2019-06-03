package it.uniroma3.siw.model;

import javax.persistence.*;

@Entity
public class PortaleSilph { 
	
	@OneToOne
	private Album albumCorrente;
	
	@OneToOne
	private SilphSPA silphSPA;
	
	@OneToOne
	private RichiestaUtilizzo richiestaUtilizzoCorrente;


	@OneToOne
	private Fotografo fotografoCorrente;
	
	@OneToOne
	private Funzionario funzionarioCorrente;

	public Album getAlbumCorrente() {
		return albumCorrente;
	}

	public void setAlbumCorrente(Album albumCorrente) {
		this.albumCorrente = albumCorrente;
	}

	public SilphSPA getSilphSPA() {
		return silphSPA;
	}

	public void setSilphSPA(SilphSPA silphSPA) {
		this.silphSPA = silphSPA;
	}

	public RichiestaUtilizzo getRichiestaUtilizzoCorrente() {
		return richiestaUtilizzoCorrente;
	}

	public void setRichiestaUtilizzoCorrente(RichiestaUtilizzo richiestaUtilizzoCorrente) {
		this.richiestaUtilizzoCorrente = richiestaUtilizzoCorrente;
	}

	public Fotografo getFotografoCorrente() {
		return fotografoCorrente;
	}

	public void setFotografoCorrente(Fotografo fotografoCorrente) {
		this.fotografoCorrente = fotografoCorrente;
	}

	public Funzionario getFunzionarioCorrente() {
		return funzionarioCorrente;
	}

	public void setFunzionarioCorrente(Funzionario funzionarioCorrente) {
		this.funzionarioCorrente = funzionarioCorrente;
	}
	
	
	
	

}
