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
import manga.model.Manga;
import manga.model.MangaStatue;
import manga.model.Role;
import manga.model.Tom;
import manga.model.Tva;
import manga.model.Utilisateur;

import manga.repository.ActualiterRepository;
import manga.repository.CataloguePageRepository;
import manga.repository.MangaRepository;
import manga.repository.MangaStatueRepository;
import manga.repository.RoleRepository;
import manga.repository.TomRepository;
import manga.repository.TvaRepository;
import manga.repository.UtilisateurRepository;
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
	private MangaStatueRepository mangaStatueRepository;



	@Autowired
	private CataloguePageRepository cataloguePageRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private TvaRepository tvaRepository;
	@Autowired
	private MangaRepository mangaRepository;
	@Autowired
	private TomRepository tomRepository;
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
			
			Tva tva01 = new Tva();
			tva01.setNom("TVA de 20 %");
			tva01.setTaux(20);
			Tva tva02 = new Tva();
			tva02.setNom("TVA de 30 %");
			tva02.setTaux(30);
			tvaRepository.save(tva01);
			tvaRepository.save(tva02);
			
			MangaStatue mangaStatue01 = new MangaStatue(MangaStatue.DISPONIBLE);
			mangaStatueRepository.save(mangaStatue01);
			MangaStatue mangaStatue02 = new MangaStatue(MangaStatue.PRETER);
			mangaStatueRepository.save(mangaStatue02);
			MangaStatue mangaStatue03 = new MangaStatue(MangaStatue.RESERVER);
			mangaStatueRepository.save(mangaStatue03);
			
			
			
			Manga manga = new Manga("Inazuma", "AZERTYUI93", "one.jpg", "one piece tom 3", "meilleur manga du monde", 233, 4, "dispoble", date, 12,24,Manga.PRETER);
			manga.setTva(tva02);
			manga.setMangaStatue(mangaStatue01);
			mangaRepository.save(manga);
			Manga manga1 = new Manga("One piece", "AZERTYUI93", "one.jpg", "one piece tom 3", "meilleur manga du monde", 233, 4, "dispoble", date, 12,24,Manga.DISPONIBLE);
			manga1.setTva(tva02);			
			mangaRepository.save(manga1);
			Manga manga2 = new Manga("Bibo","AZERTYUI93", "one.jpg", "one piece tom 3", "meilleur manga du monde", 233, 4, "dispoble", date, 12,24,Manga.DISPONIBLE);
			manga2.setTva(tva02);
			mangaRepository.save(manga2);
			Manga manga3 = new Manga("Naza one","AZERTYUI93", "one.jpg", "one piece tom 3", "meilleur manga du monde", 233, 4, "dispoble", date, 12,24,Manga.DISPONIBLE);
			manga3.setTva(tva02);
			mangaRepository.save(manga3);
			Manga mang4 = new Manga("Dragon ball z","1133334", "one.jpg", "one piece tom 3", "meilleur manga du monde", 233, 4, "dispoble", date, 12,24,Manga.DISPONIBLE);
			mang4.setTva(tva02);
			mangaRepository.save(mang4);
			Manga manga5 = new Manga("Naruto", "AZERTYUI93", "one.jpg", "one piece tom 3", "meilleur manga du monde", 233, 4, "dispoble", date, 12,24,Manga.DISPONIBLE);
			manga5.setTva(tva02);
			mangaRepository.save(manga5);
			Manga manga6 = new Manga("Boruto", "AZERTYUI93", "one.jpg", "one piece tom 3", "meilleur manga du monde", 233, 4, "dispoble", date, 12,24,Manga.DISPONIBLE);
			manga6.setTva(tva02);
			mangaRepository.save(manga6);
			Manga manga7 = new Manga("Prison school", "AZERTYUI93", "one.jpg", "one piece tom 3", "meilleur manga du monde", 233, 4, "dispoble", date, 12,24,Manga.DISPONIBLE);
			manga7.setTva(tva02);
			mangaRepository.save(manga7);
			
			Tom tom = new Tom();
			tom.setNumImage("Manga.jpeg");
			tom.setNom("One piece l'arc de luffy");
			tom.setNumero(3);
			tom.setTomStatue(Tom.DISPONIBLE);
			tom.setManga(manga);
			tom.setNumSeri("Azertyuio12");
			tom.setDateDeSortie(date);
			tom.setDescription("tom manga de l'annee");
			tom.setManga(manga);
			tom.setMangaStatue(mangaStatue01);
			tom.setPrix(12);
			tom.setTitre("One piece l'arc de luffy");
			tomRepository.save(tom);
			
			
			
			CataloguePage AbonneCataloque = new CataloguePage();
			cataloguePageRepository.save(AbonneCataloque);

			CataloguePage ClientCataloque = new CataloguePage(CataloguePage.catalogueClient);
			cataloguePageRepository.save(ClientCataloque);

			CataloguePage InviteCataloque = new CataloguePage(CataloguePage.catalogueInviter);
			cataloguePageRepository.save(InviteCataloque);
//			LocalDate date2 =LocalDate.of(1999, 04, 15);

			Utilisateur adminUser = new Utilisateur(" Bismark01", "Bob", "marley", "bob@gmail.com", "15/04/199",21,"0659940110", encode,Utilisateur.active,0);
			adminUser.setRole(admin);
			utilisateurRepository.save(adminUser);			

		};
	}

}
