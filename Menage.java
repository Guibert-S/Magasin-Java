/** classe qui crée un employé menage */

public class Menage extends Employe {
	public Menage(String nom,String prenom,Poste emploi,int salaire) {
		this.nom=nom;
		this.prenom=prenom;
		this.emploi=emploi;
		this.salaire=salaire;
	}
	
	/** methode pour recuperer le salaire 
	 */
	public void recevoirSalaire() {
		this.salaire=50; // salaire mensuel 
		
	}
	
	/** methode pour afficher le nom, le prenom, le poste et le salaire de l'employé menage 
	 */
	public void affichage () {
		String str =String.valueOf(this.salaire);
		
		String str3=String.valueOf(this.emploi);
		System.out.println("Nom: " +this.nom+"Prenom: "+this.prenom+"Nombre de Ventes: "+"Poste: "+str3+"Bourse: "+str);
	}

}
