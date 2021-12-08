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
	
	public Fournisseur () {
		System.out.println("Nom du fournisseur ? ");
		Scanner objet2=new Scanner (System.in);
		String g=objet2.nextLine();
		nomFourni=g;
		System.out.println("Combien d'articles produisez vous ?");
		Scanner objet = new Scanner (System.in);
		int c=objet.nextInt();
		int i=0;
		while(i<c) {
			Article a=new Article();
			System.out.println("Combien en avez vous ?");
			int d=objet.nextInt();
			Tuple <Article,Integer>t=new Tuple<Article, Integer>(a,d);
			artfourni.add(t);
			i+=1;
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
	public static void main(String[] args) {
		Fournisseur f=new Fournisseur();
		Fournisseur t=new Fournisseur();
		f.afficherProdFour();
		t.afficherProdFour();
		
	}
}
