import java.util.HashMap;
import java.util.Iterator;
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
	static Map <Integer,Article> articles = new HashMap<>();// dictionnaire reliant les articles avec leur stock  // j'ai passe en static sinon ca marchait pas
	private Map <Client,Integer> reduction = new HashMap<>();// dictionnaire reliant le client avec leur nombre d'achats 
	static Scanner objet = new Scanner (System.in);
	
	// ajout d'article et saisie controle avec la boucle while //
	public static Article creationArticle() {
		String nomArticle = null;
		double prixAchat = 0;
		double prixVente = 0;
		int promo = 0 ;
		int stock = 0 ; 
		String description = null ;
		while (nomArticle == null || description == null || prixAchat ==0 || prixVente ==0  || promo ==0 || stock ==0) {
			
			System.out.print("Nom de l'article :\n" );
			nomArticle = objet.nextLine(); // String // 
			nomArticle =objet.nextLine();
			System.out.print("Description de l'article :\n" );
			description = objet.nextLine(); // String // 
			 
			System.out.print("Prix d'achat de l'article :\n" );
			prixAchat= objet.nextDouble();
			
			System.out.print("Prix  de vente de l'article  :\n" );
			prixVente = objet.nextDouble();
			
			System.out.print(" Article en promotion ?  :\n" );
			promo = objet.nextInt();
			
			System.out.print(" Stock?  :\n" );
			stock = objet.nextInt();
			
			

			 
		}
		return new Article(nomArticle, description,  prixAchat,  prixVente,  promo,stock);
	}
	
	public void afficherArticle(Article a) {
		System.out.println("Nom article: "+a.getNom()+"Prix d'achat: "+a.getPrixAchat()+"Prix de vente: "+a.getPrixVente()+"Descrption"+a.getDescription());
	}
	public static void ajouterArticle(Article a) {
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
	} }
	public void acheter(Fournisseur f, Article a, int nombreArticle) {
		int n = (int) (nombreArticle*a.getPrixAchat()); // combien coute le total de ce que l'on achete
		if ( n > this.revenu) {
			System.out.println("Le magasin n a pas assez de tresorie pour acheter" + nombreArticle + a.getNom() +"au fournisseur" + f.getNomFourni());
			return;
		}
		else {
			this.revenu= this.revenu - n;
			int b=articles.get(a);
			articles.put(a,b+n);
			int e = f.getStockFourni();
			f.setStockFourni(e-n);
		}
	}
		
	
	// Affiage partiel d'un article// 
	public static void afficherInventaire() {
		 Iterator it = articles.entrySet().iterator();
	        while (it.hasNext()) {
	            Map.Entry m = (Map.Entry) it.next();
	            System.out.println("Article: "+((Article) m.getKey()).getNom()+", Stock: "+m.getValue());
	        }
	}
	
	// Affiage complet d'un article // 
	public static void afficherInventaireComplet() {
		 Iterator it = articles.entrySet().iterator();
	        while (it.hasNext()) {
	            Map.Entry m = (Map.Entry) it.next();
	            System.out.println("Article: "+((Article) m.getKey()).getNom()+" Description: "+((Article) m.getKey()).getDescription()+"  Prix d'achat: "+((Article) m.getKey()).getPrixAchat()+" Prix de vente: "+((Article) m.getKey()).getPrixVente()+" Promo ?: "+((Article) m.getKey()).getPromo() +" Stock 1: "+ ((Article) m.getKey()).getStock()+" Stock 2: "+m.getValue());
	      
	        }
	}
	
	
	// Supprimer un article de la liste //
	public static void supprimerArticle() {
		FileDriver.afficherFichierSauvegarde(FileDriver.chemin ); 
		System.out.println("Ecrivez le nom de l'article à supprimer");
		System.out.println();
		int id_article_supp = Magasin.objet.nextInt(); 
		articles.remove(id_article_supp);
	}
	
	
	
}
