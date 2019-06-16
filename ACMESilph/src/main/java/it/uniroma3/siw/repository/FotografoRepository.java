package it.uniroma3.siw.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.model.Fotografo;

@Repository
public interface FotografoRepository extends CrudRepository<Fotografo, Long> {
	
     public Collection<Fotografo> findAll();
	
	
	/*Cerca il fotografo caricandosi album e foto*/
	@Query("SELECT f " +
            "FROM Fotografo f "
            + "JOIN FETCH f.album a "
            + "WHERE a.id = :id ")
	public Fotografo findByIdWithAlbum(@Param("id") Long id);
	
	@Query("SELECT f " +
            "FROM Fotografo f "
            + "JOIN FETCH f.sorgenteAvatar "
            + "WHERE f.id = :id ")
	public Fotografo findFotografoByIdWithSorgenteAvatar(Long id);  

}
