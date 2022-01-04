package modele;

public class Familllepro {
	
	private int codeFam;
	private String nomFam;
	
	public Familllepro(){}

	public Familllepro(int codeFam, String nomFam) {
		super();
		this.codeFam = codeFam;
		this.nomFam = nomFam;
	}

	public int getCodeFam() {
		return codeFam;
	}

	public void setCodeFam(int codeFam) {
		this.codeFam = codeFam;
	}

	public String getNomFam() {
		return nomFam;
	}

	public void setNomFam(String nomFam) {
		this.nomFam = nomFam;
	}
	
	

}
