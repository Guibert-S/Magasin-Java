
public class MainApp {
	 
	public static void main (String[] args) {
		
		
		System.out.println(Magasin.articles);
		FileDriver.chargerFichierSauvegarder(FileDriver.chemin);
		System.out.println(Magasin.articles);
		
		menuSelection(); // appel du menu //
	
	}


	// en vrai on pourrait soit faires sous menus ou faire un menu en utilisant un case ou un dictionnaire //
	public static void menuSelection() {
		 boolean menu = true;
		 while(menu==true) {
			System.out.println();
			System.out.println( "------ Séléction Menu ------" );
			
			System.out.println( " Option 1 : Ajouter un article" );
			System.out.println( " Option 2 : Supprimer un article" );
			System.out.println( " Option 3 : Ajouter un employé " );
			System.out.println( " Option 4 : Licencier un employé " );
			System.out.println( " Option 5 : Afficher Inventaire" );
			System.out.println( " Option 10 : Quitter" );
			int choix = Magasin.objet.nextInt(); 
			
			if (choix ==1){
				System.out.println( " Vous avez séléctionner 1 :  Ajouter un article" );
				System.out.println();
				Article a = Magasin.creationArticle();
				Magasin.ajouterArticle(a);

				Magasin.afficherInventaire() ;
				FileDriver.Sauvegarder(FileDriver.chemin , a);
				System.out.println();
			}
			
			if (choix ==2){
				System.out.println( " Vous avez séléctionner 2 : Supprimer un Article");
				FileDriver.chargerFichierSauvegarder(FileDriver.chemin);
				Magasin.supprimerArticle();
				//FileDriver.Sauvegarder(FileDriver.chemin);
	
				
				
				System.out.println();
			}
			
			if (choix ==3){
				System.out.println( " Vous avez séléctionner 3 :  Ajouter un employé ");
				Manager.Embaucher();
			
			if (choix ==4){
				System.out.println( " Vous avez séléctionner 4 : Licencier un employé ");
				Manager.Licencier();
			}
			
			if (choix ==5){
				System.out.println( " Vous avez séléctionner 5 : Afficher Inventaire  ");
				FileDriver.afficherFichierSauvegarde(FileDriver.chemin );  // Chargement des données du fichier txt //
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
