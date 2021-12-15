
public class MainApp {
	 
	public static void main (String[] args) {
		
		Magasin mag=new Magasin("Decathlon",200);//200 correspond aux charges
		Article a=new Article("Ski",200,400,"P");
		Article b=new Article ("Ski",100,200,"C");
		Article c=new Article ("Ski",60,120,"E");
		mag.AjouterArticlebis(a,1);
		mag.AjouterArticlebis(b,2);
		mag.AjouterArticlebis(c,3);
		FileDriver.ecrireFichier(FileDriver.chemin,Magasin.getArticles());
		
		FileDriver.lireFichierSauvegarder(FileDriver.chemin);
		
		Magasin.afficherInventaire();
		
		FileDriver.lancerMenu();
	}



}
