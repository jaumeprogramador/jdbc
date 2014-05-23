package cat.iespaucasesnoves.swpro.jdbc.executable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import temaClasse.Autors;

public class ProvesJDBC {
	// Per aquest exercici necessitaràs una taula amb una clau forana, per
	// exemple, empleats amb el departament. Crea un mètode a la classe
	// Proves que rebi com a paràmetre el valor de la clau forana. Mostra
	// per pantalla tots els registres que contenguin aquest valor a la clau
	// forana.
		private static final String url = "jdbc:mysql://localhost:3306/biblioteca?";
	    private static final String user = "root";
	    private static final String password = "root";
	    private static Statement st;
	    
	public void connexio(){
		Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("Connectat");
        st = con.createStatement();
	}
	

	public static void main(String[] args) {
	ResultSet rs=st.executeQuery("SELECT `ID_AUT`, `NOM_AUT`, `DNAIX_AUT`, `FK_NACIONALITAT`, `IMG_AUT` FROM `autors");
    ArrayList<Autors> escriptors = new ArrayList<>();
    while(rs.next()){
//    int idAut = rs.getInt("ID_AUT");
//    String nom = rs.getString("NOM_AUT");
//    System.out.println(nom);
    Autors nova=new Autors(rs.getInt("ID_AUT"), rs.getString("NOM_AUT"), rs.getString("FK_NACIONALITAT"));
    System.out.println(nova);
    escriptors.add(nova);
	}

	}}}
