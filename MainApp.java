/** classe application */

public class MainApp {
	 
	public static void main (String[] args) {
		
		Magasin mag=new Magasin("Decathlon",200);
		Manager chef = new Manager("Musk", "Elon",Poste.Manager);
		Article a=new Article("Ski",200,400,"P");
		Article b=new Article ("Ski",100,200,"C");
		Article c=new Article ("Ski",60,120,"E");
		mag.AjouterArticlebis(a,1);
		mag.AjouterArticlebis(b,2);
		mag.AjouterArticlebis(c,3);
		ArrayList <Article> a1=new ArrayList<Article>();
		Article a=new Article("Ski",200,400,"P");
		Article b=new Article ("Ski",100,200,"C");
		Article c=new Article ("Ski",60,120,"E");
		a1.add(a);
		a1.add(b);
		a1.add(c);
		Fournisseur f=new Fournisseur("Fournisseur1",a1,100);
		FileDriver.ecrireFichier(FileDriver.chemin,Magasin.getArticles());
		
		FileDriver.lireFichierSauvegarder(FileDriver.chemin);
		
		FileDriver.lancerMenu1();
		FileDriver.lancerMenu2();
	}

}
