package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Employee;

import tn.esprit.services.EmployeeService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService serviceemployee ; 
	
	@PostMapping(value="/ajouterEtAffecteremployeeToentreprise/{identreprise}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee ajouterEtAffecteremployeeToentreprise(@RequestBody Employee employee ,@PathVariable("identreprise") Long identreprise){
		return serviceemployee.addemployeeAndAsseignToentreprise(employee, identreprise); 
    }
	
	
	
	@PutMapping(value="/updateEmployee",consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Employee updateEntreprise(  @RequestBody Employee employee)
	{
		serviceemployee.modifierEmployee(employee);
		return employee;
	}
	
	  
	   @DeleteMapping("/removeEmployee/{employeeId}")

	   @ResponseBody
	   public void removeClient(@PathVariable("employeeId") Long employeeId){
		 serviceemployee.deleteEmployee(employeeId);
	   }

		@org.springframework.web.bind.annotation.GetMapping("/retemp/{EmployeeId}")
		   public Employee retrieveClient(@PathVariable("EmployeeId") Long EmployeeId) {
			   	return serviceemployee.retrieveEmployee(EmployeeId) ;
		   }
		
		@PutMapping(value="/badgeEmployee/{id}")
		@ResponseBody
		public void setBadge(@PathVariable Long id)
		{
			serviceemployee.setBadge(id);
		}
	    
}
