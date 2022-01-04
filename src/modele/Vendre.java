package modele;

public class Vendre {
	
	private int idSortie;
	private int idUti;
	
	public Vendre(){}

	public Vendre(int idSortie, int idUti) {
		super();
		this.idSortie = idSortie;
		this.idUti = idUti;
	}

	public int getIdSortie() {
		return idSortie;
	}

	public void setIdSortie(int idSortie) {
		this.idSortie = idSortie;
	}

	public int getIdUti() {
		return idUti;
	}

	public void setIdUti(int idUti) {
		this.idUti = idUti;
	}
	
	

}
