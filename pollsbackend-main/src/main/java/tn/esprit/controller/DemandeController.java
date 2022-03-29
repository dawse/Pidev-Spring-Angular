package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Demande;
import tn.esprit.entities.Soutretance;
import tn.esprit.entities.User;
import tn.esprit.repository.UserRepository;
import tn.esprit.security.CurrentUser;
import tn.esprit.security.UserPrincipal;
import tn.esprit.service.DemandeService;
import tn.esprit.service.SoutretanceService;
@RestController
@RequestMapping("/api/demande")
@CrossOrigin(origins = "*", maxAge=0)
@PreAuthorize("hasRole('ROLE_ENTERPRISE')")
public class DemandeController {
	
	@Autowired
	private DemandeService demandeService;
	
	@Autowired
	private SoutretanceService soutretanceService;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/add")
	public ResponseEntity<Demande> addDemande(@CurrentUser UserPrincipal currentUser, @RequestBody Demande demande) {
		
		User user = userRepository.getById(currentUser.getId());
		demande.setUserApp(user);
		if(demandeService.addDemande(demande) != null)
			return new ResponseEntity<Demande>(demande, HttpStatus.OK);
		
		return new ResponseEntity<Demande>(HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("update")
	public void updateDemande(Demande demande) {
		
		demandeService.updateDemande(demande);
	}
			
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<HttpStatus> deleteDemande (@CurrentUser UserPrincipal currentUser, @PathVariable("id") int id) {
		
		demandeService.deleteDemande(id);;
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/byId/{demande-id}")
    public ResponseEntity<Demande> retrieveDemande(@PathVariable("demande-id") Integer demandeId) {
		Demande d = demandeService.retrieveDemande(demandeId);
        if(d != null)
        	return new ResponseEntity<Demande>(d, HttpStatus.OK);
        return new ResponseEntity<Demande>(HttpStatus.FORBIDDEN);
    }
	
	@GetMapping("/getAll")
    public List<Demande> getDemandes() {
        return demandeService.retrieveAllDemandes();
    }
	
	@GetMapping("/bestdemande/{id}")
	public ResponseEntity<List<Demande>> getBestDemandes(@PathVariable("id") int id) {
		Soutretance s = soutretanceService.retrieveSoutretance(id);
		if(s == null) return new ResponseEntity<List<Demande>>(HttpStatus.NOT_FOUND);
		
		List<Demande> demande = soutretanceService.getBestDemande(s);
		return new ResponseEntity<List<Demande>>(demande,HttpStatus.OK);
	}

}
