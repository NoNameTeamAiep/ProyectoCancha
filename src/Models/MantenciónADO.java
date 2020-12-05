package Models;

import java.sql.*;
import javax.swing.JOptionPane;

public class MantenciónADO {

        Connection conexion=null;
        public Connection GetConnection()
        {

            try
            {
                String cadena;
                String nombreServidor="DESKTOP-QKL9PPC";
                String nombreBD= "Olimpiadas";
                String nombreUsuario= "usuarioSQL";
                String llave= "123";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                cadena = "jdbc:sqlserver://" + nombreServidor + ":1433;databaseName=" + nombreBD + 
                        ";user=" + nombreUsuario + ";password=" + llave;
                conexion= DriverManager.getConnection(cadena);
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