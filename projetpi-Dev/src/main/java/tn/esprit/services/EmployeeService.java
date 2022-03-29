package tn.esprit.services;

import tn.esprit.entities.Employee;

public interface EmployeeService {
	
	public Employee addemployeeAndAsseignToentreprise(Employee employee, Long entrepriseid);

	Employee modifierEmployee(Long id, Employee e);

	void deleteEmployee(Long id);


	public Employee retrieveEmployee(Long id);
	public void setBadge(Long idemployee);

}
