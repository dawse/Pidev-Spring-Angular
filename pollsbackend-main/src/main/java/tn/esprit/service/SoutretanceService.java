package tn.esprit.service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Demande;
import tn.esprit.entities.Soutretance;
import tn.esprit.entities.Worker;
import tn.esprit.repository.DemandeDAO;
import tn.esprit.repository.SoutretanceDAO;



@Service
public class SoutretanceService {
	
	@Autowired
	private SoutretanceDAO soutretanceDAO;
	
	@Autowired
	private DemandeDAO demandeDAO;
	
	public Soutretance addSoutretance(Soutretance soutretance) {
		
		return soutretanceDAO.saveAndFlush(soutretance);
		
	}
	
	public boolean updateSoutretance(Soutretance soutretance) {
		
		Soutretance s = soutretanceDAO.getById(soutretance.getIdSoutretance());
		if(demandeDAO.countBySoutretance(s) == 0) {
			
			if(soutretance.getDateLivraisonMax() != null)
			s.setDateLivraisonMax(soutretance.getDateLivraisonMax());
			
			if(soutretance.getDescription() != null)
			s.setDescription(soutretance.getDescription());
			
			if(soutretance.getEstimatedTime() != null)
			s.setEstimatedTime(soutretance.getEstimatedTime());
			
			if(soutretance.getNbRequired() != null)
			s.setNbRequired(soutretance.getNbRequired());
			
			if(soutretance.getPrice() != null)
			s.setPrice(soutretance.getPrice());
			
			if(soutretance.getTitre() != null)
			s.setTitre(soutretance.getTitre());
			soutretanceDAO.saveAndFlush(s);
		
			return true;
		}
		return false;
		
	}
	
	public void deleteSoutrance(int id) {
		soutretanceDAO.deleteById(id);
	}
	
	public List<Soutretance> retrieveAllSoutretances() {
		List<Soutretance> soutretance = (List<Soutretance>) soutretanceDAO.findAll();
		return soutretance;
	}
	
	public Soutretance retrieveSoutretance(int id) {
		Soutretance s = null;
		try {
			s =soutretanceDAO.findById(new Integer(id)).get();
		}
		catch(NoSuchElementException e) {
			return null;
		}
		return s;
	}
	
	public List<Demande> getBestDemande(Soutretance s) {
		
		List<Demande> demandes = s.getDemandes();
		for(Demande d:demandes) d.setScore(calculateScore(d));
		
		return demandes.stream().sorted(Comparator.comparing(Demande::getScore).reversed())
			.collect(Collectors.toList());
	}
	
	private long calculateScore(Demande demande) {
		Soutretance s = demande.getSoutretance();
		long score = 0;
		for(Worker w:demande.getWorkers()) {
			switch(w.getGrade()) {
				case J: score+=1;
				break;
				case C1:score+=3;
				break;
				case C2:score+=4;
				break;
				case S1:score+=6;
				break;
				case S2:score+=7;
				break;
			}
		}
		

		if(demande.getEstimadeTime() < s.getEstimatedTime())
			score += s.getEstimatedTime() - demande.getEstimadeTime() * 0.5;
		if(s.getDateLivraisonMax().getTime() - demande.getDateFin().getTime() > 0)
			score+= s.getDateLivraisonMax().getTime() - demande.getDateFin().getTime()*0.5;
		
		return score;
		
	}

}
