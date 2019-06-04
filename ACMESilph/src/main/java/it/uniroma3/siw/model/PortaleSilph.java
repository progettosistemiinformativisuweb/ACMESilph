package it.uniroma3.siw.model;

import java.time.LocalDate;

public class PortaleSilph { 
	
	private SilphSPA silphSPA;
	
	private Album albumCorrente;
		
	private RichiestaUtilizzo richiestaUtilizzoCorrente;

	private Fotografo fotografoCorrente;
	
	private Funzionario funzionarioCorrente;
	
	
	
	public void loginFunzionario(String email, String pwd) {
		Funzionario f=this.silphSPA.getFunzionario(email);
		f.checkPassword(pwd);
		this.funzionarioCorrente=f;
		
	}
	
	/**
	 * Caso d'uso: Inserimento Nuovo Fotografo
	 * @param nome
	 * @param cognome
	 * @param dataNascita
	 * @param email
	 */
	public void inserisciCredenzialiFotografo(String nome, String cognome, LocalDate dataNascita, String email) {
		this.fotografoCorrente=new Fotografo(nome, cognome, dataNascita, email);
	}
	
	/**
	 * Caso d'uso: Inserimento Nuovo Fotografo
	 */
	public void confermaInserimentoFotografo() {
		this.silphSPA.aggiungiFotografo(this.fotografoCorrente);
		
	}
	
	/**
	 * Caso d'uso: Visualizza Richiesta di Utilizzo
	 */
	public void visualizzaRichiestaDiUtilizzo() {
		//nulla da fare per ora
		return; 
	}
	
	/**
	 * Caso d'uso: Selezion Richiesta di Utilizzo
	 * @param id
	 */
	
	public void selezionaRichiestaDiUtilizza(Long id) {
		this.richiestaUtilizzoCorrente=this.silphSPA.getRichiestaUtilizzo(id);
	}
	
	
	
	

	public PortaleSilph(SilphSPA silphSPA) {
		super();
		this.silphSPA = silphSPA;
	}

	public SilphSPA getSilphSPA() {
		return silphSPA;
	}

	public RichiestaUtilizzo getRichiestaUtilizzoCorrente() {
		return richiestaUtilizzoCorrente;
	}

	public Fotografo getFotografoCorrente() {
		return fotografoCorrente;
	}
	
	public Funzionario getFunzionarioCorrente() {
		return funzionarioCorrente;
	}

	public Album getAlbumCorrente() {
		return albumCorrente;
	}


	
	
	
	
	

}
