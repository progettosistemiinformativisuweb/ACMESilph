package it.uniroma3.siw.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.RichiestaUtilizzo;

public interface RichiestaUtilizzoRepository extends CrudRepository<RichiestaUtilizzo, Long> {

	
	public Collection<RichiestaUtilizzo> findAll();
	
	
	/*Cerca la richiesta con caricandosi anche il cliente e le foto*/
	@Query("SELECT r " +
            "FROM RichiestaUtilizzo r"
          + " JOIN FETCH r.cliente " 
           +" JOIN FETCH r.foto "
           + "WHERE a.id = :id " 
            )
	public RichiestaUtilizzo findByIdWithClienteAndFoto(@Param("id") Long id);
}
