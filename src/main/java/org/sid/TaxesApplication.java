package org.sid;

import java.util.Date;
import org.sid.dao.EntrepriseRepository;
import org.sid.dao.TaxeRepository;
import org.sid.entities.Entreprise;
import org.sid.entities.IR;
import org.sid.entities.TVA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaxesApplication implements CommandLineRunner{

	@Autowired
private EntrepriseRepository etrepriseRepository;
	@Autowired
	TaxeRepository taxeRepository;
	public static void main(String[] args) {
		SpringApplication.run(TaxesApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Entreprise e1=etrepriseRepository.save( new Entreprise(null, "E1","E1@gmail.com","SARL", null));
		Entreprise e2=etrepriseRepository.save( new Entreprise(null, "E2","E2@gmail.com","SARL2", null));
		taxeRepository.save(new TVA(null, "TVA Habitation", new Date(), 9000, e1));
		taxeRepository.save(new TVA(null, "TVA Voiture", new Date(), 400, e1));
		taxeRepository.save(new IR(null, "IR 2016", new Date(), 9000, e1));
		taxeRepository.save(new TVA(null, "TVA Habitation", new Date(), 5000, e2));
		
	}
}
