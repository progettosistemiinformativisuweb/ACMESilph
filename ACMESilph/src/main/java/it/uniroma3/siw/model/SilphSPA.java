package it.uniroma3.siw.model;


import it.uniroma3.siw.service.FotografoServices;
import it.uniroma3.siw.service.FunzionarioServices;
import it.uniroma3.siw.service.RichiestaUtilizzoServices;

public class SilphSPA {
	
	private static SilphSPA instance;
	private PortaleSilph portale;
	private FunzionarioServices funzionarioServices; 
	private FotografoServices fotografoServices; 
	private RichiestaUtilizzoServices richiestaUtilizzoServices; 
	
	
	private SilphSPA() {
		super();
		this.portale = new PortaleSilph(this); 
		this.funzionarioServices = new FunzionarioServices(); 
		this.fotografoServices = new FotografoServices();
		this.richiestaUtilizzoServices = new RichiestaUtilizzoServices();
	}
	
	/**
	 * SINGLETON
	 */
	public static SilphSPA getInstance() {
		if(instance == null) {
			instance = new SilphSPA(); 
		}
		return instance; 
	}
	

	public PortaleSilph getPortale() {
		return portale;
	}
	
	public Fotografo getFotografo(Long id) {
		return this.fotografoServices.getFotografoByIdWithAlbum(id);
	}

	public Funzionario getFunzionario(String email) {
		return this.funzionarioServices.getFunzionarioByEmail(email); 
	}
	
	public RichiestaUtilizzo getRichiestaUtilizzo(Long id) {
		return this.richiestaUtilizzoServices.getRichiestaByIdWithClienteAndFoto(id); 
	}

	public void aggiungiFotografo(Fotografo fotografoCorrente) {
		this.fotografoServices.add(fotografoCorrente);
		
	}
	

	
	

	
	
	
	

}
