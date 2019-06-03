package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.*;

@Entity
public class Fotografo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@Column
	private String email;
	
	@Column
	private LocalDate dataNascita;
	
	@OneToMany(mappedBy="fotografo")
	private Map<Long, Album> album;
	
	
	

}
