public class Article {
	private String nom;
	private double prixAchat;
	private double prixVente;
	private int stock ;


// Constructeur //


	public Article(String nom, double prixAchat, double prixVente) {
		this.nom =nom;
		this.prixAchat =prixAchat ;
		this.prixVente=prixVente;
		this.stock =0; 
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public double getPrixAchat() {
		return prixAchat;
	}


	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}


	public double getPrixVente() {
		return prixVente;
	}


	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
