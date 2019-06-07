package it.uniroma3.siw.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Funzionario;
import it.uniroma3.siw.repository.FunzionarioRepository;

@Service
@Transactional
public class FunzionarioServices {
	
	@Autowired
	private FunzionarioRepository funzionarioRepository;

	public void add(Funzionario funzionario) {
		this.funzionarioRepository.save(funzionario);
	}

	public Funzionario getFunzionarioByEmail(String email) {
		return this.funzionarioRepository.findByEmail(email);
	}

	public Collection<Funzionario> getAllFunzionari() {
		return this.funzionarioRepository.findAll();
	}
	
	public List<Funzionario> getAllFunzionariAsList() {
		return this.getAllFunzionari().stream().collect(Collectors.toList());
	}
	
}
