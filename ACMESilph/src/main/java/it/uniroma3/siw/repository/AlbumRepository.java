package it.uniroma3.siw.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.model.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
	

 	public Album findByTitolo(String titolo); 
	
	public Collection<Album> findAll();
	
	
	
	/*Cerca l'album con quell'id insieme alle foto*/
	@Query("SELECT a " +
            "FROM Album a JOIN FETCH a.foto " +
            "WHERE a.id = :id " 
            )
	public Album findByIdWithFoto(@Param("id") Long id);
	
	@Query("SELECT a"+
			"FROM Album a"+
			"WHERE a.fotografo.id= :id")
	public List<Album> findByFotografoId(@Param("id") Long id);

}
