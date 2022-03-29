package tn.esprit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Domaineentity;
import tn.esprit.entities.Employee;
import tn.esprit.entities.Entreprise;
import tn.esprit.services.EntrepriseService;

@RestController
public class EntrepriseController {
	@Autowired 
	EntrepriseService entrepriseserv;
     
	@PostMapping(value="/addEntreprise", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void addEntreprise(@RequestBody Entreprise entreprise)
	{
		entrepriseserv.ajouterEntreprise(entreprise);
		
	}
	
	@PutMapping(value="/updateEntreprise/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Entreprise updateEntreprise(@PathVariable Long id , @RequestBody Entreprise entreprise)
	{
		entrepriseserv.modifierEntreprise(id,entreprise);
		return entreprise;
	}

	  @DeleteMapping("/removeEntreprise/{EntrepriseId}")
	  @ResponseBody
	   public void deleteEntreprise(@PathVariable("EntrepriseId") Long EntrepriseId){
		 entrepriseserv.deleteEntreprise(EntrepriseId);
	   }

		  @GetMapping("/retrieveEntreprise/{EntrepriseId}")
		   public Entreprise retrieveClient(@PathVariable("EntrepriseId") Long id) {
			   	return entrepriseserv.retrieveEntreprise(id); 
		   }
		
		@GetMapping(value ="/RetrieveEmployee/{idEntreprise}")
		@ResponseBody
		public List<Employee> RetreiveEmployee(@PathVariable("idEntreprise") Long idEntreprise)
		{
			return entrepriseserv.RetreiveEmployee(idEntreprise);
			
		}
		
		
		@GetMapping("/getNbrEmployee/{idEntreprise}")
		@ResponseBody
		public int getNbrEmployee(@PathVariable("idEntreprise") Long idEntreprise){
			return entrepriseserv.getNbrEmployees(idEntreprise);
		}
		
		
		@PutMapping(value="/setdomain/{idEntreprise}", consumes = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody

		public void setDomain(@PathVariable Long idEntreprise,@RequestBody Domaineentity domain)
		{
			 entrepriseserv.setDomain(idEntreprise,domain);
		}
		@GetMapping("/filteremployee/{critere}/{identreprise}")
		@ResponseBody
		
		public List<Employee> FilterEmployee(@PathVariable int critere,@PathVariable Long identreprise)
		{
			return entrepriseserv.FilterEmployee(critere, identreprise);
		}
		
}
