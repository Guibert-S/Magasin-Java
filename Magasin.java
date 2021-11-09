import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Magasin extends Client {
	public Magasin(String nom, String prenom, int argent) {
		super(nom, prenom, argent);
		// TODO Auto-generated constructor stub
	}

	private double depense;
	private double revenu;
	// nombre d'articles dans le magasin //
	private Map<Article,Integer> articles = new HashMap<>();// dictionnaire reliant les articles avec leur stock 
	private Map <Client,Integer> reduction = new HashMap<>();// dictionnaire reliant le client avec leur nombre d'achats 
	static Scanner objet = new Scanner (System.in);
	
	// ajout d'article et saisie controle avec la boucle while //
	
	public Article creationArticle() {
		String nomArticle = null;
		double prixAchat = 0;
		double prixVente = 0;
		
		while (nomArticle == null || prixAchat ==0 || prixVente ==0) {
			
			System.out.print("Nom de l'article :\n" );
			nomArticle = objet.nextLine(); // String // 
			
			System.out.print("Prix d'achat de l'article :\n" );
			prixAchat= objet.nextDouble();
			
			System.out.print("Prix  de vente de l'article  :\n" );
			prixVente = objet.nextDouble();
			objet.nextLine() ; // si on met qu'une fois nextline ca marche pas pas donc bon ... //
			
		}
		return new Article(nomArticle,prixAchat,prixVente);
	}
	// Ajouter l'article à la liste/array/dictionnaire //
	public void afficherArticle(Article a) {
		System.out.println("Nom article: "+a.getNom()+"Prix d'achat: "+a.getPrixAchat()+"Prix de vente: "+a.getPrixVente());
	}
	public void ajouterArticle(Article a) {
		System.out.println("Quelle est le stock de votre article ?");
		int c=objet.nextInt();
		articles.put(a, c);
	}
	
	public void vendre(Client c,Article a) {
		int d=reduction.get(c);
		if(c.getArgent()<a.getPrixVente()) {
			System.out.println("Vous n'avez pas assez d'argent pour acheter cet article");
			return;
		}
		else {
			if(d>=5){// si le client a fait plus de 5 achats dans le magasin alors on applique une reduction de 20 %
				c.setArgent(c.getArgent() - a.getPrixVente()*0.8);
				this.revenu+=a.getPrixVente()*0.8;
				reduction.put(c, d+1);
				int b=articles.get(a); // on recupere l'int , le stock de l'article
				articles.put(a, b-1); // diminue le stock de 1
			}
			else {
				c.setArgent(c.getArgent() - a.getPrixVente());
				this.revenu+=a.getPrixVente();
				reduction.put(c, d+1);
				int b=articles.get(a); // on recupere l'int , le stock de l'article
				articles.put(a, b-1); // diminue le stock de 1
			}
	}
}	
	// Verifier que tout s'affiche bien //
	public void afficherInventaire() {
		for(Map.Entry<Article,Integer> paire: articles.entrySet()) {
			Article a=paire.getKey();
			int b=paire.getValue();
			System.out.println(a+"Stock"+b);
			
		}
	}
}
