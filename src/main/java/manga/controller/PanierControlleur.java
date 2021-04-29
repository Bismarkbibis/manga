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
	public ResponseEntity<Commande> clientOrder(HttpServletRequest request,@RequestBody List<HashMap<String, Integer>> panier, @RequestBody AdressClient adressClient) {
		
		Utilisateur utilisateur = accessSecurityService.findUserByToken(request);
		
		if (!(utilisateur==null)) {
		   Commande commande = panierService.creatOrder(utilisateur, panier, adressClient.getNom(), adressClient.getPrenom(), adressClient.getRue(),adressClient.getCp(), adressClient.getVille());
		   return ResponseEntity.ok(commande);
			
		}
		
		return null;
		
	}

}
