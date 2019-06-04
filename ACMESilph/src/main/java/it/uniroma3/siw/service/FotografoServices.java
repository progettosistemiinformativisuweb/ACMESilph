package it.uniroma3.siw.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Fotografo;
import it.uniroma3.siw.repository.FotografoRepository;

@Service
@Transactional
public class FotografoServices {

	@Autowired
	private FotografoRepository fotografoRepository;

	public void add(Fotografo fotografo) {
		this.fotografoRepository.save(fotografo);
	}

	public Fotografo getFotografoById(Long id) {
		return this.fotografoRepository.findById(id).orElse(null);
	}

	public Collection<Fotografo> getAllFotografi() {
		return this.fotografoRepository.findAll();
	}
	
	public List<Fotografo> getAllFotografiAsList() {
		return this.getAllFotografi().stream().collect(Collectors.toList());
	}
	
	public Fotografo getFotografoByIdWithAlbum(Long id) {
		return this.fotografoRepository.findByIdWithAlbum(id);
	}

}
