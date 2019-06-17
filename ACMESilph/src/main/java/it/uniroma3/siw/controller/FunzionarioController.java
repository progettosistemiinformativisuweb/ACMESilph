package it.uniroma3.siw.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.service.AlbumServices;
import it.uniroma3.siw.service.FotografoServices;
import it.uniroma3.siw.service.RichiestaUtilizzoServices;

@Controller
public class FunzionarioController {
	@Autowired
	private AlbumServices albumServices;
	
	@Autowired
	private FotografoServices fotografoServices;
	
	
	@Autowired
	private FotografoValidator fotografoValidator;
	
	
	
	
	
	@Autowired
	private RichiestaUtilizzoServices richiestaUtilizzoServices;
	
	
	
	@RequestMapping(value = "/visualizzaRichiesteDiUtilizzo", method = RequestMethod.GET)
	public String getRichiesteUtilizzo(Model model) {
		model.addAttribute("richiesteUtilizzo",
				this.richiestaUtilizzoServices.getAllRichieste().stream().collect(Collectors.toList()));
		return "richiesteUtilizzo.html";
	}
	
	
	@RequestMapping(value = "/inserisciAlbum", method = RequestMethod.GET)
	public String inserisciNuovoAlbum(Model model) {
		return "nuovoAlbum.html";
	}
	
	@RequestMapping(value = "/nuovoFotografo", method = RequestMethod.GET)
	public String  inserisciNuovoFotografo(Model model) {
		return "nuovoFotografo.html";
	}
	
	
	
	
	
	

}
