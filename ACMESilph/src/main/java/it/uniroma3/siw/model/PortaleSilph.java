package it.uniroma3.siw.model;

import java.time.LocalDate;

public class PortaleSilph { 
	
	private SilphSPA silphSPA;
	
	private Album albumCorrente;
		
	private RichiestaUtilizzo richiestaUtilizzoCorrente;

	private Fotografo fotografoCorrente;
	
	private Funzionario funzionarioCorrente;
	
	public PortaleSilph(SilphSPA silphSPA) {
		super();
		this.silphSPA = silphSPA;
	}

	
	public void loginFunzionario(String email, String pwd) {
		Funzionario f = this.silphSPA.getFunzionario(email);
		if(f == null) {
			throw new InvalidEmailRuntimeException("Email non trovata");
		}
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
	 * Caso d'uso: Seleziona Richiesta di Utilizzo
	 * @param id
	 */
	
	public void selezionaRichiestaDiUtilizza(Long id) {
		this.richiestaUtilizzoCorrente=this.silphSPA.getRichiestaUtilizzo(id);
	}
	
	
	/**
	 * Caso d'uso: Inserimento Nuovo Album
	 */
	
	public void iniziaInserimentoAlbum() {
		
	}
	/**
	 * Caso d'uso: Inserimento Nuovo Album
	 */
	
	public void inserisciDatiAlbum(String titolo, LocalDate dataPubblicazione, Long idFotografo) {
		Fotografo fotografo = this.silphSPA.getFotografo(idFotografo); 
		this.albumCorrente = new Album(titolo, dataPubblicazione, fotografo);
	}
	/**
	 * Caso d'uso: Inserimento Nuovo Album
	 */
	
	public void inserisciFotoNellAlbum(String titolo, Long prezzo) {
		this.albumCorrente.aggiungiFoto(titolo, prezzo);
	}
	/**
	 * Caso d'uso: Inserimento Nuovo Album
	 */
	
	public void terminaInserimentoFotoNellAlbum() {
		//RIEPILOGO Album
	}
	/**
	 * Caso d'uso: Inserimento Nuovo Album
	 */
	
	public void confermaAlbum() {
		this.albumCorrente.confermati();
	}
	
	
	/**
	 * Caso d'uso:  Visita Cliente
	 */
	public void initVisita() {
		this.richiestaUtilizzoCorrente = new RichiestaUtilizzo();
	}
	
	/**
	 * Caso d'uso:  Visita Cliente
	 */
	public void selezionaFotografo(Long id) {
		this.fotografoCorrente = this.silphSPA.getFotografo(id); 
	}
	/**
	 * Caso d'uso:  Visita Cliente
	 */
	public void selezionaAlbum(Long id) {
		this.albumCorrente = this.fotografoCorrente.getAlbum(id); 
	}
	
	/**
	 * Caso d'uso:  Visita Cliente
	 */
	public void selezionaFoto(Long id) {
		this.richiestaUtilizzoCorrente.aggiungiFoto(this.albumCorrente.getFoto(id));
	}

	/**
	 * Caso d'uso:  Visita Cliente
	 */
	public void terminaInserimentoFoto() {
		
	}
	
	
	/**
	 * Caso d'uso:  Visita Cliente
	 */
	public void confermaRichiestaUtilizzo(String nome, String cognome, String email) {
		this.richiestaUtilizzoCorrente.setDati(nome, cognome, email);
		this.silphSPA.aggiungiRichiestaUtilizzo(this.richiestaUtilizzoCorrente);
	}
	
	
	public Funzionario getFunzionarioCorrente() {
		return funzionarioCorrente;
	}

	


	
	
	
	
	

}
