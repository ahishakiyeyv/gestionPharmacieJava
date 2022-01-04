package modele;

public class Entreestock {
	
	private int idEntree;
	private int prixAchat;
	private int qteEntree;
	private int codePro;


	public  Entreestock(){}


	public Entreestock(int idEntree, int prixAchat, int qteEntree, int codePro) {
		super();
		this.idEntree = idEntree;
		this.prixAchat = prixAchat;
		this.qteEntree = qteEntree;
		this.codePro = codePro;
	}


	public int getIdEntree() {
		return idEntree;
	}


	public void setIdEntree(int idEntree) {
		this.idEntree = idEntree;
	}


	public int getPrixAchat() {
		return prixAchat;
	}


	public void setPrixAchat(int prixAchat) {
		this.prixAchat = prixAchat;
	}


	public int getQteEntree() {
		return qteEntree;
	}


	public void setQteEntree(int qteEntree) {
		this.qteEntree = qteEntree;
	}


	public int getCodePro() {
		return codePro;
	}


	public void setCodePro(int codePro) {
		this.codePro = codePro;
	}
	
	
	
}
