public abstract class Employe {
	protected String nom;
	protected String prenom;
	protected Poste emploi;
	protected int salaire;
	
	public Employe(String nom, String prenom, Poste emploi,int salaire) {
		this.nom=nom;
		this.prenom=prenom;
		this.emploi=emploi;
		this.salaire=salaire;
		
		
	}
	public String getNom() {
		return this.nom;
	}
	
	public void recevoirSalaire() {
		
	}
	public void presentation() {
		
	}

	public String getPrenom() {
		return this.prenom;
	}
}
