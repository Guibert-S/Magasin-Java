import java.util.Scanner;

/** classe pour creer un objet article dans le magasin
 */

public class Article {
	private String nom;
	private double prixAchat;
	private double prixVente;
	/** categorie de l'article : choix entre P:premium, C, confort et E, entré de gamme */
	private String categorie;
	
	
	/** constructeur article
	 * @param nom de l'article
	 * @param prixAchat de l'article auprès du fournisseur
	 * @param prixVente de l'article dans le magasin
	 * @param categorie de l'article P,E ou C
	 */
	public Article(String nom, double prixAchat, double prixVente, String categorie ) {
		this.nom =nom;
		this.prixAchat =prixAchat ;
		this.prixVente=prixVente;
		this.setCategorie(categorie);
	}

	/** constructeur article 
	 */
	public Article() {
		Scanner objet = new Scanner (System.in);
		System.out.print("Nom de l'article :\n" );
		nom = objet.nextLine(); // String // 
			
		System.out.print("Prix d'achat de l'article :\n" );
		prixAchat= objet.nextDouble();
			
		System.out.print("Prix  de vente de l'article  :\n" );
		prixVente = objet.nextDouble();
		objet.nextLine() ; // si on met qu'une fois nextline ca marche pas pas donc bon ... //
		
		System.out.println("Categorie de l'article: P(premium), C(confort),E(entrée de gamme)");
		categorie=objet.nextLine();
			
		
	}
	
	/** constructeur article
	 * @param nom de l'article
	 */
	public Article(String nom) {
		this.nom=nom;
		
		Scanner objet = new Scanner (System.in);
		System.out.print("Prix d'achat de l'article :\n" );
		prixAchat= objet.nextDouble();
			
		System.out.print("Prix  de vente de l'article  :\n" );
		prixVente = objet.nextDouble();
		objet.nextLine() ; // si on met qu'une fois nextline ca marche pas pas donc bon ... //
		
		System.out.println("Categorie de l'article: P(premium), C(confort),E(entrée de gamme)");
		categorie=objet.nextLine();
		
	}
	/**getter pour donner le nom de l'article
	 * @return String nom de l'article
	 */
	public String getNom() {
		return nom;
	}
	
	/**setter pour recuperer le nom de l'article
	 * @param nom de l'article
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**getter pour donner le prix de l'article acheté auprès du fournisseur
	 * @return double prix d'achat de l'article
	 */
	public double getPrixAchat() {
		return prixAchat;
	}

	/**setter pour recuperer le prix de l'article acheté auprès du fournisseur
	 * @param prixAchat de l'article
	 */
	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}


	/**getter pour donner le prix de vente de l'article 
	 * @return double prix de vente de l'article
	 */
	public double getPrixVente() {
		return prixVente;
	}


	/**setter pour donner le prix de vente de l'article
	 * @param prixVente de l'article
	 */
	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}

	/** methode pour afficher le nom, prix d'achat, de vente, la categorie de l'article
	 */
	public void afficherArticle() {
		if(categorie=="P") {
			System.out.println("Nom article: "+this.nom+" Prix d'achat: "+this.prixAchat+" Prix de vente: "+this.prixVente+" Categorie: Premium");
		}
		if(categorie=="C") {
			System.out.println("Nom article: "+this.nom+" Prix d'achat: "+this.prixAchat+" Prix de vente: "+this.prixVente+" Categorie: Confort");
		}
		if(categorie=="E") {
			System.out.println("Nom article: "+this.nom+" Prix d'achat: "+this.prixAchat+" Prix de vente: "+this.prixVente+" Categorie: Entree de gamme");
		}
	}


	/**getter pour donner la categorie de l'article 
	 * @return string la categorie de l'article : P, C ou E
	 */
	public String getCategorie() {
		return categorie;
	}


	/**setter pour recuperer le prix de l'article 
	 * @param categorie de l'article : choix entre P:premium, C, confort et E, entré de gamme
	 */
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	
}
