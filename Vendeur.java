/** classe pour creer un vendeur qui est un employé */

public class Vendeur extends Employe{
	private int nmbreVente;
	
	public Vendeur(String nom,String prenom,Poste emploi,int vente) {
		super(nom,prenom,emploi);
		this.salaire=1800;
		this.nmbreVente=vente;
	}
	
	/** methode pour avoir une augmentation de salaire si le nombre de vente du vendeur est superieur a 50
	 */
	public void recevoirSalaire(){
		if(this.nmbreVente>50) {
			this.setSalaire(1800+200);
		}
	}
	
	/** methode pour afficher le nom, le prenom, le poste, le salaire et le nombre de vente du vendeur
	 */
	public void affichage () {
		String str =String.valueOf(this.salaire);
		String str2=String.valueOf(this.nmbreVente);
		System.out.println("Nom: " +this.nom+"\nPrenom: "+this.prenom+"\nPoste: "+emploi.toString()+"\nBourse: "+str+"\nNombre de Ventes: "+str2);
	}
	
	/** getter pour donner le nombre de ventes du vendeur 
	 */
	public int getVente() {
		return nmbreVente;
	}
	
	/** setter pour recuperer le nombre de ventes du vendeur 
	 * @param le nombre de ventes
	 */
	public void setVente(int x) {
		this.nmbreVente=x;
	}
	
	/** setter pour recuperer le salaire du vendeur 
	 * @param le salaire 
	 */
	public void setSalaire(int x) {
		this.salaire=x;
	}
	
}
