package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Employee;
import tn.esprit.entities.Entreprise;
import tn.esprit.repositories.EmployeeRepository;
import tn.esprit.repositories.EntrepriseRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired 
	EmployeeRepository employeerepo;

	@Autowired 
	EntrepriseRepository entrerepo;
	
	public Employee addemployeeAndAsseignToentreprise(Employee employee, Long entrepriseid) {
		
		Entreprise entreprise = entrerepo.findById(entrepriseid).get();  
		employee.setEntreprise(entreprise);
		employeerepo.save(employee); 
		return employee;
	}
	
	@Override
	public Employee modifierEmployee(Long id, Employee e ) {
		Employee e_change = employeerepo.findById(id).get();
		e_change.setAdresse(e.getAdresse());
		e_change.setAge(e.getAge());
		e_change.setPrenom(e.getPrenom());
		e_change.setCin(e.getCin());
		e_change.setEmail(e.getEmail());
		e_change.setExperience(e.getExperience());
		e_change.setTelephone(e.getTelephone());
		e_change.setNom(e.getNom());
		employeerepo.save(e_change);
		return e;
	}
	@Override
	public void deleteEmployee(Long id){
		// TODO Auto-generated method stub
		employeerepo.deleteById(id);
		
	}
	

	@Override
	public Employee retrieveEmployee(Long id) {
		// TODO Auto-generated method stub
		
		return employeerepo.findById(id).get() ;
	}
    
	
	public void setBadge(Long idemployee)
	{  
		Employee employee = employeerepo.findById(idemployee).get();
		if (employee.getExperience()<2)
		{
			employee.setBadge("JUNIOR");
		}
		if ((employee.getExperience()>2)&&(employee.getExperience()<10))
		{
			employee.setBadge("Senior");
		}
		if (employee.getExperience()>=10)
		{
			employee.setBadge("Experimentée");
		}
	
		employeerepo.save(employee);
	}
	
	
	
}
