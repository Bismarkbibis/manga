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
import manga.model.CataloguePage;
import manga.model.Offre;
import manga.model.Role;
import manga.model.Tva;
import manga.model.TvaAbonnement;
import manga.model.Utilisateur;
import manga.model.Abonnement;
import manga.repository.AbonnementRepository;
import manga.repository.ActualiterRepository;
import manga.repository.CataloguePageRepository;
import manga.repository.OffreRepository;
import manga.repository.RoleRepository;
import manga.repository.TvaAbonnementRepository;
import manga.repository.TvaRepository;
import manga.repository.UtilisateurRepository;
import manga.service.AbonnementService;
import manga.service.PasswordEncoderService;

@SpringBootApplication
public class MangaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangaApplication.class, args);

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

	@Autowired
	private AbonnementService abonnementService;

	@Autowired
	private CataloguePageRepository cataloguePageRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private TvaRepository tvaRepository;
	@Bean
	CommandLineRunner run() {
		return args -> {
			GregorianCalendar calandar = new GregorianCalendar(2017, 4, 21);
			Date date = calandar.getTime();
			int mois = calandar.get(Calendar.MONTH * 1);
			// password
			String password = "123456789";
			String encode = passwordEncoderService.encoder(password);

			Actualiter actualiter = new Actualiter("Tres bon manga", date);
			actualiterRepository.save(actualiter);

			Role user = new Role(Role.USER);
			Role admin = new Role(Role.ADMIN);
			roleRepository.save(user);
			roleRepository.save(admin);

			Abonnement abonnement01 = new Abonnement();

			TvaAbonnement tvaAbonnement = new TvaAbonnement();
			tvaAbonnement.setNom("Taux de 30%");
			tvaAbonnement.setTaux(30);
			tvaAbonnementRepository.save(tvaAbonnement);
			
			Tva tva01 = new Tva();
			tva01.setNom("TVA de 20 %");
			tva01.setTaux(20);
			Tva tva02 = new Tva();
			tva02.setNom("TVA de 30 %");
			tva02.setTaux(30);
			tvaRepository.save(tva01);
			tvaRepository.save(tva02);
			
			
			Offre offre = new Offre();
			offre.setPrixHt(20);
			offre.setNom(Offre.deuxieme);
			offre.setAbonnement(abonnement01);
			offre.setTvaAbonnement(tvaAbonnement);

			abonnement01.setDate(date);
			abonnement01.setDuree(mois);
			abonnement01.setPrenom("Bismark");
			abonnement01.setNom("Boakye");
			abonnement01.setPrix(offre.getPrixHt());
			abonnement01.setNumeroabonnement(abonnementService.genereNumbre());
			abonnementRepository.save(abonnement01);

			offreRepository.save(offre);

			CataloguePage AbonneCataloque = new CataloguePage(CataloguePage.catalogueAbonnee);
			cataloguePageRepository.save(AbonneCataloque);

			CataloguePage ClientCataloque = new CataloguePage(CataloguePage.catalogueClient);
			cataloguePageRepository.save(ClientCataloque);

			CataloguePage InviteCataloque = new CataloguePage(CataloguePage.catalogueInviter);
			cataloguePageRepository.save(InviteCataloque);
//			LocalDate date2 =LocalDate.of(1999, 04, 15);
			
			Utilisateur adminUser = new Utilisateur("Bismark01", "Bob", "marley", "bob@gmail.com", 23,"0659940110", encode);
			adminUser.setRole(admin);
			utilisateurRepository.save(adminUser);

		};
	}

}
