public abstract class Client {
	private String nom;
	private String prenom;
	private double argent;
	
	public Client(String nom,String prenom,int argent) {
		this.nom=nom;
		this.prenom=prenom;
		this.setArgent(argent);
	}
	public double getArgent() {
		return this.argent;
	}
	public String getNom() {
		return this.nom;
	}
	public String getPrenom() {
		return this.prenom;
	}
	public void setArgent(double argent) {
		this.argent = argent;
	}
}

