package cat.iespaucasesnoves.swpro.jdbc.executable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import temaClasse.Autors;

public class ProvesJDBC {

	private static final String url = "jdbc:mysql://localhost:3306/biblioteca?";

	private static final String user = "root";

	private static final String password = "root";

	// Per aquest exercici necessitaràs una taula amb una clau forana, per
	// exemple, empleats amb el departament. Crea un mètode a la classe Proves
	// que rebi com a paràmetre el valor de la clau forana. Mostra per pantalla
	// tots els registres que contenguin aquest valor a la clau forana.
	public static void mostrar(String parametreCerca) throws Exception {
		// Obtenir una connexió amb la base de dades.
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("Connectat");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM autors WHERE ID_AUT < "
				+ parametreCerca);
		System.out.println(rs);
		// Para crear y guardar nuevos Autores en la clase Autor
		ArrayList<Autors> coleccio = new ArrayList<Autors>();
		// Tractar les files tornades per la consulta.
		while (rs.next()) {
			// DADES idAutor, nomAutor, data, nacionalitat
			int idAutor = rs.getInt("ID_AUT");
			String nomAutor = rs.getString("NOM_AUT");
			String data = rs.getString("DNAIX_AUT");
			String nacionalitat = rs.getString("FK_NACIONALITAT");
			System.out.println(idAutor + " " + nomAutor + " " + data + " "
					+ nacionalitat);
			Autors nou = new Autors(idAutor, nomAutor, nacionalitat);
			System.out.println(nou);
			// creamos nuevos autores
			coleccio.add(nou);
		}
		// tancam tot
		rs.close();
		st.close();
		con.close();
	}

	// Crea un mètode anomenat insereixXXX() que insereixi una fila a una taula
	// A i tres més a una altra taula B que contengui la clau primària de A com
	// a forana.
	public static void insereixXXX() throws Exception {
		// Obtenir una connexió amb la base de dades.
		String url = "jdbc:mysql://localhost:3306/biblioteca?user=root&password=678981369";
		Connection conexio = DriverManager.getConnection(url);
		// creamos la conexion
		Statement st = conexio.createStatement();
		int filesAfectades = st
				.executeUpdate("INSERT INTO AUTORS(ID_AUT,NOM_AUT) VALUES(781000,'Felix')");
		System.out.println(filesAfectades);
		// Para crear y guardar nuevos Autores en la clase Autor
		ArrayList<Autors> coleccio = new ArrayList<Autors>();
		st.close();
		conexio.close();
	}

	// Crea el mètode cercaXXX que mostri per pantalla les dades de la fila
	// inserida a la taula A a l'exercici anterior. Utilitza un Select per
	// comprovar que la inserció s'ha realitzat correctament.
	public static void cercaXXX() throws Exception {
		// Obtenir una connexió amb la base de dades.
		String url = "jdbc:mysql://localhost:3306/biblioteca?user=root&password=678981369";
		Connection conexio = DriverManager.getConnection(url);
		// creamos la conexion
		Statement st = conexio.createStatement();
		int filesAfectades = st
				.executeUpdate("INSERT INTO AUTORS(ID_AUT,NOM_AUT) VALUES(781000,'Felix')");
		System.out.println(filesAfectades);
		// Para crear y guardar nuevos Autores en la clase Autor
		ArrayList<Autors> coleccio = new ArrayList<Autors>();
		st.close();
		conexio.close();
	}


	// Crea el mètode insereixXXXTransacció que utilitzi una transacció per
	// afegir una fila a una taula A i tres més a una altra taula B que
	// contengui la clau primària de A com a forana. Captura l'SQLException i si
	// hi ha hagut un error fes un rollback. Crida el mètode cercaXXX per
	// comprovar si l'ha inserit.
	public static void insereixXXXTransaccio() throws Exception {
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("Connectat");
		Statement st = con.createStatement();
		
		PreparedStatement preparedStatementInsert = null;
		PreparedStatement preparedStatementUpdate = null;
 
		String insertTableSQL = "INSERT INTO autors"
				+ "(ID_AUT, NOM_AUT, FK_NACIONALITAT) VALUES"
				+ "(?,?,?)";
 
		String updateTableSQL = "UPDATE autors SET NOM_AUT =? "
				+ "WHERE ID_AUT = ?";
 
		try {
			con.setAutoCommit(false);
 
			preparedStatementInsert = con.prepareStatement(insertTableSQL);
			preparedStatementInsert.setInt(1, 9997);
			preparedStatementInsert.setString(2, "Jaume");
			preparedStatementInsert.setString(3, "Espanyola");
			preparedStatementInsert.executeUpdate();
 
			preparedStatementUpdate = con.prepareStatement(updateTableSQL);
			preparedStatementUpdate.setString(1, "Pepet Llull");
			preparedStatementUpdate.setInt(2, 1);
			preparedStatementUpdate.executeUpdate();
 
			con.commit();
 
			System.out.println("Fet!");
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
			con.rollback();
 
		} finally {
 
			if (preparedStatementInsert != null) {
				preparedStatementInsert.close();
			}
 
			if (preparedStatementUpdate != null) {
				preparedStatementUpdate.close();
			}
 
			if (con != null) {
				con.close();
			}
 
		}
	}
	
	

	public static void main(String[] args) throws Exception {
		mostrar("30");
		insereixXXXTransaccio();
		mostrar("30");

	}

}
