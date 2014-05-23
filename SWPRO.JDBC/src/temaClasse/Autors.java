package temaClasse;

public class Autors {

	int idAut;
    String nom;
    String nacionalitat;
    
	public int getIdAut() {
		return idAut;
	}
	public void setIdAut(int idAut) {
		this.idAut = idAut;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNacionalitat() {
		return nacionalitat;
	}
	public void setNacionalitat(String nacionalitat) {
		this.nacionalitat = nacionalitat;
	}
	public Autors(int idAut, String nom, String clauForania) {
		super();
		this.idAut = idAut;
		this.nom = nom;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAut;
		result = prime * result
				+ ((nacionalitat == null) ? 0 : nacionalitat.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autors other = (Autors) obj;
		if (idAut != other.idAut)
			return false;
		if (nacionalitat == null) {
			if (other.nacionalitat != null)
				return false;
		} else if (!nacionalitat.equals(other.nacionalitat))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Autors [idAut=" + idAut + ", nom=" + nom + ", nacionalitat="
				+ nacionalitat + "]";
	}
	
    
    
    
}
