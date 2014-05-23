
public class Autors {

	int idAut;
    String nom;
    
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
	
	public Autors(int idAut, String nom) {
		super();
		this.idAut = idAut;
		this.nom = nom;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAut;
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
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Autors [idAut=" + idAut + ", nom=" + nom + "]";
	}
    
    
    
}
