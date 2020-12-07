package Controllers;

import Models.Acceso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testç {
    Acceso acc= new Acceso();
    Connection con=null;
        public Connection GetConnection()
        {

            try
            {
                String connectionURL;
                String nombreServidor="DESKTOP-QKL9PPC";
                String nombreBD="Olimpiada";
                String nombreUsuario="userSQL";
                String llave="321";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                
                connectionURL = "jdbc:sqlserver://" + nombreServidor + ":1433;databaseName=" + nombreBD + 
                        ";user=" + nombreUsuario + ";password=" + llave;            
                con= DriverManager.getConnection(connectionURL);
                System.out.println("Funca");
                return con;
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        return null;
        }
    
}