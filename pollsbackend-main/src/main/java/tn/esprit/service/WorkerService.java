package tn.esprit.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Worker;
import tn.esprit.repository.WorkerDAO;

@Service
public class WorkerService {

	
	@Autowired
	private WorkerDAO workerDAO;
	
	public Worker addWorker(Worker worker) {
		
		return workerDAO.saveAndFlush(worker);
		
	}
	
	public void updateWorker(Worker worker) {
			
			Worker w = workerDAO.getById(worker.getIdWorker());
			
				
				if(worker.getFirstName() != null)
				w.setFirstName(worker.getFirstName());
				
				if(worker.getLastName() != null)
				w.setLastName(worker.getLastName());
				
				if(worker.getGrade() != null)
				w.setGrade(worker.getGrade());
				
				if(worker.getNumTel() != null)
				w.setNumTel(worker.getNumTel());
				
				if(worker.getEmail() != null)
				w.setEmail(worker.getEmail());
				
				workerDAO.saveAndFlush(w);
			
			
	}
	
	public void deleteWorker(int id) {
		workerDAO.deleteById(id);
	}
	
	public List<Worker> retrieveAllWorkers() {
		List<Worker> worker = (List<Worker>) workerDAO.findAll();
		return worker;
	}
	
	public Worker retrieveWorker(Integer id) {
		Worker w;
		try {
			
			 w =workerDAO.findById(id).get();

		}
		catch(NoSuchElementException e) {
			return null;
		}

		return w;
	}

}
