
public class Fournisseur {
	
	private String nomFourni;
	private Article article;
	private  int stockFourni;
	
	
	public Fournisseur(String nomFourni, Article article, int stockFourni) {
		this.nomFourni= nomFourni;
		this.article = article;
		this.stockFourni = stockFourni;
	}
	public String getNomFourni() {
		return this.nomFourni;
	}
		
	public int getStockFourni() {
		return this.stockFourni;
	}
		
	public void setStockFourni(int stockFourni) {
		this.stockFourni= stockFourni;
	}

	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
}
