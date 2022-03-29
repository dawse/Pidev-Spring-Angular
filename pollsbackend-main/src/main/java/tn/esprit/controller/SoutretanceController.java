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

import tn.esprit.config.EmailService;
import tn.esprit.entities.Demande;
import tn.esprit.entities.Soutretance;
import tn.esprit.entities.User;
import tn.esprit.repository.UserRepository;
import tn.esprit.security.CurrentUser;
import tn.esprit.security.UserPrincipal;
import tn.esprit.service.DemandeService;
import tn.esprit.service.SoutretanceService;

@RestController
@RequestMapping("/api/soutretance")
@CrossOrigin(origins = "*", maxAge=0)
@PreAuthorize("hasRole('ROLE_ENTERPRISE')")
public class SoutretanceController {
	
	@Autowired
	private SoutretanceService soutretanceService;
	
	@Autowired DemandeService demandeService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/add")
	public Soutretance addSoutretance(@CurrentUser UserPrincipal currentUser, @RequestBody Soutretance soutretance) {
		
		User user = userRepository.findById(currentUser.getId()).get();
		soutretance.setUserApp(user);
		return soutretanceService.addSoutretance(soutretance);
		
	}
	
	@PostMapping("update")
	public ResponseEntity<HttpStatus> updateSoutretance(Soutretance soutretance) {
		
		if(soutretanceService.updateSoutretance(soutretance)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<HttpStatus> deleteSoutretance (@PathVariable("id") int id) {
		
		soutretanceService.deleteSoutrance(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("/byid/{id}")
    public Soutretance retrieveClient(@PathVariable("id") int soutretanceId) {
        return soutretanceService.retrieveSoutretance(soutretanceId);
    }
	
	@GetMapping("/getAll")
    public List<Soutretance> getSoutretances() {
		return soutretanceService.retrieveAllSoutretances();
    }
	
	@DeleteMapping("/acceptSoutretance/{id}")
	public ResponseEntity<HttpStatus> acceptDemande(@PathVariable("id") int id) {
		Demande d = demandeService.retrieveDemande(id);
		StringBuilder str
        = new StringBuilder();
		str.append("Hello,");
		str.append("Your demand with id:"+ d.getIdDemande() + "for the enterprise:"+ d.getSoutretance().getUserApp().getNom_Entreprise() +" is accepted,");
		str.append("Please contact the enterprise with the email:"+d.getSoutretance().getUserApp().getEmail());
		emailService.sendSimpleMessage(d.getUserApp().getEmail(), "Demande Accepted", str.toString());
		soutretanceService.deleteSoutrance(d.getSoutretance().getIdSoutretance());
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
