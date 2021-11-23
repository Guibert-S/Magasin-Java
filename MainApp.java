


import java.util.HashMap;
import java.util.Map;
import java.io.File;

public class MainApp {
	 
	public static void main (String[] args) {
		
		
		FileDriver.afficherFichierSauvegarde("C:/Users/samue/OneDrive/Bureau/Sauvegarde_Inventaire.txt");  // Chargement des données du fichier txt //
		
		Article a = Magasin.creationArticle();
		Magasin.ajouterArticle(a);
		Magasin.afficherInventaire() ;
		
		// test dico //
		Map <Article,Integer> Inventaire = new HashMap<>();
		Inventaire.put(new Article("ff","ff",10,230, 1,1),1);
		
		
			
		
		
	
		
		menuSelection(); // appel du menu //
	
	}


	// en vrai on pourrait soit faires sous menus ou faire un menu en utilisant un case ou un dictionnaire //
	public static void menuSelection() {
		 boolean menu = true;
		 while(menu==true) {
			System.out.println();
			System.out.println( "------ Séléction Menu ------" );
			
			System.out.println( " Option 1 : Ajouter un article" );
			System.out.println( " Option 2 : " );
			System.out.println( " Option 3 : " );
			System.out.println( " Option 4 : " );
			System.out.println( " Option 5 : " );
			System.out.println( " Option 10 : Quitter" );
			
			int choix = Magasin.objet.nextInt(); 
			
			if (choix ==1){
				System.out.println( " Vous avez séléctionner 1 :  Ajouter un article" );
				Magasin.creationArticle();
				
			}
			
			if (choix ==2){
				System.out.println( " Vous avez séléctionner 2 : ");
			}
			
			if (choix ==3){
				System.out.println( " Vous avez séléctionner 3 : ");
			}
			
			if (choix ==4){
				System.out.println( " Vous avez séléctionner 4 : ");
			}
			
			if (choix ==5){
				System.out.println( " Vous avez séléctionner 5 : ");
			}
			
			if (choix ==10){
				System.out.println( " Bonne journée ! " );
				menu = false; 
			}
			else{
				System.out.println( " Entrer une option valide ! " );
			}
		}	
	}
}

