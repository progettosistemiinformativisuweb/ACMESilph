package it.uniroma3.siw.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.model.Funzionario;
@Repository
public interface FunzionarioRepository extends CrudRepository<Funzionario, Long> {
	
    public Collection<Funzionario> findAll();
    
    public Funzionario findByUsernameAndPassword(String username, String password);

	public Funzionario findByUsername(String username);

	

}
