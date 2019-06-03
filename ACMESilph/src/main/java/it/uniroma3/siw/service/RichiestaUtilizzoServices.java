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

	public RichiestaUtilizzo getRichiestaByIdWithClienteAndFoto(Long id) {
		return this.richiestaUtilizzoRepository.findByIdWithClienteAndFoto(id);
	}

	public Collection<RichiestaUtilizzo> getAllRichieste() {
		return this.richiestaUtilizzoRepository.findAll();
	}

}