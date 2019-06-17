package it.uniroma3.siw.repository;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.model.Foto;
import it.uniroma3.siw.model.Fotografo;
import it.uniroma3.siw.model.Funzionario;
import it.uniroma3.siw.model.RichiestaUtilizzo;
import it.uniroma3.siw.model.SorgenteImmagine;


@Component
public class DBPopulation implements ApplicationRunner{
	
	@Autowired
	private FunzionarioRepository funzionarioRepository; 
	
	@Autowired
	private FotografoRepository fotografoRepository; 
	
	@Autowired
	private FotoRepository fotoRepository; 
	
	@Autowired
	private RichiestaUtilizzoRepository richiestaUtilizzoRepository; 

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.removeAllFunzionari();
		this.addAllFunzionari();
		this.removeAllFotografi();
		this.addAllFotografi();
		this.removeAllPics();
		this.addAllPictures();
		this.removeAllRichiesteUtlizzo();
		this.addAllRichiesteUtilizzo();
		
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
		Fotografo f3 = new Fotografo("Marco", "Rossi", "marco.rossi@gmail.com");
		Fotografo f2 = new Fotografo("Adriano", "Vlad", "adriano.vlad@gmail.com");
		Fotografo f4 = new Fotografo("Giovanni", "Verdi", "givoanni.verdi@gmail.com");
		Fotografo f5 = new Fotografo("Andrea", "Bianchi", "andrea.bianchi@gmail.com");
		Fotografo f6 = new Fotografo("Francesco", "Neri", "francesco.neri@gmail.com");
		
		
		this.saveFotografoWithAvatar(f1, "01.jpg");
		this.saveFotografoWithAvatar(f2, "02.jpg");
		this.saveFotografoWithAvatar(f3, "03.jpg");
		this.saveFotografoWithAvatar(f4, "04.jpg");
		this.saveFotografoWithAvatar(f5, "05.jpg");
		this.saveFotografoWithAvatar(f6, "06.jpg");
		

		

		
	}
	
	
	private void removeAllFotografi() {
		this.fotografoRepository.deleteAll();
	}
	
	
	private void addAllPictures() {		
		for(int i=1; i<10; i++) {
			String filename = "galleria0" + (Integer.valueOf(i)).toString() + ".jpg";
			this.addPicture(filename, filename, 5L);
		}
		
		for(int i=1; i<3; i++) {
			String filename = "galleria1" + (Integer.valueOf(i)).toString() + ".jpg";
			this.addPicture(filename, filename, 5L);
		}
		
	}
	
	private void addPicture(String filename, String fotoName, Long prezzo) {
		Foto f1 = new Foto(fotoName, prezzo); 
		
		ClassPathResource path = new ClassPathResource("static/images/thumbs/"+ fotoName);

	    byte[] arrayPic;

		try {
			arrayPic = new byte[(int) path.contentLength()];

			 path.getInputStream().read(arrayPic);	

	    	f1.setSorgenteImmagine(new SorgenteImmagine(arrayPic));
		} catch (IOException e) {
			e.printStackTrace();
		}
	   
		
		this.fotoRepository.save(f1);
		
	}
	
	private void saveFotografoWithAvatar(Fotografo fotografo, String filename) {		
		ClassPathResource path = new ClassPathResource("/static/images/fotografiImages/thumbs/"+ filename);

	    byte[] arrayPic;

		try {
			arrayPic = new byte[(int) path.contentLength()];

			 path.getInputStream().read(arrayPic);	

	    	fotografo.setSorgenteAvatar(new SorgenteImmagine(arrayPic));
		} catch (IOException e) {
			e.printStackTrace();
		}
	   
		
		this.fotografoRepository.save(fotografo);
		
	}
	private void addAllRichiesteUtilizzo() {
		RichiestaUtilizzo ru = new RichiestaUtilizzo(LocalDate.now(), "Matteo", "Cognome", "matteo.brandetti@gmail.com");
		RichiestaUtilizzo ru2 = new RichiestaUtilizzo(LocalDate.now(), "Adriano", "Vlad", "adriano.vlad@gmail.com");

		this.richiestaUtilizzoRepository.save(ru);
		this.richiestaUtilizzoRepository.save(ru2);

	}
	
	private void removeAllRichiesteUtlizzo() {
		this.richiestaUtilizzoRepository.deleteAll();
	}
	
	private void removeAllPics() {
		this.fotoRepository.deleteAll();
	}
}
