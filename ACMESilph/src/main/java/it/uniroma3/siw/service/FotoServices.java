package it.uniroma3.siw.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Foto;
import it.uniroma3.siw.repository.FotoRepository;

@Service
@Transactional
public class FotoServices {
	
	@Autowired
	private FotoRepository fotoRepository; 
	
	public void add(Foto foto) {
		this.fotoRepository.save(foto);
	}

	public Foto getFotoById(Long id) {
		return this.fotoRepository.findById(id).orElse(null);
	}

	public Collection<Foto> getAllFoto() {
		return this.fotoRepository.findAll();
	}
	
	public List<Foto> getAllFotoAsList() {
		return this.getAllFoto().stream().collect(Collectors.toList());
	}
	
	public Collection<Foto> getFotoByFotografoId(Long id) {
		return this.fotoRepository.findFotoByFotografoId(id);
	}
	


}
