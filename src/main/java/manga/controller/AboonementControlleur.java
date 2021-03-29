package manga.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import manga.Http.AbonnementClient;

@RestController
@CrossOrigin
public class AboonementControlleur {

	
	@PostMapping("/abonnement")
	public String abonnement(HttpServletRequest request,@RequestBody AbonnementClient infoClientAbonnee ) {
		
		String token= request.getHeader("Authorization");
		System.out.println("  "+token);
		
		return"abonnee";
	}
}
