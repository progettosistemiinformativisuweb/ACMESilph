package it.uniroma3.siw.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class RichiestaUtilizzo {
	
	@Column
	private Long totale;
	
	@Column
	private LocalDate data;
	
	@OneToOne
	private Cliente cliente;

	public Long getTotale() {
		return totale;
	}

	public void setTotale(Long totale) {
		this.totale = totale;
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
	
	
	

}
