package modele;

public class Saisir {
	
	private int idUti;
	private int idEntree;

	 public  Saisir(){}

	public Saisir(int idUti, int idEntree) {
		super();
		this.idUti = idUti;
		this.idEntree = idEntree;
	}

	public int getIdUti() {
		return idUti;
	}

	public void setIdUti(int idUti) {
		this.idUti = idUti;
	}

	public int getIdEntree() {
		return idEntree;
	}

	public void setIdEntree(int idEntree) {
		this.idEntree = idEntree;
	}

	 
}
