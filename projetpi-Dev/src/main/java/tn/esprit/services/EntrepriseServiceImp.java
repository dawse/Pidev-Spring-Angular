package tn.esprit.services;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.entities.Domaine;
import tn.esprit.entities.Domaineentity;
import tn.esprit.entities.Employee;
import tn.esprit.entities.Entreprise;
import tn.esprit.entities.Word;
import tn.esprit.repositories.DomaineRepository;
import tn.esprit.repositories.EmployeeRepository;
import tn.esprit.repositories.EntrepriseRepository;
import tn.esprit.repositories.WordDao;




@Service
public class EntrepriseServiceImp implements EntrepriseService {

	@Autowired
	EntrepriseRepository entrepriserepo;
	@Autowired
	EmployeeRepository employeerepo;
	@Autowired
	DomaineRepository domainrepo;
	
	@Override
	public Entreprise ajouterEntreprise(Entreprise e) {
		entrepriserepo.save(e);
		return e;
		
	}

	@Override
	public Entreprise modifierEntreprise(Long id, Entreprise e ) {
		Entreprise e_change = entrepriserepo.findById(id).get();
		e_change.setAdresse(e.getAdresse());
		e_change.setCategorie(e.getCategorie());
		e_change.setContact(e.getContact());
		e_change.setNom(e.getNom());
		entrepriserepo.save(e_change);
		return e; 
	}
	@Override
	public void deleteEntreprise(Long id) {
		// TODO Auto-generated method stub
		entrepriserepo.deleteById(id);
		
	}
	

	@Override
	public Entreprise retrieveEntreprise(Long id) {
		// TODO Auto-generated method stub
		
		return entrepriserepo.findById(id).get() ;
	}
	
	public List<Employee> RetreiveEmployee(Long idEntreprise)
	
	{ 
		Entreprise entreprise = entrepriserepo.findById(idEntreprise).get();
		 
		return  entreprise.getEmployees();
		
		
	}
	public int getNbrEmployees(Long idEntreprise)
	{
		Entreprise entreprise =entrepriserepo.findById(idEntreprise).get();
		return entreprise.getEmployees().size();
	}
	
	
	@Autowired
	WordDao worddao;
	public Domaineentity addDomain(Domaineentity Domaine)
	{
	 
	 domainrepo.save(Domaine);

     return Domaine;
	}
	
	
	public void setDomain(Long idEntreprise,Domaineentity domain)
	{  
	    List<Word> domaine1 = new ArrayList();
	    List<Domaineentity> domaine2 = new ArrayList();
	    Domaineentity domain3 =new Domaineentity();
	    Entreprise e = entrepriserepo.findById(idEntreprise).get();
	    domaine1= worddao.synonyms("Informatique");
	    String j=domain.getValue();
        int nb=domaine1.size();
        domaine2= (List<Domaineentity>) domainrepo.findAll();
        String ch= "Informatique";
  		for ( Domaineentity k : domaine2)
  		{ if (ch.equals(k.getValue()))
  	        
  	        	domain3= k;
  		} 
  	        
  	        
        for (int i=0; i <nb; i++)
        {  
        	if (j.equals(domaine1.get(i).getValue())){
        		
        
        		
            		 e.setDomaine(domain3);
        		
                   

        
	}else{if((i==nb-1)){
		 addDomain(domain);
    	 e.setDomaine(domain);
		
	}	
	}
	}
    }
	
	@Override
	public List<Employee> FilterEmployee(int critere,Long identreprise) {
		 Entreprise e = entrepriserepo.findById(identreprise).orElse(null);
			List<Employee> empl = new ArrayList<Employee>(); 
			List<Employee> emlpf = new ArrayList<Employee>();
			empl=e.getEmployees();
		switch(critere){
        case 1: {emlpf=empl;break;}
	    case 2 : {for (Employee i :empl)
	        {
			System.out.println(i.getBadge());
			if(i.getBadge().equals("Senior")){
				System.out.println(i.getId());
	        	emlpf.add(i);
	        }
	        }
	        	
	        return emlpf;}
	        case 3:for (Employee i :empl)
	        {if(i.getBadge()=="JUNIOR"){
	        	emlpf.add(i);
	        }
	        }
	        return emlpf;
	        case 4:for (Employee i :empl)
	        {if(i.getBadge()=="Experimentée"){
	        	emlpf.add(i);
	        }
	        }
	        return emlpf;
	        default:
	            System.out.println("Choix incorrect");
	            break;
	    }
		return emlpf;	
	}
	
	}


	

