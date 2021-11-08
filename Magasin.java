import java.util.Scanner; 

public class Magasin {
	private double depense;
	private double revenu;
	// nombre d'articles dans le magasin //
	private Article [] articles = new Article[200];
	static Scanner objet = new Scanner (System.in);
	
	// ajout d'article et saisie controle avex la boucle while //
	
	public Article creationArticle() {
		String nomArticle = null;
		double prixAchat = 0;
		double prixVente = 0;
		
		while (nomArticle==null | prixAchat ==0 | prixVente ==0) {
			
			System.out.print("Nom de l'article :" );
			nomArticle = objet.nextLine(); // String // 
			
			System.out.print("Prix d'achat de l'article :" );
			prixAchat= objet.nextDouble();
			
			System.out.print("Prix  de vente de l'article :" );
			prixVente = objet.nextDouble();
			
		}
		return new Article(nomArticle,prixAchat,prixVente);
	}
	// Ajouter l'article à la liste/array/dictionnaire //
	
	public void ajouterArticle() {
		for (int i=0; i<articles.length;i++) {
			if (articles[i]==null) {
				articles[i]= creationArticle() ;
				i = articles.length; // si on ne met pas ça on rempli tous les articles.
			}
		}
	}
	
	// Verifier que tout s'affiche bien //
	public void afficherInventaire() {
		for (int i=0; i<articles.length;i++) {
			if (articles[i]!=null) {
				System.out.print("Numéro de l'article"+(i+1) +"Nom"+ articles[i].getNom() + articles[i].getStock() ); ;
			
				}
		}
	}
}

