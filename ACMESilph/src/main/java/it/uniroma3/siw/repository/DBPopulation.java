package it.uniroma3.siw.repository;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.model.Foto;
import it.uniroma3.siw.model.Fotografo;
import it.uniroma3.siw.model.Funzionario;


@Component
public class DBPopulation implements ApplicationRunner{
	
	@Autowired
	private FunzionarioRepository funzionarioRepository; 
	
	@Autowired
	private FotografoRepository fotografoRepository; 
	
	@Autowired
	private FotoRepository fotoRepository; 
	
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.removeAllFunzionari();
		this.addAllFunzionari();
		this.removeAllFotografi();
		this.addAllFotografi();
		this.removeAllPics();
		this.addAllPictures();
		
	}
	
	
	private void addAllFunzionari() {
		Funzionario f1 =new Funzionario();
		f1.setNome("Mario");
		f1.setCognome("Rossi");
		f1.setEmail("mario.rossi@gmail.com");
		f1.setPassword("password");
		
	
		this.funzionarioRepository.save(f1);


	}
	private void removeAllFunzionari() {
		this.funzionarioRepository.deleteAll();
	}
	
	private void addAllFotografi() {
		Fotografo f1 = new Fotografo("Matteo", "Brandetti", "matteo.brandetti@gmail.com");
		Fotografo f2 = new Fotografo("Adriano", "Vlad", "adriano.vlad@gmail.com");
		Fotografo f3 = new Fotografo("Marco", "Rossi", "marco.rossi@gmail.com");
		Fotografo f4 = new Fotografo("Giovanni", "Verdi", "givoanni.verdi@gmail.com");
		Fotografo f5 = new Fotografo("Andrea", "Bianchi", "andrea.bianchi@gmail.com");
		Fotografo f6 = new Fotografo("Francesco", "Neri", "francesco.neri@gmail.com");
		
		
		this.fotografoRepository.save(f1);
		this.fotografoRepository.save(f2);
		this.fotografoRepository.save(f3);
		this.fotografoRepository.save(f4);
		this.fotografoRepository.save(f5);
		this.fotografoRepository.save(f6);
		

		

		
	}
	
	
	private void removeAllFotografi() {
		this.fotografoRepository.deleteAll();
	}
	
	
	private void addAllPictures() {		
		for(int i=1; i<10; i++) {
			String filename = "0" + (Integer.valueOf(i)).toString() + ".jpg";
			this.addPicture(filename, filename, 5L);
		}
		
		for(int i=1; i<4; i++) {
			String filename = "1" + (Integer.valueOf(i)).toString() + ".jpg";
			this.addPicture(filename, filename, 5L);
		}
		
	}
	
	private void addPicture(String filename, String fotoName, Long prezzo) {
		ClassPathResource resource= new ClassPathResource(filename);    
		File file = new File(resource.getPath());
		Foto f1 = new Foto(fotoName, prezzo); 
		
		
        byte[] bFile = new byte[(int) file.length()];
       

		f1.setSorgenteImmagine(bFile);
		
		this.fotoRepository.save(f1);
		
	}
	
	private void removeAllPics() {
		this.fotoRepository.deleteAll();
	}
}