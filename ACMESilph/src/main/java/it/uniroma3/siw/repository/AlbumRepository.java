package it.uniroma3.siw.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Album;

public interface AlbumRepository extends CrudRepository<Album, Long> {
	

 	public Album findByTitolo(String titolo); 
	
	public Collection<Album> findAll();
	
	
	/*Cerca l'album con quell'id insieme alle foto*/
	@Query("SELECT a " +
            "FROM Album a JOIN FETCH a.foto " +
            "WHERE a.id = :id " 
            )
	public Album findByIdWithFoto(@Param("id") Long id);

}
