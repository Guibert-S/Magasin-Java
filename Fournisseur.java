import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


/** classe pour créer differents 4 fournisseurs: articles de ski, accessoires, boissons, nourritures */
public class Fournisseur {
	// du coup, 4 fournissuers avec comme attributs le nom, la liste d'articles qu'ils vendent, avec pour faciliter le stock ils peuvet en produire autant qu'on veut(sinon creation de tuples et plus galere) 
	
	private String nomFourni;
	private ArrayList<Tuple<Article,Integer>> artfourni=new ArrayList <Tuple<Article,Integer>>();;
	
	/** getter pour donner le nom du fourni
	 * @return le nom du fournisseur 
	 */
	public String getNomFourni() {
		return this.nomFourni;
	}
	/** constructeur Fournisseur
	 * @param m le magasin
	 */
	public Fournisseur (Magasin m) {
		System.out.println("Nom du fournisseur ? ");
		Scanner objet2=new Scanner (System.in);
		String g=objet2.nextLine();
		nomFourni=g;
		System.out.println("Combien d'articles produisez vous ?");
		Scanner objet = new Scanner (System.in);
		int c=objet.nextInt();
		Scanner yu =new Scanner(System.in);
		int i=0;
		while(i<c) {
			System.out.println("Nom du produit: ");
			String nom=yu.nextLine();
			Article b=new Article(nom);
			System.out.println("Combien en avez vous ?");
			int d=objet.nextInt();
			Tuple <Article,Integer>t3=new Tuple<Article, Integer>(b,d);
			artfourni.add(t3);
			
			i+=1;
			
		}
	}
	
	/** constructeur fournisseur
	 * @param nom du fournisseur
	 * @param article qu'il fournit
	 * @param stock du fournisseur
	 */
	public Fournisseur(String nom, ArrayList<Article> article,int stock) {//article et stock de meme taille 
		this.nomFourni=nom;
		Iterator <Article> it=article.iterator();
		
		while(it.hasNext()) {
			Article a=it.next();
			
			Tuple<Article,Integer> t=new Tuple <Article,Integer> (a,stock);
			artfourni.add(t);
		}
		
	}
	
	/** methode pour afficher le nom du fournisseur ainsi que les articles qu'il vend et la quantité dont il dispose
	 */
	public void afficherProdFour() {
		System.out.println("Nom du fournisseur: "+nomFourni);
		Iterator<Tuple<Article,Integer>> it=artfourni.iterator();
		while(it.hasNext()) {
			Tuple<Article,Integer> t=it.next();
			Article a=(Article) t.getT1();
			Integer b=(Integer) t.getT2();
			a.afficherArticle();
			System.out.println("Disponibilité: "+b);
			
		}
		
		
	}
	
	/** methode pour diminuer le stock d'un article chez le fournisseur
	 * @param a article dont on veut diminuer le stock 
	 * @param x la quantite à enlever du stock
	 */
	public void diminuerDispo(Article a,int x) {
		Iterator<Tuple<Article,Integer>> it=artfourni.iterator();
		while(it.hasNext()) {
			Tuple<Article,Integer> t=it.next();
			if(t.getT1().getNom().equalsIgnoreCase(a.getNom())&& t.getT1().getCategorie().equalsIgnoreCase(a.getCategorie())) {
				t.setT2(t.getT2()-x);
			}
		}

		
	}
	
	/** getter pour donner l'article et sa quantité 
	 * @return ... a completer 
	 */
	public ArrayList<Tuple<Article, Integer>> getTuple() {
		return artfourni;
	}
	
	public static void main(String[] args) {
		ArrayList <Article> a1=new ArrayList<Article>();
		Article a=new Article("Ski",200,400,"P");
		Article b=new Article ("Ski",100,200,"C");
		Article c=new Article ("Ski",60,120,"E");
		a1.add(a);
		a1.add(b);
		a1.add(c);
		Fournisseur f=new Fournisseur("defe",a1,100);
		f.diminuerDispo(a, 20);
		f.afficherProdFour();
		
		
	}
}
