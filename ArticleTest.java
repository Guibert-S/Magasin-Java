import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ArticleTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();	

	@BeforeEach
	
	/** Dans la méthode setUp, nous réaffectons le flux de sortie 
	 * standard à un nouveau PrintStream avec un ByteArrayOutputStream. 
	 *  Ce flux de sortie est l'endroit
	 *  où les valeurs seront maintenant imprimées 
	 */
public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
}
	

	@Test 
	/** Test of afficherArticle() **/
	public void testAfficherArticle() {
		Article instance = new Article("ski",10,10,"P");
		instance.afficherArticle();
		String message_attendu = ("Nom article: "+instance.getNom()+" Prix d'achat: "+instance.getPrixAchat()+" Prix de vente: "+instance.getPrixVente()+" Categorie: "+ instance.getCategorie());
		assertEquals(message_attendu, outputStreamCaptor.toString()
			      .trim()); /* trimp permet de supprimer le retour à la ligne */
		
	}
	
	@AfterEach
	
	/** Dans la méthode tearDown on restaure le flux de sortie intial 
	 * car c'est une ressource partagé par d'autre parties du systèmes.
	 */
	
	public void tearDown() {
	    System.setOut(standardOut); }

	
	
	@Test 
	/** Test of setPrixAchat **/
	
	public void testsetPrixAchat() {
	    System.out.println("setPrixAchat");
	    double prix = 10.0;
	    Article instance = new Article("ski",10,10,"P");
	    instance.setPrixAchat(prix);
	    
	    assertEquals(instance.getPrixAchat(), prix);
	}
	
	@Test 
	/** Test of getPrixAchat **/
	
	public void testGetPrixAchat() {
	    System.out.println("testGetPrixAchat");
	    Article instance = new Article("ski",10,10,"P");
	    double resultat_attendu =  10.0 ;
	    double resultat = instance.getPrixAchat();
	    
	    
	    assertEquals(resultat_attendu,resultat);
	}
	@Test 
	/** Test of setPrixVente **/
	
	public void testsetPrixVente() {
	    System.out.println("setPrixVente");
	    double prix = 10.0;
	    Article instance = new Article("ski",10,10,"P");
	    instance.setPrixVente(prix);
	    
	    assertEquals(instance.getPrixVente(), prix);
	}
	
	@Test 
	/** Test of getPrixVente **/
	
	public void testGetPrixVente() {
	    System.out.println("testGetPrixVente");
	    Article instance = new Article("ski",10,10,"P");
	    double resultat_attendu =  10.0 ;
	    double resultat = instance.getPrixVente();
	    
	    
	    assertEquals(resultat_attendu,resultat);
	}
	
	
	@Test 
	/** Test of setNom **/
	
	public void testsetNom() {
	    System.out.println("testSetNom");
	    String nom = "ski";
	    Article instance = new Article("s",10,10,"P");
	    instance.setNom("ski");
	    
	    assertEquals(instance.getNom(), nom);
	}
	
	@Test 
	/** Test of getNom **/
	
	public void testGetNom() {
	    System.out.println("testGetNom");
	    Article instance = new Article("ski",10,10,"P");
	    String resultat_attendu =  "ski" ;
	    String  nom = instance.getNom();
	    
	    
	    assertEquals(resultat_attendu,nom);
	}
	
	@Test 
	/** Test of setCategorie **/
	
	public void testsetCategorie() {
	    System.out.println("testSeStCategorie");
	    String Categorie = "P";
	    Article instance = new Article("s",10,10,"P");
	    instance.setCategorie("P");
	    
	    assertEquals(instance.getCategorie(), Categorie);
	}
	
	@Test 
	/** Test of getCategorie **/
	
	public void testGetCategorie() {
	    System.out.println("testGetCategorie");
	    Article instance = new Article("ski",10,10,"P");
	    String resultat_attendu =  "P" ;
	    String  Categorie = instance.getCategorie();
	    
	    
	    assertEquals(resultat_attendu,Categorie);
	}


}
