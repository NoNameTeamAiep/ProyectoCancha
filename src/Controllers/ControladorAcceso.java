
package Controllers;

import Models.AccesoADO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


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
    public DefaultTableModel MostrarEvent(){
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Complejo");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora inicio");
        modelo.addColumn("Hora Termino");
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from SOLICITUD");
            while (rs.next()){//Verifica si hay datos
            Object dato[] = new Object[5];
                dato[0]=rs.getString("IDSOLICITUD");
                dato[1]=rs.getString("IDCOMPLEJO");
                dato[2]=rs.getString("FECHA");
                dato[3]=rs.getString("HORAINICIO");
                dato[4]=rs.getString("HORATERMINO");
                modelo.addRow(dato);//Se llena una fila para las jTable
            }
            
        }catch(Exception e){
    
        }
        return modelo;//Se envia el modelo
    }
    public DefaultTableModel MostrarComisario(){
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("ID COMISARIO");
        modelo.addColumn("Numero Evento");
        modelo.addColumn("Rut");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Telefono");
        modelo.addColumn("Mail");
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from COMISARIO");
            while (rs.next()){//Verifica si hay datos
            Object dato[] = new Object[8];
                dato[0]=rs.getString("IDCOMISARIO");
                dato[1]=rs.getString("IDEVENTO");
                dato[2]=rs.getString("RUNCOM");
                dato[3]=rs.getString("NOMBREC");
                dato[4]=rs.getString("APPAT");
                dato[5]=rs.getString("APMAT");
                dato[6]=rs.getString("FONO");
                dato[7]=rs.getString("EMAIL");
                modelo.addRow(dato);//Se llena una fila para las jTable
            }
            
        }catch(Exception e){
    
        }
        return modelo;//Se envia el modelo
    }
    public DefaultTableModel MostrarDepo(){
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Numero Evento");
        modelo.addColumn("Nombre deportista");
        modelo.addColumn("Apellido");
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from DEPORTISTA");
            while (rs.next()){//Verifica si hay datos
            Object dato[] = new Object[4];
                dato[0]=rs.getString("IDDEPOR");
                dato[1]=rs.getString("IDEVENTO");
                dato[2]=rs.getString("NOMBRE");
                dato[3]=rs.getString("APELLIDO");
                modelo.addRow(dato);//Se llena una fila para las jTable
            }
            
        }catch(Exception e){
    
        }
        return modelo;//Se envia el modelo
    }
    public DefaultTableModel MostrarMantencion(){
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Numero Evento");
        modelo.addColumn("Tipo mantencion");
        modelo.addColumn("Descripcion");
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from MANTENCION");
            while (rs.next()){//Verifica si hay datos
            Object dato[] = new Object[4];
                dato[0]=rs.getString("IDMANTENCION");
                dato[1]=rs.getString("IDEVENTO");
                dato[2]=rs.getString("TIPO");
                dato[3]=rs.getString("DESCRIPCION");
                modelo.addRow(dato);//Se llena una fila para las jTable
            }
            
        }catch(Exception e){
    
        }
        return modelo;//Se envia el modelo
    }
}
