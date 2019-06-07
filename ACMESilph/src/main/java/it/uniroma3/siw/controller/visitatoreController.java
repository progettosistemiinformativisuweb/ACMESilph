package it.uniroma3.siw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.model.Funzionario;
import it.uniroma3.siw.service.AlbumServices;
import it.uniroma3.siw.service.FotoServices;
import it.uniroma3.siw.service.FotografoServices;
import it.uniroma3.siw.service.FunzionarioServices;
import it.uniroma3.siw.service.RichiestaUtilizzoServices;


@Controller
public class visitatoreController {
	@Autowired
	private AlbumServices albumServices;
	
	@Autowired
	private FotografoServices fotografoServices;
	
	@Autowired
	private FotoServices fotoServices;
	
	@Autowired
	private FunzionarioServices funzionarioServices;
	
	@Autowired
	private RichiestaUtilizzoServices richiestaUtilizzoServices;
	
	@RequestMapping(value="/galleriaFoto", method=RequestMethod.GET)
	public String getGalleriaFoto(Model model) {
		model.addAttribute("photos", this.fotografoServices.getAllFotografiAsList());
		return "galleria.html";
	}
	
	@RequestMapping(value="/fotografi", method=RequestMethod.GET)
	public String getFotografi(Model model) {
		model.addAttribute("fotografi", this.fotografoServices.getAllFotografi());
		return "fotografi.html";
	}
	
	@RequestMapping(value="/loginAttempt", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute ("possibileFunzionario") Funzionario possibileFunzionario, Model model) {
		Funzionario funzionario=this.funzionarioServices.getFunzionarioByEmail(possibileFunzionario.getEmail());
		if(funzionario!=null && funzionario.checkPassword(possibileFunzionario.getPassword())) {
				model.addAttribute("funzionarioCorrente", funzionario);
				return "homeFunzionario.html";
		}
		else
			return "loginForm.html";
	}
	
	
}
