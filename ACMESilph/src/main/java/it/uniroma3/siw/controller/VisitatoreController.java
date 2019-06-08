package it.uniroma3.siw.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.model.Album;
import it.uniroma3.siw.model.Foto;
import it.uniroma3.siw.model.Funzionario;
import it.uniroma3.siw.service.AlbumServices;
import it.uniroma3.siw.service.FotoServices;
import it.uniroma3.siw.service.FotografoServices;
import it.uniroma3.siw.service.FunzionarioServices;
import it.uniroma3.siw.service.RichiestaUtilizzoServices;


@Controller
public class VisitatoreController {
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
	
	@RequestMapping(value="/loginAttempt", method=RequestMethod.POST)
	public String login(@ModelAttribute ("possibileFunzionario") Funzionario possibileFunzionario, Model model) {
		Funzionario funzionario=this.funzionarioServices.getFunzionarioByEmail(possibileFunzionario.getEmail());
		if(funzionario!=null && funzionario.checkPassword(possibileFunzionario.getPassword())) {
				model.addAttribute("funzionarioCorrente", funzionario);
				return "homeFunzionario.html";
		}
		else
			return "loginForm.html";
	}
	
	@RequestMapping(value="/galleriaFoto", method=RequestMethod.GET)
	public String getGalleriaFoto(Model model) {
		model.addAttribute("photos", this.fotoServices.getAllFotoAsList());
		return "galleria.html";
	}
	
	@RequestMapping(value="/getFoto/{id}", method=RequestMethod.GET)
	public void getFoto(@PathVariable ("id") Long id, Model model, HttpServletResponse response) throws IOException {
		response.setContentType("image/jpeg");
		Foto foto  = this.fotoServices.getFotoById(id);
		InputStream inputStream= new ByteArrayInputStream(foto.getSorgenteImmagine());
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	
	@RequestMapping(value="/fotografi", method=RequestMethod.GET)
	public String getFotografi(Model model) {
		model.addAttribute("fotografi", this.fotografoServices.getAllFotografi());
		return "fotografi.html";
	}
	
	@RequestMapping(value="/fotografo/{id}", method=RequestMethod.GET)
	public String getFotografo(@PathVariable ("id") Long id, Model model) {
		model.addAttribute("fotografo", this.fotografoServices.getFotografoById(id));
		model.addAttribute("albums", this.albumServices.getAlbumsByFotografoId(id));
		return "fotografo.html";
	}
	
	
	@RequestMapping(value="/album/{id}", method=RequestMethod.GET)
    public String getAlbum(@PathVariable ("id") Long id, Model model) {
		Album album = this.albumServices.getAlbumById(id); 
    	model.addAttribute("album",album ); 
    	model.addAttribute("photos",album.getFoto()); 
    	return "album.html"; 
    }
	
	

	
	
}
