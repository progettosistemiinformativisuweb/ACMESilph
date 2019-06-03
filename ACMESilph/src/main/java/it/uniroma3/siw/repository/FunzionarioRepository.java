package it.uniroma3.siw.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Funzionario;

public interface FunzionarioRepository extends CrudRepository<Funzionario, Long> {
	
    public Collection<Funzionario> findAll();
    
    public Funzionario findByEmail(String email);

	

}
