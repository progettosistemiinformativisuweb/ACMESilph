package it.uniroma3.siw.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.model.Funzionario;


@Component
public class DBPopulation implements ApplicationRunner{
	
	@Autowired
	private FunzionarioRepository funzionarioRepository; 
	
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		this.addAll();
		this.removeAll();
	}
	
	
	private void addAll() {
		Funzionario f1 =new Funzionario();
		f1.setNome("Mario");
		f1.setCognome("Rossi");
		f1.setEmail("mario.rossi@gmail.com");
		f1.setPassword("password");
		
	
		this.funzionarioRepository.save(f1);


	}
	private void removeAll() {
		this.funzionarioRepository.deleteAll();
	}
}
