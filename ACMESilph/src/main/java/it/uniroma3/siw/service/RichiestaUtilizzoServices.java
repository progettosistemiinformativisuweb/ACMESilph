package it.uniroma3.siw.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.RichiestaUtilizzo;
import it.uniroma3.siw.repository.RichiestaUtilizzoRepository;

@Service
@Transactional
public class RichiestaUtilizzoServices {

	@Autowired
	private RichiestaUtilizzoRepository richiestaUtilizzoRepository;

	public void add(RichiestaUtilizzo richiesta) {
		this.richiestaUtilizzoRepository.save(richiesta);
	}

	public RichiestaUtilizzo getRichiestaByIdWithFoto(Long id) {
		return this.richiestaUtilizzoRepository.findByIdWithFoto(id);
	}

	public Collection<RichiestaUtilizzo> getAllRichieste() {
		return this.richiestaUtilizzoRepository.findAll();
	}

	public RichiestaUtilizzo getRichiestaById(Long id) {
		return this.richiestaUtilizzoRepository.findById(id).get(); 
	}

}
