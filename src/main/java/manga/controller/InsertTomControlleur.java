package manga.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import manga.Http.InsertTom;
import manga.Outile.CustomedException;
import manga.model.Role;
import manga.model.Tom;
import manga.model.Utilisateur;
import manga.service.AccessSecurityService;
import manga.service.AdminService;

@RestController
@CrossOrigin("*")
public class InsertTomControlleur {
	@Autowired
	private AccessSecurityService accessSecurityService;
	@Autowired
	private AdminService adminService;

	@PostMapping("/insert-tom")
	public ResponseEntity<Tom> inserTomManga(HttpServletRequest request, Utilisateur utilisateur,
			@RequestBody InsertTom tom) {
		Boolean admin = accessSecurityService.verifyRole(request, Role.ADMIN);

		if (admin) {
			try {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<"+admin);
				Tom tom2 = adminService.insertTomManga(utilisateur, tom.getNom(), tom.getManga(),tom.getNumero(),tom.getNombrePage(), tom.getDateSortir(), tom.getNumImage(), tom.getTitre(),tom.getPrix(), tom.getDescription());
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+tom2);
				return ResponseEntity.ok(tom2);
			} catch (CustomedException e) {
				e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			}
		}
		return null;

	}
}
