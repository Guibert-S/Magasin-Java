

public class Article {
	private String nom; // nom de l'article //
	private double prixAchat; // prix d'achat //
	private double prixVente;  // prix de vente  //
	private int stock ;    // nombre d'article en stock  //
	private int promo ;  // promotion de l'article en cours //
	private String description ; 


// Constructeur //


	public Article(String nom,String description, double prixAchat, double prixVente, int promo,int stock) {
		this.nom =nom;
		this.prixAchat =prixAchat ;
		this.prixVente=prixVente;
		this.stock =0; 
		this.description = description ;
		this.promo = 0;
	}

// Méthodes //
	
	public String getNom() {return nom;}


	public void setNom(String nom)  { 	this.nom = nom;}


	public double getPrixAchat() {	return prixAchat;}


	public void setPrixAchat(double prixAchat) {	this.prixAchat = prixAchat;}


	public double getPrixVente() {	return prixVente;}


	public void setPrixVente(double prixVente) {	this.prixVente = prixVente;}


	public int getStock() {return stock;}

	
	public void setStock(int stock) {this.stock = stock;}
	
	
	public String getDescription() {return description;}


	public void setDescription(String description) {this.description = description;}

	public int getPromo() {return promo;}


	public void setPromo(int promo) {	this.promo = promo;}
	
	
	
	
}


}
