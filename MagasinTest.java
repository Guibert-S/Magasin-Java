import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class MagasinTest {

	@Test
	public void testContenu() {
		Magasin.ajouterArticle(new Article("Ski",200,400,"P"),5);
		boolean bool = Magasin.contenu("Ski","P");
		assertEquals(true,bool);
	}
	
	
	@Test
	public void testTraduction() {
		Article result = Magasin.traduction("Ski","P");
		Article key = Magasin.obtenirUneClefAvecKey(Magasin.getArticles(), 5);
		assertEquals(result,key);
	}
	
	@Test
	public void testObtenirUneClefAvecKey() {
		
	    Map<String, Integer> dico = new HashMap<>();
	    dico.put("Decathlon", 5);
		String result = Magasin.obtenirUneClefAvecKey(dico,5);
		assertEquals(result,"Decathlon");
	}
	
	@Test
	
	public void testAjouterArticle() {
		boolean bo = false ;
		if (Magasin.getArticles().containsValue(5)) {
			 bo = true;
		assertEquals(bo,true);
		
	}
	
}
	
}
