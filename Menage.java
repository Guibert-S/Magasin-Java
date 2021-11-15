public class Menage extends Employe {
	public Menage(String nom,String prenom,Poste emploi,int salaire,String cv) {
		this.nom=nom;
		this.prenom=prenom;
		this.emploi=emploi;
		this.salaire=salaire;
		this.cv=cv;
	}
	public void recevoirSalaire() {
		this.salaire=50; // salaire mensuel 
		
	}
	
	public void affichage () {
		String str =String.valueOf(this.salaire);
		
		String str3=String.valueOf(this.emploi);
		System.out.println("Nom: " +this.nom+"Prenom: "+this.prenom+"Nombre de Ventes: "+"Poste: "+str3+"Bourse: "+str+"Cv: "+cv);
	}

}
