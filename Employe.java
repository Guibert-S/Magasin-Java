/** classe pour un employe */
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
	
	/**getter pour donner le nom de l'employe
	 * @return String le nom de l'employe
	 */
	public String getNom() {
		return this.nom;
	}
	
	public void recevoirSalaire() {
		
		}
	public void affichage() {
		
	}

	/**getter pour donner le prenom de l'employe
	 * @return String le prenom de l'employe
	 */
	public String getPrenom() {
		return this.prenom;
	}
}
