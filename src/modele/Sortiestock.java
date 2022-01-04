package modele;

public class Sortiestock {
	
	private int idSortie;
	private int numFacture;
	private String nomClient;
	private String dateSortie;
	private int qteSortie;
	public int getIdSortie() {
		return idSortie;
	}

	public void setIdSortie(int idSortie) {
		this.idSortie = idSortie;
	}

	public int getNumFacture() {
		return numFacture;
	}

	public void setNumFacture(int numFacture) {
		this.numFacture = numFacture;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(String dateSortie) {
		this.dateSortie = dateSortie;
	}

	public int getQteSortie() {
		return qteSortie;
	}

	public void setQteSortie(int qteSortie) {
		this.qteSortie = qteSortie;
	}

	public int getCodePro() {
		return codePro;
	}

	public void setCodePro(int codePro) {
		this.codePro = codePro;
	}

	private int codePro;
	
	public Sortiestock (){}

	public Sortiestock(int idSortie, int numFacture, String nomClient, String dateSortie, int qteSortie, int codePro) {
		super();
		this.idSortie = idSortie;
		this.numFacture = numFacture;
		this.nomClient = nomClient;
		this.dateSortie = dateSortie;
		this.qteSortie = qteSortie;
		this.codePro = codePro;
	}
	
	

}
