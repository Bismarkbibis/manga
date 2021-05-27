package manga.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import manga.Http.AdressClient;
import manga.model.Commande;
import manga.model.Utilisateur;
import manga.service.AccessSecurityService;
import manga.service.PanierService;

@RestController
@CrossOrigin("*")
public class PanierControlleur {

	@Autowired
	private PanierService panierService;
	@Autowired
	private AccessSecurityService accessSecurityService;
	
	@PostMapping("/commande")
	public ResponseEntity<Commande> clientOrder(HttpServletRequest request,@RequestBody List<HashMap<Integer, Integer>> panier, @RequestBody AdressClient Client) {
		
		Utilisateur utilisateur = accessSecurityService.findUserByToken(request);
		if (!(utilisateur==null)) {
			System.out.println("bismaeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+utilisateur.getIdentifiant());
		   Commande commande = panierService.creatOrderManga(utilisateur, panier, Client.getNom(), Client.getPrenom(),Client.getRue(),Client.getCp(), Client.getVille());
		   return ResponseEntity.ok(commande);
			
		}
		
		return null;
		
	}

}
