package modele;

public class Etatstock {
	
	private int idStock;
	private int qteStock;
	private String seuilStock;
	private int sortiestock_idsortie_sortiestock;
	private int entreestock_identree_entreestock ;
	private int utilisateur_iduti_utilisateur;
	
	public int getIdStock() {
		return idStock;
	}

	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public int getQteStock() {
		return qteStock;
	}

	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	public String getSeuilStock() {
		return seuilStock;
	}

	public void setSeuilStock(String seuilStock) {
		this.seuilStock = seuilStock;
	}

	public int getSortiestock_idsortie_sortiestock() {
		return sortiestock_idsortie_sortiestock;
	}

	public void setSortiestock_idsortie_sortiestock(int sortiestock_idsortie_sortiestock) {
		this.sortiestock_idsortie_sortiestock = sortiestock_idsortie_sortiestock;
	}

	public int getEntreestock_identree_entreestock() {
		return entreestock_identree_entreestock;
	}

	public void setEntreestock_identree_entreestock(int entreestock_identree_entreestock) {
		this.entreestock_identree_entreestock = entreestock_identree_entreestock;
	}

	public int getUtilisateur_iduti_utilisateur() {
		return utilisateur_iduti_utilisateur;
	}

	public void setUtilisateur_iduti_utilisateur(int utilisateur_iduti_utilisateur) {
		this.utilisateur_iduti_utilisateur = utilisateur_iduti_utilisateur;
	}

	public Etatstock(){}

	public Etatstock(int idStock, int qteStock, String seuilStock, int sortiestock_idsortie_sortiestock,
			int entreestock_identree_entreestock, int utilisateur_iduti_utilisateur) {
		super();
		this.idStock = idStock;
		this.qteStock = qteStock;
		this.seuilStock = seuilStock;
		this.sortiestock_idsortie_sortiestock = sortiestock_idsortie_sortiestock;
		this.entreestock_identree_entreestock = entreestock_identree_entreestock;
		this.utilisateur_iduti_utilisateur = utilisateur_iduti_utilisateur;
	}
	
	

}
