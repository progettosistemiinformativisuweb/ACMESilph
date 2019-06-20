package it.uniroma3.siw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw.model.Album;
import it.uniroma3.siw.model.Foto;
import it.uniroma3.siw.model.Fotografo;
import it.uniroma3.siw.model.RichiestaUtilizzo;
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
	private AlbumValidator albumValidator;





	@Autowired
	private RichiestaUtilizzoServices richiestaUtilizzoServices;


	@RequestMapping(value = "/visualizzaRichiesteDiUtilizzo", method = RequestMethod.GET)
	public String getRichiesteUtilizzo(Model model) {
		List<RichiestaUtilizzo> richieste = (List<RichiestaUtilizzo>) this.richiestaUtilizzoServices.getAllRichieste();
		model.addAttribute("richiesteUtilizzo", richieste);
		return "richiesteUtilizzo.html";
	}


	@RequestMapping(value = "/inserisciAlbum", method = RequestMethod.GET)
	public String inserisciNuovoAlbum(Model model) {
		Album album=new Album();
		List<Fotografo> fotografi= this.fotografoServices.getAllFotografiAsList();
		model.addAttribute("album", album);
		model.addAttribute("fotografi", fotografi);
		
		return "nuovoAlbum.html";
	}
	
	
	@RequestMapping(value = "/addAlbum", method = RequestMethod.POST)
	public String  salvaNuovoAlbum(@Valid @ModelAttribute ("album") Album album, @RequestParam("photos") MultipartFile[] files, Model model, BindingResult bindingResult) {

		Fotografo fotografo=album.getFotografo();
		
		
		this.albumValidator.validate(album, bindingResult);

		if(!bindingResult.hasErrors()) {
			SorgenteImmagine sorgenteImmagine;

			try {
				
				
				for(MultipartFile file: files) {
					sorgenteImmagine = new SorgenteImmagine(file.getBytes());
					Foto foto=new Foto();
					foto.setPrezzo(10L);
					foto.setFotografo(fotografo);
					foto.setSorgenteImmagine(sorgenteImmagine);
					foto.setTitolo(file.getOriginalFilename());
					
					album.addFoto(foto);
					
				}
				
				this.albumServices.add(album);
				fotografo.getAlbum().add(album);

			} catch (IOException e) {
				e.printStackTrace();
			} 
			model.addAttribute("albums", this.albumServices.getAlbumsByFotografoId(fotografo.getId())); 
			model.addAttribute("fotografo", fotografo);
			return "fotografo.html";
		}
		else {
			return "nuovoAlbum.html";
		}
		
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
	
	@RequestMapping(value = "/fotoRichieste/{id}", method = RequestMethod.GET)
	public String getFotoRichieste(@PathVariable("id") Long id, Model model) {
		RichiestaUtilizzo ru = this.richiestaUtilizzoServices.getRichiestaByIdWithFoto(id);
		if(ru == null) {
			ru = this.richiestaUtilizzoServices.getRichiestaById(id); 
			model.addAttribute("photos", new ArrayList<Foto>());

			
		}
		else {
			model.addAttribute("photos", ru.getFoto());

			
		}
		model.addAttribute("richiesta", ru);


		return "fotoRichieste.html";
	}

	


}
