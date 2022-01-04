package modele;

public class Produit {

	private int codePro;
	private String nomPro;
	private String dateFabPro;
	private String datePerPro;
	private int prixVentePro;
	private int codeFam;
	
	public int getCodePro() {
		return codePro;
	}

	public void setCodePro(int codePro) {
		this.codePro = codePro;
	}

	public String getNomPro() {
		return nomPro;
	}

	public void setNomPro(String nomPro) {
		this.nomPro = nomPro;
	}

	public String getDateFabPro() {
		return dateFabPro;
	}

	public void setDateFabPro(String dateFabPro) {
		this.dateFabPro = dateFabPro;
	}

	public String getDatePerPro() {
		return datePerPro;
	}

	public void setDatePerPro(String datePerPro) {
		this.datePerPro = datePerPro;
	}

	public int getPrixVentePro() {
		return prixVentePro;
	}

	public void setPrixVentePro(int prixVentePro) {
		this.prixVentePro = prixVentePro;
	}

	public int getCodeFam() {
		return codeFam;
	}

	public void setCodeFam(int codeFam) {
		this.codeFam = codeFam;
	}

	public Produit(){}

	public Produit(int codePro, String nomPro, String dateFabPro, String datePerPro, int prixVentePro, int codeFam) {
		super();
		this.codePro = codePro;
		this.nomPro = nomPro;
		this.dateFabPro = dateFabPro;
		this.datePerPro = datePerPro;
		this.prixVentePro = prixVentePro;
		this.codeFam = codeFam;
	}
	
	
}
