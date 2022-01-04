package modele;

public class Utilisateur {

	private int idUti;
	private String nomUti;
	private String adrUti;
	private int telUti;
	private String typeUti;
	private  String loginUti ;
	private String pswdUti ;
	private int etatstock_idstock ;
	
	
	public Utilisateur(){}


	public int getIdUti() {
		return idUti;
	}


	public void setIdUti(int idUti) {
		this.idUti = idUti;
	}


	public String getNomUti() {
		return nomUti;
	}


	public void setNomUti(String numUti) {
		this.nomUti = numUti;
	}


	public String getAdrUti() {
		return adrUti;
	}


	public void setAdrUti(String adrUti) {
		this.adrUti = adrUti;
	}


	public int getTelUti() {
		return telUti;
	}


	public void setTelUti(int telUti) {
		this.telUti = telUti;
	}


	public String getTypeUti() {
		return typeUti;
	}


	public void setTypeUti(String typeUti) {
		this.typeUti = typeUti;
	}


	public String getLoginUti() {
		return loginUti;
	}


	public void setLoginUti(String loginUti) {
		this.loginUti = loginUti;
	}


	public String getPswdUti() {
		return pswdUti;
	}


	public void setPswdUti(String pswdUti) {
		this.pswdUti = pswdUti;
	}


	public int getEtatstock_idstock() {
		return etatstock_idstock;
	}


	public void setEtatstock_idstock(int etatstock_idstock) {
		this.etatstock_idstock = etatstock_idstock;
	}


	public Utilisateur(int idUti, String n0mUti, String adrUti, int telUti, String typeUti, String loginUti,
			String pswdUti, int etatstock_idstock) {
		super();
		this.idUti = idUti;
		this.nomUti = nomUti;
		this.adrUti = adrUti;
		this.telUti = telUti;
		this.typeUti = typeUti;
		this.loginUti = loginUti;
		this.pswdUti = pswdUti;
		this.etatstock_idstock = etatstock_idstock;
	}
	
	
}
