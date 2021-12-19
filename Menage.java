/** classe qui crée un employé menage */

public class Menage extends Employe {
	
	/** constructeur de menage
	 * @param nom de l'employé
	 * @param prenom de l'employé
	 * @param emploi de l'employé
	 */	
	public Menage(String nom,String prenom,Poste emploi) {
		super(nom, prenom, emploi);
		this.salaire=1200;
	}
	
	/** methode pour recuperer le salaire 
	 */
	public void recevoirSalaire() {
		this.salaire=1200; // salaire mensuel 
		
	}
	
	/** methode pour afficher le nom, le prenom, le poste et le salaire de l'employé menage 
	 */
	public void affichage () {
		String str =String.valueOf(this.salaire);
		
		String str3=String.valueOf(this.emploi);
		System.out.println("Nom: " +this.nom+"Prenom: "+this.prenom+"Poste: "+str3+"Bourse: "+str);
	}

}
