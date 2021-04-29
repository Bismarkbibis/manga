package manga.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import manga.model.Adresse;
import manga.model.Commande;
import manga.model.LigneCommande;
import manga.model.Manga;
import manga.model.Utilisateur;
import manga.repository.CommandeRepository;
import manga.repository.LigneCommandeRepository;
import manga.repository.MangaRepository;

public class PanierService {

	@Autowired
	private CommandeRepository commandeRepository;
	
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	
	@Autowired
	private MangaRepository mangaRepository;
	
	public String NumeroSeri() {
		UUID uuid = UUID.randomUUID();
		String nume = uuid.toString();
		return nume;
	}
	public Commande creatOrder(Utilisateur utilisateur,List<HashMap<String, Integer>> panier, String nom,String prenom,String Rue, String cp,String ville) {
		
		if (!panier.isEmpty()) {
			Commande commande = new Commande();
			commande.setNumero(NumeroSeri());
			commande.setCmdDate(new Date());
			
			Adresse Livraison = new Adresse();
			Livraison.setNom(nom);
			Livraison.setNom(prenom);
			Livraison.setRue(Rue);
			Livraison.setCp(cp);
			Livraison.setVille(ville);
			commande.setAdresseLivraison(Livraison);
			
			Adresse Facture = new Adresse();
			Facture.setNom(nom);
			Facture.setNom(prenom);
			Facture.setRue(Rue);
			Facture.setCp(cp);
			Facture.setVille(ville);
			commande.setAdresseFacture(Facture);
			
			List<LigneCommande> ligneCmd = new ArrayList<>();
			for (HashMap<String, Integer> ligneCommande : panier) {
				
				int idManga =Integer.valueOf(ligneCommande.get("id"));
				Optional<Manga> manga01 =mangaRepository.findById(idManga);
				if (manga01.isPresent()) {
					Manga manga = manga01.get();
					int qteTom =Integer.valueOf(ligneCommande.get("QuantiteTom"));
					LigneCommande lignecommande = new LigneCommande();
					lignecommande.setManga(manga);
					lignecommande.setQte(qteTom);
					lignecommande.setPrixHT(manga.getPrix()*qteTom);
					lignecommande.setTauxTva(manga.getTva().getTaux());
					ligneCmd.add(lignecommande);
				}
			}
			if (ligneCmd.isEmpty()) {
				return null;
			}else {
				commande = commandeRepository.save(commande);
				for (LigneCommande lcd : ligneCmd) {
					lcd.setCommande(commande);
					ligneCommandeRepository.save(lcd);
				}
				return commande;
			}
			}else {
				return null;
			}	
			
		}		
	}

