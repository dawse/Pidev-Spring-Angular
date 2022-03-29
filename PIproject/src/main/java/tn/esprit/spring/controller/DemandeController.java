package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Demande;
import tn.esprit.spring.entity.Soutretance;
import tn.esprit.spring.service.DemandeService;
import tn.esprit.spring.service.SoutretanceService;
@RestController
@RequestMapping("/api/demande")
@CrossOrigin(origins = "*", maxAge=0)
public class DemandeController {
	
	@Autowired
	private DemandeService demandeService;
	
	@Autowired
	private SoutretanceService soutretanceService;
	
	@PostMapping("/add")
	public ResponseEntity<Demande> addDemande(@RequestBody Demande demande) {
		
		if(demandeService.addDemande(demande) != null)
			return new ResponseEntity<Demande>(demande, HttpStatus.OK);
		
		return new ResponseEntity<Demande>(HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("update")
	public void updateDemande(Demande demande) {
		
		demandeService.updateDemande(demande);
	}
			
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<HttpStatus> deleteDemande (@PathVariable("id") int id) {
		
		demandeService.deleteDemande(id);
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
