package it.uniroma3.siw.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Foto;

public interface FotoRepository extends CrudRepository<Foto,Long>{

    public Collection<Foto> findAll();
    
    
    @Query("SELECT f " +
            "FROM Foto f "
            + "JOIN FETCH f.fotografo fot "
            + "WHERE fot.id = :id ")
    public Collection<Foto> findFotoByFotografoId(@Param("id") Long id);

	
}
