import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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
			System.out.println("Nom: "+a.getNom()+" Prenom: "+a.getPrenom() + "Poste : Vendeur" );
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
            throw new IllegalArgumentException("il ne reste pas assez de vendeur donc impossible de licencier");
        }
    }
	
    /** methode pour verifier que le vendeur n'est pas deja dans l'entreprise
   	 * @param le vendeur a verifier 
   	 * @return true si le vendeur n'existe pas deja dans la base
   	 */
   	public static boolean pasDoublonVendeur(Vendeur v) {
   		for (int i = 0; i<vendeurs.size();i++) {
   			Vendeur a = vendeurs.get(i);
   			if (v.getNom().equals(a.getNom()) || v.getPrenom().equals(a.getPrenom())) {
   				return false;
   			}
   		}
   		return true;
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
			System.out.println("Nom:"+a.getNom()+" Prenom: "+a.getPrenom() + "Poste : Employé menage");
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
            throw new IllegalArgumentException("il ne reste pas assez d'employé menage donc impossible de licencier");
        }
    }
    
    /** methode pour verifier que l'employé menage n'est pas deja dans l'entreprise
   	 * @param l'employé menage a verifier 
   	 * @return true si l'employé n'existe pas deja dans la base
   	 */
   	public static boolean pasDoublonMenage(Menage m) {
   		for (int i = 0; i<menages.size();i++) {
   			Menage a = menages.get(i);
   			if (m.getNom().equals(a.getNom()) || m.getPrenom().equals(a.getPrenom())) {
   				return false;
   			}
   		}
   		return true;
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
			if (pasDoublonMenage(m)) {
					ajoutEmployeMenage(m);
					System.out.println("vous avez ajouté un employé menage");
			}
			else {
				System.out.println("l'employé menage "+nom+" "+prenom+" existe déjà");
			}
       	 }
 		
 		else if ( string2.equals(emploi)) {   
 			Vendeur v = new Vendeur(nom,prenom,Poste.Vendeur,0);
 			if (pasDoublonVendeur(v)) {
 				ajoutEmployeVendeur(v);
 				System.out.println("vous avez ajouté un vendeur");
 			}
 			else {
				System.out.println("le vendeur "+nom+" "+prenom+" existe déjà donc impossible de l'ajouter a nouveau");
			}
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
       		throw new IllegalArgumentException("le poste " + emploi +" n'existe pas ");
		}
 	}
 	
}
 
