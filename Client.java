/** classe pour creer un client */
public abstract class Client {
	private String nom;
	private String prenom;
	private int achat;
	private double argent;
	
	/** constructeur client
	 * @param nom du client
	 * @param prenom du client
	 * @param argent que detient le client
	 */
	public Client(String nom,String prenom,int argent) {
		this.nom=nom;
		this.prenom=prenom;
		this.setArgent(argent);
		this.setAchat(0);
	}
	
	/**getter pour donner l'argent que possede le client
	 * @return double l'argent que possede le client
	 */
	public double getArgent() {
		return this.argent;
	}
	
	/**getter pour donner le nom du client
	 * @return String le nom du client
	 */
	public String getNom() {
		return this.nom;
	}

	/**getter pour donner le prenom du client
	 * @return String le prenom du client
	 */
	public String getPrenom() {
		return this.prenom;
	}
	
	/**setter pour recuperer l'argent que possede le client
	 * @param argent que possede le client en question
	 */
	public void setArgent(double argent) {
		this.argent = argent;
	}
	/**setter pour recuperer le nombre d'achats effectués par le client 
	* @param achats effectués par le client
	*/
	public void setAchat(int achat){
		this.achat=achat;
	}
}

