
import java.util.Scanner;

public class Article {
	private String nom;
	private double prixAchat;
	private double prixVente;
	private String categorie;// choix entre P:premium, C, confort et E, entré de gamme 
	
	


// Constructeur //


	public Article(String nom, double prixAchat, double prixVente, String categorie ) {
		this.nom =nom;
		this.prixAchat =prixAchat ;
		this.prixVente=prixVente;
		this.setCategorie(categorie);
	}

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

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	
}
