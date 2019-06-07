package it.uniroma3.siw.service;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Album;
import it.uniroma3.siw.repository.AlbumRepository;

@Service
@Transactional
public class AlbumServices {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	public void add(Album album) {
		this.albumRepository.save(album);
	}
		
	public Album getAlbumByTitolo(String titolo) {
		return this.albumRepository.findByTitolo(titolo);
	}
	
	public Album getAlbumByIdWithFoto(Long id) {
		return this.albumRepository.findByIdWithFoto(id);
	}
	
	public Collection<Album> getAllAlbum() {
		return this.albumRepository.findAll(); 
	}
	
	public List<Album> getAllAlbumAsList(){
		return this.getAllAlbum().stream().collect(Collectors.toList());
	}
	
	public List<Album> getAlbumsByFotografoId(Long id){
		return this.albumRepository.findByFotografoId(id);
	}
	
	public Album getAlbumById(Long id) {
		return this.albumRepository.findById(id).orElse(null);
	}

}
