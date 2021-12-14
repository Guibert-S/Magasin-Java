public class Vendeur extends Employe{
	private int nmbreVente;
	
	public Vendeur(String nom,String prenom,Poste emploi,int vente) {
		super(nom,prenom,emploi);
		this.salaire=1800;
		this.nmbreVente=vente;
	}
	public void recevoirSalaire(){
		if(this.nmbreVente>50) {
			this.setSalaire(1800+200);// bonus pour le nombre de vente
		}
	}
	
	public void affichage () {
		String str =String.valueOf(this.salaire);
		String str2=String.valueOf(this.nmbreVente);
		System.out.println("Nom: " +this.nom+"\nPrenom: "+this.prenom+"\nPoste: "+emploi.toString()+"\nBourse: "+str+"\nNombre de Ventes: "+str2);
	}
	public int getVente() {
		return nmbreVente;
	}
	public void setVente(int x) {
		this.nmbreVente=x;
	}
	
	public void setSalaire(int x) {
		this.salaire=x;
	}
	
}
