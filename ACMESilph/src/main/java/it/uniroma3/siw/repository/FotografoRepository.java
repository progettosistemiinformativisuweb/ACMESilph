package it.uniroma3.siw.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Fotografo;


public interface FotografoRepository extends CrudRepository<Fotografo, Long> {
	
     public Collection<Fotografo> findAll();
	
	
	/*Cerca il fotografo caricandosi album e foto*/
	@Query("SELECT f " +
            "FROM Fotografo f "
            + "JOIN FETCH f.album a "
            + "JOIN FETCH a.foto fo "
            + "WHERE a.id = :id ")
	public Fotografo findByIdWithAlbumAndFoto(@Param("id") Long id);

}
