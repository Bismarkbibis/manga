package manga.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import manga.Outile.CustomedException;
import manga.model.Reservation;
import manga.model.Utilisateur;
import manga.service.AccessSecurityService;
import manga.service.EmprunterService;

@RestController
@CrossOrigin("*")
public class ReservationControlleur {

	@Autowired
	private AccessSecurityService accessSecurityService;
	
	@Autowired
	private EmprunterService emprunterService;
	
	@PostMapping("/client-reserve")
	private ResponseEntity<Reservation> ClientReservation (HttpServletRequest request,@RequestBody List<HashMap<String, String>> mangaReserve){
		
		Utilisateur utilisateur =accessSecurityService.findUserByToken(request);
		if (utilisateur!= null) {
			System.out.println(""+utilisateur);
			try {
				Reservation reservation = emprunterService.clientReserve(utilisateur, mangaReserve);
				System.out.println(""+reservation);
				return ResponseEntity.ok(reservation);
			} catch (CustomedException e) {
				e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			}
			
		}
		return null;
	}
}
