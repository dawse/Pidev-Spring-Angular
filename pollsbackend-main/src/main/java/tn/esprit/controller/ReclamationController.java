package tn.esprit.controller;



import org.springframework.beans.factory.annotation.Autowired;











import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.entities.Reclamation;
import tn.esprit.repository.UserRepository;
import tn.esprit.service.ReclamationIMPL;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/BusinessT")
public class ReclamationController {
	@Autowired
	ReclamationIMPL reclamService;
	@Autowired
	UserRepository employeerepo;
	
	
	
	@GetMapping("/List-reclam")
	public List<Reclamation> list() {
		return reclamService.listAll();
	}

	
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Reclamation> get(@PathVariable Long id) {
		try {
			Reclamation reclamation = reclamService.get(id);
			return new ResponseEntity<Reclamation>(reclamation, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Reclamation>(HttpStatus.NOT_FOUND);
		}
	}

	
	
	@PostMapping("/add/{idc}/{idr}")
	@ResponseBody
	public void add(@RequestBody Reclamation reclamation ,@PathVariable("idc") Long EmployeeClaimer, @PathVariable("idr") Long EmployeeClaimReiceiver) {
	
		
	

		reclamService.save(reclamation, EmployeeClaimer, EmployeeClaimReiceiver);
			
		
		

	}
	

	
	@PutMapping(value="/update")

    public Reclamation Update(@RequestBody Reclamation reclamation){
        return  reclamService.Update(reclamation);
	}
        
	@DeleteMapping("/Delete-reclam/{id}")
	public void delete(@PathVariable Long id) {
		reclamService.delete(id);
	}
	@ResponseBody
	@GetMapping("/nbr")
	public int NbreReclams () {
		return reclamService.NbreReclams();
	}

	@ResponseBody
	@GetMapping("/nbr/{id}")
	public int  nbrReclamRecieved(@PathVariable("id") Long idu){
		return reclamService.nbrReclamRecieved(idu);
	}

	@GetMapping("/tri")
	@ResponseBody
	public Map<String, Integer> triByReclam(){
		return 	reclamService.triByReclam();
	}
	@GetMapping("/taux")
	@ResponseBody
	public String tauxReclamationPerWeek(){
		return "Reclamation rate this week : "+reclamService.tauxReclamationPerWeek()+"%";
	}

	@GetMapping("/satisfaction")
	@ResponseBody
	public Map<String, String> tauxSatisfactionEachUser(){
		return  reclamService.tauxSatisfactionEachUser();
	}


	
	}
