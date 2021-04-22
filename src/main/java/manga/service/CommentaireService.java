package manga.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manga.model.Commentaire;
import manga.model.Manga;
import manga.model.Utilisateur;
import manga.repository.CommentaireRepository;
import manga.repository.MangaRepository;

@Service
public class CommentaireService {

	@Autowired
	private MangaRepository mangaRepository;
	@Autowired
	private CommentaireRepository commentaireRepository;

	public Commentaire insertAvis(Utilisateur utilisateur, int idManga, String Commentaire) throws Exception {
		Exception exception = new Exception("le manga que vous essayais de mettre un commentaire n'est pas disponible");
		if (!Commentaire.isEmpty()) {
			Commentaire commentaire = new Commentaire();
			Optional<Manga> manga = mangaRepository.findById(idManga);
			if (manga.isPresent()) {
				Manga manga2 = manga.get();
				commentaire.setAvis(Commentaire);
				commentaire.setIdentifiant(utilisateur.getIdentifiant());
				commentaire.setUtilisateur(utilisateur);
				commentaire.setManga(manga2);
				commentaire.setCmmDate(new Date());
				commentaireRepository.save(commentaire);
				return commentaire;
			} else {
				throw exception;
			}
		}
		return null;
	}

	public List<Commentaire> getAllCommentaire() {
		List<Commentaire> avis = commentaireRepository.findAll();
		return avis;
	}

}
