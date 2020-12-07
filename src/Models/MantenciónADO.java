package Models;

import java.sql.*;
import javax.swing.JOptionPane;

public class MantenciónADO {

        Connection conexion=null;
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
                conexion= DriverManager.getConnection(connectionURL);
                return conexion;
            } catch(ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                conexion=null;
                return conexion;
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                conexion=null;
                return conexion;
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                conexion=null;
                return conexion;
            }
        }
        
}