import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



public class Fournisseur {// créer differents types de fourniseurs: articles de ski, accessoires, boissons, nourritures
	// du coup, 4 fournissuers avec comme attributs le nom, la liste d'articles qu'ils vendent, avec pour faciliter le stock ils peuvet en produire autant qu'on veut(sinon creation de tuples et plus galere) 
	
	private String nomFourni;
	private ArrayList<Tuple<Article,Integer>> artfourni=new ArrayList <Tuple<Article,Integer>>();;
	
	public String getNomFourni() {
		return this.nomFourni;
	}
	
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
	public Fournisseur(String nom, ArrayList<Article> article,int stock) {//article et stock de meme taille 
		this.nomFourni=nom;
		Iterator <Article> it=article.iterator();
		
		while(it.hasNext()) {
			Article a=it.next();
			
			Tuple<Article,Integer> t=new Tuple <Article,Integer> (a,stock);
			artfourni.add(t);
		}
		
	}
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
	
	public void diminuerDispo(Article a,int x) {
		Iterator<Tuple<Article,Integer>> it=artfourni.iterator();
		while(it.hasNext()) {
			Tuple<Article,Integer> t=it.next();
			if(t.getT1().getNom()==a.getNom()&& t.getT1().getCategorie()==a.getCategorie()) {
				t.setT2(t.getT2()-x);
			}
		}

		
	}
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
