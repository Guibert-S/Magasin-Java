import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Objects;

/** classe qui fait fonctionner le magasin*/

public class Magasin {
	private static int jour;
	private static String nom;
	private static double revenu;
	private static double charges;
	/** dictionnaire reliant les articles avec leur stock */
	private static Map<Article,Integer> articles = new HashMap<Article,Integer>();
	/** dictionnaire reliant le client avec leur nombre d'achats */
	private static ArrayList <Client> clients = new ArrayList<Client>();
	static Scanner objet = new Scanner (System.in);
	private static ArrayList <Fournisseur> fournisseurs =new ArrayList <Fournisseur>();
	
	
	
	/** constructeur du magasin 
	 * @param nom du magasin
	 * @param charges du magasin
	 */
	public Magasin(String nom,double charges) {
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
	public static Article traduction(String s,String categorie) {
		Iterator<Entry<Article, Integer>> it=getArticles().entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry m=(Map.Entry) it.next();
			if(((Article) m.getKey()).getNom().equalsIgnoreCase(s) && ((Article) m.getKey()).getCategorie().equalsIgnoreCase(categorie)) {
				return (Article) m.getKey();
			}
		}
		return null;
		
	}
	
	/** methode pour obtenir la valeur à partir d'une clef 
	 * @param map contenant les articles
	 * @param value pour acceder à la clef
	 * @return le type Article correspondant dans l'inventaire**/ 
	 public static <K, V> K obtenirUneClefAvecKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            } 
            }
        return null;
	}
	
	/** methode pour ajouter l'article à la liste/array/dictionnaire
	 * @param a article ajouter 
	 */
	public static void ajouterArticle(Article a) { 
		System.out.println("Quelle est le stock de votre article "+a.getNom()+"?");
		int c=objet.nextInt();
		getArticles().put(a, c);
	}
	
	
	/** methode pour ajouter un article et si on connait le stock en amont, si l'article n'existe pas on l'ajoute, sinon on ajoute le stock
	 * @param a l'article 
	 * @param stock de l'article
	 */
	public static void AjouterArticlebis(Article a, int stock) {
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
		int b=getArticles().get(a);
		if(b==0) {
			System.out.println("Il n'y a plus de stocks ");
			return;
		}
		if(c.getArgent()<a.getPrixVente()) {
			System.out.println("Vous n'avez pas assez d'argent pour acheter cet article");
			return;
		}
		else {
			if(d>=5){
				c.setArgent(c.getArgent() - a.getPrixVente()*0.8);
				setRevenu(getRevenu() + a.getPrixVente()*0.8);
				int e=c.getAchat();
				c.setAchat(e+1);	 
				getArticles().replace(a, b-1); 
			}
			else {
				c.setArgent(c.getArgent() - a.getPrixVente());
				setRevenu(getRevenu() + a.getPrixVente());
				int e=c.getAchat();
				c.setAchat(e+1);
				 
				getArticles().replace(a, b-1); 
			}
		}
		int r=v.getVente();
		v.setVente(r+1);
		System.out.println("Vous avez acheté:"+a.getNom()+"\n"+"Voici votre budget: "+c.getArgent());
	}
	/** methode pour filtrer les produits en fonction de leur categorie
 	 * @param s categorie de l'article : choix entre E, C ou P
	 */
	public static void filtre(String s){
		Iterator it = getArticles().entrySet().iterator();
        	while (it.hasNext()) {
        		Map.Entry m=(Map.Entry) it.next();
        		if(((Article) m.getKey()).getCategorie().equalsIgnoreCase(s)) {
        			((Article) m.getKey()).afficherArticle();
        		}
        	}
	}
	
	/** methode pour conseiller le client en fonction de son budget : 3 cas: premium, confort, entree de gamme
	 * @param c le client a conseiller
	 */
	public static void dirigerClients(Client c) {
		if(c.getArgent()>1000) {
			filtre("P");
		}
		else if(c.getArgent()>500) {
			filtre("C");
		}
		else if(c.getArgent()<250) {
			filtre("E");
		}
	}
	
	/** methode pour afficher les articles avec leurs categories et leurs stocks correspondant présent dans l'inventaire du magasin
	 */
	public static void afficherInventaire() {
		 Iterator it = getArticles().entrySet().iterator();
	        while (it.hasNext()) {// has.Next, boolean qui indique s'il existe elements dans la collection cf cours 7
	            Map.Entry m = (Map.Entry) it.next();
	            System.out.println("Article: "+((Article) m.getKey()).getNom()+" Categorie:"+((Article) m.getKey()).getCategorie()+" Prix: "+((Article) m.getKey()).getPrixVente()+" Stock: "+m.getValue());
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
	public static void finMois() {
		setRevenu(getRevenu() - charges);
		for(Vendeur i:Manager.getVendeurs()) {
			setRevenu(getRevenu() - i.salaire);
			i.setVente(0);
			i.setSalaire(1800);
		}
		for(Menage j:Manager.getMenages()) {
			setRevenu(getRevenu() - j.salaire);
		}
		setJour(1);
	}
	
	public void ajouterFournisseur(Fournisseur f) {
		fournisseurs.add(f);
	}
	public static boolean chercherFournisseurbool(String nom,String categorie) {
		for (Fournisseur i:fournisseurs) {
			for (Tuple j:i.getArtfourni()) {
				if(((Article) j.getT1()).getNom().equalsIgnoreCase(nom)&& ((Article) j.getT1()).getCategorie().equalsIgnoreCase(categorie)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static Fournisseur chercherFournisseur(String nom,String categorie) {
		for (Fournisseur i:fournisseurs) {
			for (Tuple j:i.getArtfourni()) {
				if(((Article) j.getT1()).getNom().equalsIgnoreCase(nom)&& ((Article) j.getT1()).getCategorie().equalsIgnoreCase(categorie)) {
					return i;
				}
			}
		}
		return null;
	}
	
	/** methode pour acheter au fournisseur un article 
 	 * @param t le fournisseur a qui on veut acheter l'article
 	 * @param nom de l'article
 	 * @param categorie de l'article 
 	 * @param quanti la quantite que le magasin veut acheter 
	 */
	public static void acheter(Fournisseur t,String nom,String categorie,int quanti) {
		Article a=traduction(nom,categorie);
		revenu-=quanti*a.getPrixAchat();
		a.afficherArticle();
		int b=getArticles().get(a);
		getArticles().replace(a,b,b+quanti);
		t.diminuerDispo(a, quanti);
	
	}
	
	/** methode pour acheter des articles a un fournisseur
 	 * @param t fournisseur a qui on achete l'article 
	 */
	public static void acheterbis(Fournisseur t) {
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
	

	/** getter pour donner le dictionnaire article 
	 * @return le dictionnaire d'article avec le stock correpspondant
	 */
	public static Map<Article,Integer> getArticles() {
		return articles;
	}

	/** setter pour l'inventaire
	 * @param articles de l'inventaire
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

	public static int getJour() {
		return jour;
	}
	public static void setJour(int a) {
		Magasin.jour=a;
	}
	


}

	


