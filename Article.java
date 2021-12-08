

import java.util.Scanner;

public class Article {
	private String nom;
	private double prixAchat;
	private double prixVente;
	


// Constructeur //


	public Article(String nom, double prixAchat, double prixVente) {
		this.nom =nom;
		this.prixAchat =prixAchat ;
		this.prixVente=prixVente;
		
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
		System.out.println("Nom article: "+this.nom+"Prix d'achat: "+this.prixAchat+"Prix de vente: "+this.prixVente);
	}
	
	
}



