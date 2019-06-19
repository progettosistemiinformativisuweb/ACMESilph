package it.uniroma3.siw.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw.model.Fotografo;
import it.uniroma3.siw.model.SorgenteImmagine;
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
		Fotografo fotografo=new Fotografo();
		model.addAttribute("fotografo", fotografo);
		return "fotografoForm.html";
	}

	@RequestMapping(value = "/addFotografo", method = RequestMethod.POST)
	public String  salvaNuovoFotografo(@Valid @ModelAttribute ("fotografo") Fotografo fotografo, @RequestParam("foto") MultipartFile file, Model model, BindingResult bindingResult) {

		this.fotografoValidator.validate(fotografo, bindingResult);

		if(!bindingResult.hasErrors()) {
			SorgenteImmagine sorgenteImmagine;

			try {
				sorgenteImmagine = new SorgenteImmagine(file.getBytes());
				fotografo.setSorgenteAvatar(sorgenteImmagine);

			} catch (IOException e) {
				e.printStackTrace();
			} 
			this.fotografoServices.add(fotografo);
			List<Fotografo> fotografi= (List<Fotografo>) this.fotografoServices.getAllFotografi();
			int dimension= fotografi.size()/3;
			List<Fotografo> fotografi1=fotografi.subList(0, dimension);
			List<Fotografo> fotografi2=fotografi.subList(dimension, dimension*2);
			List<Fotografo> fotografi3=fotografi.subList(dimension*2,  fotografi.size());
			model.addAttribute("fotografi1", fotografi1);
			model.addAttribute("fotografi2", fotografi2);
			model.addAttribute("fotografi3", fotografi3);
			return "fotografi.html";
		}
		else {
			return "fotografoForm.html";
		}
		
	}

	
	






}
