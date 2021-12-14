public abstract class Employe {
	protected String nom;
	protected String prenom;
	protected Poste emploi;
	protected int salaire;
	
	public Employe(String nom, String prenom, Poste emploi) {
		this.nom=nom;
		this.prenom=prenom;
		this.emploi=emploi;
		
		
	}
	public String getNom() {
		return this.nom;
	}
	
	public void recevoirSalaire() {
		
		}
	public void affichage() {
		
	}

	public String getPrenom() {
		return this.prenom;
	}
}
