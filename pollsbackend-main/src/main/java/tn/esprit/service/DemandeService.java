package tn.esprit.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Demande;
import tn.esprit.entities.Soutretance;
import tn.esprit.repository.DemandeDAO;
import tn.esprit.repository.SoutretanceDAO;


@Service
public class DemandeService {
	
	@Autowired
	private DemandeDAO demandeDAO;
	
	@Autowired
	private SoutretanceDAO soutretanceDAO;
	
	public Demande addDemande(Demande demande) {
		
		Soutretance s = soutretanceDAO.getById(demande.getSoutretance().getIdSoutretance());
		return demandeDAO.saveAndFlush(demande);
		
	}
	
	public void updateDemande(Demande demande) {
			
			Demande d = demandeDAO.getById(demande.getIdDemande());
			
				
				if(demande.getDateDebut() != null)
				d.setDateDebut(demande.getDateDebut());
				
				if(demande.getDateFin() != null)
				d.setDateFin(demande.getDateFin());
				
				if(demande.getEstimadeTime() != null)
				d.setEstimadeTime(demande.getEstimadeTime());
				
				
				demandeDAO.saveAndFlush(d);
			
			
	}
	
	public void deleteDemande(int id) {
		demandeDAO.deleteById(id);
	}
	
	public List<Demande> retrieveAllDemandes() {
		List<Demande> demande = (List<Demande>) demandeDAO.findAll();
		return demande;
	}
	
	public Demande retrieveDemande(Integer id) {
		Demande d;
		try {
			
			 d =demandeDAO.findById(id).get();

		}
		catch(NoSuchElementException e) {
			return null;
		}

		return d;
	}

}
