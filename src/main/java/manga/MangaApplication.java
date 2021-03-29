package manga;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import manga.model.Actualiter;
import manga.model.Offre;
import manga.model.Role;
import manga.model.TvaAbonnement;

import manga.model.abonnement;
import manga.repository.AbonnementRepository;
import manga.repository.ActualiterRepository;
import manga.repository.OffreRepository;
import manga.repository.RoleRepository;
import manga.repository.TvaAbonnementRepository;

import manga.service.PasswordEncoderService;


@SpringBootApplication
public class MangaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangaApplication.class, args);
		System.out.println("bismark");
	}

	@Autowired
	private ActualiterRepository actualiterRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoderService passwordEncoderService; 
	@Autowired
	private AbonnementRepository abonnementRepository;
	@Autowired
	private OffreRepository offreRepository;

	@Autowired
	private TvaAbonnementRepository tvaAbonnementRepository;
	@Bean
	CommandLineRunner run() {
		return args -> {
			GregorianCalendar calandar = new GregorianCalendar(2017, 4, 21);
			Date date = calandar.getTime();
			int mois = calandar.get(Calendar.MONTH*1);
			//password
			String password = "123456";
			String encode = passwordEncoderService.encoder(password);

			Actualiter actualiter = new Actualiter("Tres bon manga", date);
			actualiterRepository.save(actualiter);
			
			Role user = new Role(Role.USER);
			Role admin = new Role(Role.ADMIN);
			roleRepository.save(user);
			roleRepository.save(admin);

			abonnement abonnement01 = new abonnement();

			TvaAbonnement tvaAbonnement =new TvaAbonnement();
			tvaAbonnement.setNom("Taux de 30%");
			tvaAbonnement.setTaux(30);
			tvaAbonnementRepository.save(tvaAbonnement);
			
			Offre offre = new Offre();
			offre.setPrixHt(20);
			offre.setNom(Offre.deuxieme);
			offre.setAbonnement(abonnement01);
			offre.setTvaAbonnement(tvaAbonnement);
			
//			abonnement01.setDate(date);
			abonnement01.setDuree(mois);
			abonnement01.setPrenom("Bismark");
			abonnement01.setNom("Boakye");
			abonnement01.setPrix(offre.getPrixHt());
			abonnementRepository.save(abonnement01);
			
			offreRepository.save(offre);
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><"+abonnement01);
			
		 };
	}

}
