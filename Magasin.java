import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Magasin {
	private String nom;
	private static double revenu;
	private static double depense;
	// nombre d'articles dans le magasin //
	private static Map<Article,Integer> articles = new HashMap<>();// dictionnaire reliant les articles avec leur stock 
	private static Map <Client,Integer> reduction = new HashMap<>();// dictionnaire reliant le client avec leur nombre d'achats 
	static Scanner objet = new Scanner (System.in);
	private ArrayList <Employe> employes=new ArrayList <Employe>();// liste dynamique d'employe
	public Magasin() {}
	
	// ajout d'article et saisie controle avec la boucle while //
	
	public static Article creationArticle() {
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
	
	public Article traduction(String s) {
		Iterator it=articles.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry m=(Map.Entry) it.next();
			if(((Article) m.getKey()).getNom()==s) {
				return (Article) m.getKey();
			}
		}
		return null;
		
		
		
	}
	public void ajoutEmploye(Employe e) {
		employes.add(e);
	}
	public void afficherEmploye() {
		Iterator<Employe> it =employes.iterator();
		while(it.hasNext()) {// tant que it.hasnext est different de nul, on continue dans la boucle.
			Employe a=it.next();
			System.out.println("Nom:"+a.getNom()+" Prenom: "+a.getPrenom());
		}
	}
	public void licenciement(Employe e) {
		employes.remove(e); // qaund on tombe sur l'employe à supprumer, on le supprime de l'array.		
	}
	// Ajouter l'article à la liste/array/dictionnaire //
	public void afficherArticle(Article a) {
		System.out.println("Nom article: "+a.getNom()+"Prix d'achat: "+a.getPrixAchat()+"Prix de vente: "+a.getPrixVente());
	}
	public static void ajouterArticle(Article a) {
		System.out.println("Quelle est le stock de votre article ?");
		int c=objet.nextInt();
		articles.put(a, c);
	}
	
	public void ticket(Article s) {
		
		
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
	public static void afficherInventaire() {
		 Iterator it = articles.entrySet().iterator();
	        while (it.hasNext()) {// has.Next, booleanqui indique s'il existe elements dans la collection cf cours 7
	            Map.Entry m = (Map.Entry) it.next();
	            System.out.println("Article: "+((Article) m.getKey()).getNom()+", Stock: "+m.getValue());
	        }
	}
	public void supArticle(String s) {
		Article a=traduction (s);
		articles.remove(a);
	}
	
	public static void afficherClient() { // Afficher la liste des clients 
		 Iterator it = reduction.entrySet().iterator();
	        while (it.hasNext()) {
	            Map.Entry m = (Map.Entry) it.next();
	            System.out.println("Nom: "+((Client) m.getKey()).getNom()+"Prenom "+((Client) m.getKey()).getPrenom()+ "Nombre d'achat "+m.getValue());
	        }
	}
	
	public void AfficherRevenu() {
		System.out.println(this.revenu);
	}
	public Map<Client, Integer> getReduction() {
		return this.reduction;
	}
	public double GetRevenu() {
		return this.revenu;
	}
	
}
	
