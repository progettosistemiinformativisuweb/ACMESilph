package it.uniroma3.siw.model;

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
