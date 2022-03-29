package tn.esprit.repository;









import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.User;


@Repository

public interface IReclamationRepository extends JpaRepository<Reclamation,Long>{
public Boolean existsByClaimReceiver(User u);


}

	
	

	

	
	
	


