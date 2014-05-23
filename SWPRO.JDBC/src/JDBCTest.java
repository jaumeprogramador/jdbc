import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
 
class JDBCTest {
 
    private static final String url = "jdbc:mysql://localhost:3306/biblioteca?";
 
    private static final String user = "root";
 
    private static final String password = "root";
 
    public static void main(String args[]) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connectat");
            Statement st = con.createStatement();
            
            //Execute per fer select. Per update or delete altre!!!
            ResultSet rs=st.executeQuery("SELECT `ID_AUT`, `NOM_AUT`, `DNAIX_AUT`, `FK_NACIONALITAT`, `IMG_AUT` FROM `autors");
            ArrayList<Autors> escriptors = new ArrayList<>();
            while(rs.next()){
//            int idAut = rs.getInt("ID_AUT");
//            String nom = rs.getString("NOM_AUT");
//            System.out.println(nom);
            Autors nova=new Autors(rs.getInt("ID_AUT"), rs.getString("NOM_AUT"));
            System.out.println(nova);
            escriptors.add(nova);
            }
            //Mostrar els nous
            for (Autors autors: escriptors){
            	System.out.println(autors);
            }
            rs.close();
            st.close();
            con.close();
 
        } catch (SQLException ex) {
        	//Els dos bàsics per informar
        	ex.getErrorCode();
        	ex.getLocalizedMessage();
        }
    
}
}