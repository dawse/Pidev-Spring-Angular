package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Employee;

import tn.esprit.services.EmployeeService;


@RestController
public class EmployeeController {

	@Autowired
	EmployeeService serviceemployee ; 
	
	@PostMapping(value="/ajouterEtAffecteremployeeToentreprise/{identreprise}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee ajouterEtAffecteremployeeToentreprise(@RequestBody Employee employee ,@PathVariable("identreprise") Long identreprise){
		return serviceemployee.addemployeeAndAsseignToentreprise(employee, identreprise); 
    }
	
	
	
	@PutMapping(value="/updateEmployee/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Employee updateEntreprise(@PathVariable Long id , @RequestBody Employee employee)
	{
		serviceemployee.modifierEmployee(id,employee);
		return employee;
	}

	 @org.springframework.web.bind.annotation.DeleteMapping("/removeEmployee/{employeeId}")
	   public void removeClient(@PathVariable("employeeId") Long employeeId){
		 serviceemployee.deleteEmployee(employeeId);
	   }

		@org.springframework.web.bind.annotation.GetMapping("/retrieveEmployee/{EmployeeId}")
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
