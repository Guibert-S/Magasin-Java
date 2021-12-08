

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class Manager extends Employe {

	public static Set<Menage> equipe1;
	public static Set<Vendeur> equipe2;
	
	public Manager(String nom, String prenom, Poste emploi, int salaire) {
		super(nom, prenom, emploi, salaire);
		Manager.equipe1 = new HashSet<>();
		Manager.equipe2 = new HashSet<>();
	}
	
	
	 //licencier si il reste au moins deux personnes
    public void licencierMenage(Menage menage){
    	if (equipe1.size()>1) {
    		equipe1.remove(menage);
    	}
    	else{
            throw new IllegalArgumentException("il ne reste que un employé dans l'equipe menage donc impossible de le licencier");
        }
    }
    
    public void licencierVendeur(Vendeur vendeur){
    	if (equipe2.size()>1) {
    		equipe2.remove(vendeur);
    	}
    	else{
            throw new IllegalArgumentException("il ne reste que un vendeur donc impossible de le licencier");
        }
    }
    //scanner pour gerer les employé
 	static Scanner personne = new Scanner(System.in);
	
 	public static void EmbaucherMenage() {
 		String nom = null;
 		String prenom = null;
 		int salaire = 0;
 		
 		while (nom == null || prenom ==null || salaire ==0 ) {
 			
 			System.out.print("Nom de l'employé :\n" );
 			nom = personne.nextLine(); // String // 
 			
 			System.out.print("Prenom de l'employé :\n" );
 			prenom = personne.nextLine(); // String // 
 			
 			System.out.print(" Salaire ?  :\n" );
 			salaire = personne.nextInt();
 		
 			personne.nextLine() ; // 
 			
 		}
 		if(equipe1.size()<6){
 			equipe1.add(new Menage(nom, prenom, Poste.Menage, salaire));
       	 	}
       		else{
			throw new IllegalArgumentException("plus de place dans l'equipe menage");
		}
 	}
 	
 	public static void EmbaucherVendeur() {
 		String nom = null;
 		String prenom = null;
 		int salaire = 0;
 		int nbrvente=0;
 		
 		while (nom == null || prenom ==null || salaire ==0 ) {
 			System.out.print("Nom de l'employé :\n" );
 			nom = personne.nextLine(); // String // 
 			
 			System.out.print("Prenom de l'employé :\n" );
 			prenom = personne.nextLine(); // String // 
 			
 			System.out.print(" Salaire ?  :\n" );
 			salaire = personne.nextInt();
 		
 			personne.nextLine() ; // 
 			
 		}
 		if(equipe2.size()<6){
 			equipe2.add(new Vendeur(nom, prenom, Poste.Vendeur, salaire, nbrvente ));
       		}
        	else{
           	 throw new IllegalArgumentException("plus de place dans l'equipe vendeur");
       		}
 	}
 	

 	public static void main (String[] args) {
 		Employe chef = new Manager("Quentin", "Barriere", Poste.Manager, 300);
 		menuEmploye(); // Appel du menu //
 		
 	}
 	
	public static void menuEmploye() {
		boolean menu2=true;
		
		while (menu2==true) {
			System.out.println();
			System.out.println( "------ Séléction Menu Employe------" );
			
			System.out.println( " Option 1 : Ajouter un employe menage " );
			System.out.println( " Option 2 : Ajoiuter un vendeur " );
			System.out.println( " Option 3 : Licencier un employe menage" );
			System.out.println( " Option 4 : Licencier un vendeur" );
			System.out.println( " Option 5 : " );
			System.out.println( " Option 10 : Quitter" );
			int choix = Manager.personne.nextInt();
		
			if (choix ==1) {
			
				System.out.println( " Vous avez séléctionner 1 :  Ajouter un employé menage " );
				Manager.EmbaucherMenage(); 
			}
		
			if (choix ==2){
				System.out.println( " Vous avez séléctionner 2 : Afficher Inventaire ");
		
			}
		
			if (choix ==3){
				System.out.println( " Vous avez séléctionner 1 :  Ajouter un employé menage " );
				Manager.EmbaucherVendeur();
			}
		
		
			if (choix ==10){
				System.out.println( " Bonne journée ! " );
				menu2 = false; 
			}
			else{
				System.out.println( " Entrer une option valide ! " );
			}
		}
	}
    
}
