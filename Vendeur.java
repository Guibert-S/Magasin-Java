public class Vendeur extends Employe{
	private int nmbreVente;
	
	public Vendeur(String nom,String prenom,Poste emploi,int salaire,int vente) {
		super(nom,prenom,emploi,salaire);
		this.nmbreVente=vente;
	}
	public void recevoirSalaire(){
		this.salaire+=100;  // Salaire mensuel 
		if(this.nmbreVente>10) {
			this.salaire+=20;// bonus pour le nombre de vente
		}
		
		
	}
	public void affichage () {
		String str =String.valueOf(this.salaire);
		String str2=String.valueOf(this.nmbreVente);
		String str3=String.valueOf(this.emploi);
		System.out.println("Nom: " +this.nom+"Prenom: "+this.prenom+"Nombre de Ventes: "+"Poste: "+str3+"Bourse: "+str+"Nombre de Ventes: "+str2);
	}
	
	
}
