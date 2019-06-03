package it.uniroma3.siw.model;
import java.util.Map;

import javax.persistence.*;

@Entity
public class SilphSPA {
	
	@OneToOne
	private PortaleSilph portale;
	
	@OneToMany
	private Map<String,Funzionario> funzionari;
	
	@OneToMany
	private Map<Long,Fotografo> fotografi;
	
	@OneToMany
	private Map<Long,RichiestaUtilizzo> richiesteUtilizzo;

	public PortaleSilph getPortale() {
		return portale;
	}

	public void setPortale(PortaleSilph portale) {
		this.portale = portale;
	}

	public Map<String, Funzionario> getFunzionari() {
		return funzionari;
	}

	public void setFunzionari(Map<String, Funzionario> funzionari) {
		this.funzionari = funzionari;
	}

	public Map<Long, Fotografo> getFotografi() {
		return fotografi;
	}

	public void setFotografi(Map<Long, Fotografo> fotografi) {
		this.fotografi = fotografi;
	}

	public Map<Long, RichiestaUtilizzo> getRichiesteUtilizzo() {
		return richiesteUtilizzo;
	}

	public void setRichiesteUtilizzo(Map<Long, RichiestaUtilizzo> richiesteUtilizzo) {
		this.richiesteUtilizzo = richiesteUtilizzo;
	}
	
	
	

}
