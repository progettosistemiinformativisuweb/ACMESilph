package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
public class RichiestaUtilizzo {
	
	
	@Column
	private LocalDate data;
	
	@OneToOne
	private Cliente cliente;
	
	@OneToMany
	private List<Foto> foto; 

	
	
	public Long getTotale() {
		long somma = 0; 
		for(Foto f: this.foto) {
			somma += f.getPrezzo(); 
		}
		return somma; 
	}


	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Foto> getFoto() {
		return foto;
	}

	public void setFoto(List<Foto> foto) {
		this.foto = foto;
	}
	
	
	

}
