package tn.esprit.payload;

import javax.persistence.Column;

public class EnterprisePayload {
	
	    
	    private String nom_Entreprise;
	
		private String categorie_Entreprise;
		
		private String adresse_Entreprise;
		
		private String contact_Entreprise;
		
		

		public String getNom_Entreprise() {
			return nom_Entreprise;
		}

		public void setNom_Entreprise(String nom_Entreprise) {
			this.nom_Entreprise = nom_Entreprise;
		}

		public String getCategorie_Entreprise() {
			return categorie_Entreprise;
		}

		public void setCategorie_Entreprise(String categorie_Entreprise) {
			this.categorie_Entreprise = categorie_Entreprise;
		}

		public String getAdresse_Entreprise() {
			return adresse_Entreprise;
		}

		public void setAdresse_Entreprise(String adresse_Entreprise) {
			this.adresse_Entreprise = adresse_Entreprise;
		}

		public String getContact_Entreprise() {
			return contact_Entreprise;
		}

		public void setContact_Entreprise(String contact_Entreprise) {
			this.contact_Entreprise = contact_Entreprise;
		}

		
		

}
