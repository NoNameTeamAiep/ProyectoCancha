
package Controllers;

import Models.AccesoADO;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class ControladorAcceso {
    
    String server ="DESKTOP-QKL9PPC";
    String DB="Olimpiada";
    String user ="userSQL";
    String password="321";
    static int cont=0;
    Connection con;
    public static String userName;
    
    public Connection conectar(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://"+server+":1433;databaseName="+DB
                                    +";user="+user+";password="+password;
            con = DriverManager.getConnection(connectionURL); 
            if (cont==0){
            JOptionPane.showMessageDialog(null, "Conexion Realizada con exito");
            cont +=1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en la conexion");
        }
        return con;
    }
    
}
