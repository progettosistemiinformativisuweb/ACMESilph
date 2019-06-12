package it.uniroma3.siw.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.model.RichiestaUtilizzo;
@Repository
public interface RichiestaUtilizzoRepository extends CrudRepository<RichiestaUtilizzo, Long> {

	
	public Collection<RichiestaUtilizzo> findAll();
	
	
	/*Cerca la richiesta con caricandosi anche il cliente e le foto*/
	@Query("SELECT r " +
            "FROM RichiestaUtilizzo r" 
           +" JOIN FETCH r.foto f "
           + "WHERE f.id = :id " 
            )
	public RichiestaUtilizzo findByIdWithFoto(@Param("id") Long id);
}
