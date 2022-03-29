package tn.esprit.service;


import java.util.*;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Reclamation;
import tn.esprit.entities.User;
import tn.esprit.repository.IReclamationRepository;
import tn.esprit.repository.UserRepository;





@Service

public class ReclamationIMPL {


	@Autowired
	IReclamationRepository rr;

	@Autowired
	UserRepository ur;
	@Autowired
	EmailService emailService;
	public void save(Reclamation reclamation, Long EmployeeClaimer, Long EmployeeClaimReiceiver) {

		User EmployeeClaimer1 =ur.findById(EmployeeClaimer).get();
		User EmployeeClaimReiceiver1 =ur.findById(EmployeeClaimReiceiver).get();
		reclamation.setClaimer(EmployeeClaimer1);
		reclamation.setClaimReceiver(EmployeeClaimReiceiver1);
		reclamation.setDate_reclam(new Date());
		rr.save(reclamation);



		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo("entreprisetravel@gmail.com");
		mailMessage.setSubject("reclamation");
		mailMessage.setFrom(reclamation.getClaimer().getEmail_Employee());
		mailMessage.setText(reclamation.getReclam());
		emailService.sendEmail(mailMessage);
		System.out.println("done");

		SimpleMailMessage mailMessageResponse = new SimpleMailMessage();
		mailMessageResponse.setTo(reclamation.getClaimer().getEmail_Employee());
		mailMessageResponse.setSubject("reclamation accept");
		mailMessageResponse.setFrom("entreprisetravel@gmail.com");
		mailMessageResponse.setText("your reclamation is well recieved ! ");
		emailService.sendEmail(mailMessageResponse);
		System.out.println("response done");

	}

	public Reclamation get(Long id) {
		return rr.findById(id).get();
	}

	public void delete(Long id) {
		rr.deleteById(id);
	}


	public Reclamation Update(Reclamation reclamation) {

		return rr.save(reclamation);

	}

	 public List<Reclamation> listAll(){
		return rr.findAll();
	 }

	public int NbreReclams () {
		return ((List<Reclamation>) rr.findAll()).size();
	}




	public int  nbrReclamRecieved(Long idu){
		if(rr.existsByClaimReceiver(ur.findById(idu).get()))
		return ur.findById(idu).get().getReclamation2().size();
		else return 0;
	}

	public Map<String, Integer> triByReclam(){
		Map<String, Integer> m  = new HashMap<String, Integer>();
		ur.findAll().forEach(u-> {
			m.put(u.getNom_Employee(),nbrReclamRecieved(u.getId()));

		});
		return m.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(e1, e2) -> e1,
						LinkedHashMap::new
				));
	}

	public String mostUserReclaimed(){
		return triByReclam().entrySet().stream()
				.max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
	}


	public static Date addDays(Date date, int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); //minus number would decrement the days
		return cal.getTime();
	}


	public int nbrReclamSent(Long u){
		return ur.findById(u).get().getReclamation1().size();
	}


	public int tauxReclamationPerWeek(){
		return (int) (rr.findAll().stream().filter(r->r.getDate_reclam()
						.before(addDays(new Date(),4))
						&& r.getDate_reclam().after(addDays(new Date(),-3)))
				.count())*100/NbreReclams();
	}


	public Map<String, String> tauxSatisfactionEachUser(){
		Map<String,String> m  = new HashMap<String, String>();
		ur.findAll().forEach(u->{
			m.put(u.getNom_Employee(),100-(nbrReclamSent(u.getId())*100/NbreReclams())+"%");
		});
		return m;
	}


}


	
	


	


	




