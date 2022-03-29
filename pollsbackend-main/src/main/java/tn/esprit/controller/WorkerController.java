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

import tn.esprit.entities.Worker;
import tn.esprit.service.WorkerService;

@RestController
@RequestMapping("/api/worker")
@CrossOrigin(origins = "*", maxAge=0)
@PreAuthorize("hasRole('ROLE_ENTERPRISE')")
public class WorkerController {
	
	@Autowired
	private WorkerService workerService;
	
	@PostMapping("/add")
	public Worker addWorker(@RequestBody Worker worker) {
		
		return workerService.addWorker(worker);
		
	}
	
	@PostMapping("update")
	public void updateWorker(Worker worker) {
		
		workerService.updateWorker(worker);
	}
			
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<HttpStatus> deleteWorker (@PathVariable("id") int id) {
		
		workerService.deleteWorker(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/byId/{worker-id}")
    public ResponseEntity<Worker> retrieveWorker(@PathVariable("worker-id") Integer workerId) {
		Worker w = workerService.retrieveWorker(workerId);
        if(w != null)
        	return new ResponseEntity<Worker>(w, HttpStatus.OK);
        return new ResponseEntity<Worker>(HttpStatus.FORBIDDEN);
    }
	
	@GetMapping("/getAll")
    public List<Worker> getWorkers() {
        return workerService.retrieveAllWorkers();
    }

}
