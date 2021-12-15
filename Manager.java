import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

/** classe pour creer un manager qui est un employé qui peut embaucher et licencier */
public class Manager extends Employe {

	private static ArrayList <Vendeur> vendeurs=new ArrayList <Vendeur>(); 
	private static ArrayList <Menage> menages =new ArrayList <Menage>(); 
	
	public Manager(String nom, String prenom, Poste emploi) {
		super(nom, prenom, emploi);
		this.salaire=3000;
		
	}
		
	
	/** methode pour ajouter des employes des vendeurs en particulier
	 * @param le vendeur a ajouter 
	 */
	public static void ajoutEmployeVendeur(Vendeur e) {
		vendeurs.add(e);
	}
	
	/** methode pour afficher le nom et prenom des employés vendeur 
	 */
	public static void afficherEmployeVendeur() {
		Iterator<Vendeur> it =vendeurs.iterator();
		while(it.hasNext()) {// tant que it.hasnext est different de nul, on continue dans la boucle.
			Vendeur a=it.next();
			System.out.println("Nom:"+a.getNom()+" Prenom: "+a.getPrenom());
		}
	}
	
	/** methode pour ajouter des employés menage 
	 * @param l'employe menage a ajouter 
	 */
	public static void ajoutEmployeMenage(Menage m) {
		menages.add(m);
	}
	
	/** methode pour afficher le nom et prenom des employés menage
	 */
	public static void afficherEmployeMenage() {
		Iterator<Menage> it =menages.iterator();
		while(it.hasNext()) {// tant que it.hasnext est different de nul, on continue dans la boucle.
			Menage a=it.next();
			System.out.println("Nom:"+a.getNom()+" Prenom: "+a.getPrenom());
		}
	}
	
	/** methode pour licencier des employés menage mais il doit en rester toujours 1
	 * @param l'employe menage a licencier
	 */
    public static void licencierMenage(){
    	int i = menages.size();
    	if (i>1) {
    		menages.remove(i-1);
    		System.out.println("le dernier embauché est licencié ");
    	}
    	else{
            throw new IllegalArgumentException("il ne reste pas assez d'employé menage donc impossible de le licencier");
        }
    }
    
	/** methode pour licencier des vendeurs mais il doit en rester toujours 1
	 * @param le vendeur a licencier
	 */
    public static void licencierVendeur(){
    	int i = vendeurs.size();
    	if (i>1) {
    		vendeurs.remove(i-1);
    		System.out.println("le dernier embauché est licencié ");
    	}
    	else{
            throw new IllegalArgumentException("il ne reste pas assez de vendeur donc impossible de le licencier");
        }
    }
    //scanner pour gerer les employé
    static Scanner personne = new Scanner(System.in);

    /** methode pour embaucher des employés
	 */
 	public static void Embaucher() {
 		String nom = null;
 		String prenom = null;
 		String emploi = null;
 		String string1="menage";
 		String string2="vendeur";
 		

 		System.out.print("Nom de l'employé :\n" );
 		nom = personne.nextLine();  
 			
 		System.out.print("Prenom de l'employé :\n" );
 		prenom = personne.nextLine(); 
 			
 		System.out.print("Emploi de l'employé : menage ou vendeur ?");
 		emploi = personne.nextLine();
 		
 			
 		if( string1.equals(emploi)){ 
 			Menage m = new Menage(nom,prenom,Poste.Menage);
 			ajoutEmployeMenage(m);
 			System.out.println("vous avez ajouté un employé menage");
       	 }
 		
 		else if ( string2.equals(emploi)) {   
 			Vendeur v = new Vendeur(nom,prenom,Poste.Vendeur,0);
 			ajoutEmployeVendeur(v);
 			System.out.println("vous avez ajouté un vendeur");
 		}
       	else{
       		throw new IllegalArgumentException("le poste " + emploi + " n'est pas disponible");
		}
 	}
 	
 	static Scanner personne2 = new Scanner(System.in);
	
 	/** methode pour licencier des employés
	 */
 	public static void Licencier() {
 		String emploi = null;
 		String string1="menage";
 		String string2="vendeur";
 		
 		System.out.print("Emploi de l'employé : menage ou vendeur ?");
 		emploi = personne2.nextLine();
 			
 		if( string1.equals(emploi)){
 			licencierMenage();
 			System.out.println("vous avez licencié un employé menage");
       	 }
 		
 		else if ( string2.equals(emploi)) {
 			licencierVendeur();
 			System.out.println("vous avez licencié un vendeur");
 		}
       	else{
       		throw new IllegalArgumentException("le poste n'existe " + emploi +" n'existepas ");
		}
 	}
 	
 	
 	
 	public static void main (String[] args) {
 		Manager chef = new Manager("Quentin", "Barriere", Poste.Manager);
 	}
 	
}
 
