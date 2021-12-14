/** classe pour creer un client */
public abstract class Client {
	private String nom;
	private String prenom;
	private double argent;
	
	public Client(String nom,String prenom,int argent) {
		this.nom=nom;
		this.prenom=prenom;
		this.setArgent(argent);
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
	 * @param l'argent que possede le client en question
	 */
	public void setArgent(double argent) {
		this.argent = argent;
	}
}

