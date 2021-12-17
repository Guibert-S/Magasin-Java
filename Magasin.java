import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/** classe qui fait fonctionner le magasin*/

public class Magasin {
	private int jour;
	private static String nom;
	private static double revenu;
	private static double charges;
	/** dictionnaire reliant les articles avec leur stock */
	private static Map<Article,Integer> articles = new HashMap<Article,Integer>();
	/** dictionnaire reliant le client avec leur nombre d'achats */
	private static ArrayList <Client> clients = new ArrayList<Client>();
	static Scanner objet = new Scanner (System.in);
	/** liste dynamique de vendeur */
	private ArrayList <Vendeur> employes=new ArrayList <Vendeur>(); 
	
	/** constructeur du magasin 
	 * @param nom du magasin
	 * @param charges du magasin
	 */
	public Magasin(String nom,double charges) {//initialisation du magasin avec les charges. 
		this.jour=1;
		this.setRevenu(2000);
		this.nom=nom;
		this.charges=charges;
	}
	
	/** methode pour verifier qu'un article est bien contenu dans les articles 
	 * @param s le nom de l'article 
	 * @param categorie de l'article
	 * @return true si le nom de l'article est bien present, qu'importe si le mot comporte des majuscules ou pas
	 */
	public static boolean contenu(String s,String categorie) {
		Iterator <Entry<Article,Integer>>it=getArticles().entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry m=(Map.Entry) it.next();
			if(((Article) m.getKey()).getNom().equalsIgnoreCase(s) && ((Article) m.getKey()).getCategorie().equalsIgnoreCase(categorie)) {
				return true;
			}
		}
		return false;
	}
		
	/** methode pour donner le type de l'article correspondant dans l'inventaire
	 * @param s le nom de l'article 
	 * @param categorie de l'article
	 * @return le type Article correspondant dans l'inventaire
	 */
	public static Article traduction(String s,String categorie) {// on prend le nom d'un article et on renvoie le type Article correspondant dans l'inventaire
		Iterator<Entry<Article, Integer>> it=getArticles().entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry m=(Map.Entry) it.next();
			if(((Article) m.getKey()).getNom().equalsIgnoreCase(s) && ((Article) m.getKey()).getCategorie().equalsIgnoreCase(categorie)) {
				return (Article) m.getKey();
			}
		}
		return null;
		
	}
	
	
	/** methode pour ajouter l'article à la liste/array/dictionnaire
	 * @param a article ajouter 
	 */
	public static void ajouterArticle(Article a) { // on demande le stock au manager 
		System.out.println("Quelle est le stock de votre article "+a.getNom()+"?");
		int c=objet.nextInt();
		getArticles().put(a, c);
	}
	
	/** methode pour ajouter l'article à la liste/array/dictionnaire
	 * @param a article ajouter, stock int a jouter 
	 */
	public static void ajouterArticle(Article a, int stock) { // on demande le stock au manager 
		getArticles().put(a, stock);
	}
	
	
	/** methode pour ajouter un article et si on connait le stock en amont, si l'article n'existe pas on l'ajoute, sinon on ajoute le stock
	 * @param a l'article 
	 * @param stock de l'article
	 */
	public void AjouterArticlebis(Article a, int stock) {
		if( getArticles().containsKey(a)==true) {
			int b=getArticles().get(a);
			getArticles().replace(a,b,b+stock);
		}
		else {
			getArticles().put(a,stock);
		}	
	}
	
	 /** methode pour qu'un vendeur vende un article a un client
	  * @param a l'article a vendre
	  * @param c le client 
	  * @param v le vendeur qui effectue la vente
	  */
	public static void vendre(Client c,Article a,Vendeur v) {
		if(!(clients.contains(c))) {
			clients.add(c);
		}
		
		int d=c.getAchat();
		if(c.getArgent()<a.getPrixVente()) {
			System.out.println("Vous n'avez pas assez d'argent pour acheter cet article");
			return;
		}
		else {
			if(d>=5){// si le client a fait plus de 5 achats dans le magasin alors on applique une reduction de 20 %
				c.setArgent(c.getArgent() - a.getPrixVente()*0.8);
				setRevenu(getRevenu() + a.getPrixVente()*0.8);
				int e=c.getAchat();
				c.setAchat(e+1);
				int b=getArticles().get(a); // on recupere l'int , le stock de l'article
				getArticles().replace(a, b-1); // diminue le stock de 1
			}
			else {
				c.setArgent(c.getArgent() - a.getPrixVente());
				setRevenu(getRevenu() + a.getPrixVente());
				int e=c.getAchat();
				c.setAchat(e+1);
				int b=getArticles().get(a); // on recupere l'int , le stock de l'article
				getArticles().replace(a, b-1); // diminue le stock de 1
			}
		}
		int r=v.getVente();
		v.setVente(r+1);
	}
	/** methode pour filtrer les produits en fonction de leur categorie
 	 * @param s categorie de l'article : choix entre E, C ou P
	 */
	public static void filtre(String s){//filtre les produits en focntion de leur categorie, premium etc..
		Iterator it = getArticles().entrySet().iterator();
        	while (it.hasNext()) {
        		Map.Entry m=(Map.Entry) it.next();
        		if(((Article) m.getKey()).getCategorie().equalsIgnoreCase(s)) {
        			((Article) m.getKey()).afficherArticle();
        		}
        	}
	}
	
	/** methode pour conseiller le client en fonction de son budget : 3 cas: premium, confort, entree de gamme
	 * @param t client a conseiller
	 */
	public static void dirigerClients(Client t) {// on va conseiller le client en fonction de son budget. 3 cas: premium, confort, entree de gamme 
		if(t.getArgent()>1000) {
			filtre("P");
		}
		if(t.getArgent()>500) {
			filtre("C");
		}
		if(t.getArgent()<250) {
			filtre("E");
		}
	}
	
	/** methode pour afficher les articles avec leurs categories et leurs stocks correspondant présent dans l'inventaire du magasin
	 */
	public static void afficherInventaire() {
		 Iterator it = getArticles().entrySet().iterator();
	        while (it.hasNext()) {// has.Next, booleanqui indique s'il existe elements dans la collection cf cours 7
	            Map.Entry m = (Map.Entry) it.next();
	            System.out.println("Article: "+((Article) m.getKey()).getNom()+" Categorie:"+((Article) m.getKey()).getCategorie()+", Stock: "+m.getValue());
	        }
	}
	
	/** methode pour supprimer un article
	 * @param s le nom de l'article
	 * @param categorie de l'article
	 */
	public static void supArticle(String s,String categorie) {
		Article a=traduction (s,categorie);
		getArticles().remove(a);
	}
	
	/** methode pour afficher la liste des clients
	*/
	public static void afficherClient() { 
		Iterator <Client>it = clients.iterator();
	        while (it.hasNext()) {
	            Client m= it.next();
	            System.out.println("Nom: "+ m.getNom()+"Prenom "+ m.getPrenom()+ "Nombre d'achat "+m.getAchat());
	        }
	}

	/** methode pour afficher les benefices du magasin
	 */
	public void AfficherRevenu() {
		System.out.println(this.getRevenu());
	}
	
	/** getter pour retourner le revenu
	 * @return double le revenu du magasin
	 */
	public double GetRevenu() {
		return this.getRevenu();
	}
	
	/** methode pour simuler le paiement des charges et le paiement des salaires (charges fixes)
	 */
	public void finMois() {
		if(jour==30) {
			setRevenu(getRevenu() - charges);
			for(Vendeur i:employes) {
				setRevenu(getRevenu() - i.salaire);
				i.setVente(0);
				i.setSalaire(1800);
			}
			jour=1;
		}
		
	}
	
	/** methode pour acheter au fournisseur un article 
 	 * @param t le fournisseur a qui on veut acheter l'article
 	 * @param nom de l'article
 	 * @param categorie de l'article 
 	 * @param quanti la quantite que le magasin veut acheter 
	 */
	public void acheter(Fournisseur t,String nom,String categorie,int quanti) {
		Article a=this.traduction(nom,categorie);
		revenu-=quanti*a.getPrixAchat();
		a.afficherArticle();
		int b=getArticles().get(a);
		getArticles().replace(a,b,b+quanti);
		t.diminuerDispo(a, quanti);
		//penser à diminuer le stock
	}
	
	/** methode pour acheter des articles a un fournisseur
 	 * @param t fournisseur a qui on achete l'article 
	 */
	public void acheterbis(Fournisseur t) {
		System.out.println("Liste produit disponible");
		t.afficherProdFour();
		System.out.println("Nom du produit:");
		String nom=objet.nextLine();
		System.out.println("1.Premium, 2.Confort,3.Entree de gamme");
		int a=objet.nextInt();
		String categorie="";
		if(a==1) {
			categorie="P";
		}
		if(a==2) {
			categorie="C";
		}
		if(a==3) {
			categorie="E";
		}
		System.out.println("Quantité: ");
		int quanti=objet.nextInt();
		System.out.println(nom+categorie+quanti);
		acheter(t,nom,categorie,quanti);
		
		
	}
	
	public static void main (String [] args ) {
		Magasin mag=new Magasin("Decathlon",200);//200 correspond aux charges
		Article a=new Article("Ski",200,400,"P");
		Article b=new Article ("Ski",100,200,"C");
		Article c=new Article ("Ski",60,120,"E");
		mag.AjouterArticlebis(a,1);
		mag.AjouterArticlebis(b,1);
		mag.AjouterArticlebis(c,1);
		Vendeur jo=new Vendeur("john","doe",Poste.Vendeur,0);
		jo.affichage();
		ArrayList <Article> a1=new ArrayList<Article>();
		a1.add(a);
		a1.add(b);
		a1.add(c);
		
				
		
		
		
	}

	/** getter pour donner le dictionnaire article ?
	 * @return ....
	 */
	public static Map<Article,Integer> getArticles() {
		return articles;
	}

	/** setter pour recuperer le dictionnaire article ?
	 * @param articles ....
	 */
	public static void setArticles(Map<Article,Integer> articles) {
		Magasin.articles = articles;
	}
	
	/** getter pour donner le revenu du magasin
	 * @return le revenu du magasin
	 */
	public static double getRevenu() {
		return revenu;
	}

	/** setter pour recuperer le revenu du magasin ?
	 * @param revenu du magasin
	 */
	public static void setRevenu(double revenu) {
		Magasin.revenu = revenu;
	}
	
	/** getter pour donner le nom du magasin
	 * @return le nom du magasin
	 */
	public static String getNom() {
		return nom;
	}

	


}

	


