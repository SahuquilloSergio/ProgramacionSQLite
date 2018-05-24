package pruebabd;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class metodos extends Controlador{

    Controlador con = new Controlador();
    
    
    public void connect(){
       
        try{
            Class.forName("org.sqlite.JDBC");
            c= DriverManager.getConnection("jdbc:sqlite:"+c);
            c.setAutoCommit(false);
            if (c!=null){
                System.out.println("Conectado");
            }
        }catch (SQLException e){
            System.out.println("Error: "+e);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: "+ex);
        }
    }
    
    public void close(){
        try {
            if(stmt != null){
                stmt.close();
            }
            if(c != null){
            c.close();    
            }
            System.out.println("Base Cerrada");
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
        }
    }
    
    public void crearTabla(){
        try {
            stmt = c.createStatement();
            String sql = "CREATE TABLE Alumno " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NOME           TEXT    NOT NULL, " +
                    " EDADE          INT     NOT NULL, " +
                    " RUA        CHAR(50))";
            stmt.executeUpdate(sql);
            System.out.println("Tabla Creada");
        } catch (SQLException ex) {
            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    public void insertarValores(){
        try {
            stmt = c.createStatement();
            String sql = " INSERT INTO Alumno(ID,NOME,EDADE,RUA)"
                    + "VALUES(1, 'Sergio', 19, 'Balaidos');";
            stmt.executeUpdate(sql);
            sql = " INSERT INTO Alumno(ID,NOME,EDADE,RUA)"
                    + "VALUES(2, 'Adrian', 23, 'G.Barbon');";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            System.out.println("Filas añadidas");
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
        }
    }
    
    public void select(DefaultTableModel tabla){
        try {
            if (tabla.getRowCount() != 0) {
                do {
                    tabla.removeRow(tabla.getRowCount() - 1);
                } while (tabla.getRowCount() > 0);
            }
            
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Alumno;");
            
            while(rs.next()){
                int id = rs.getInt("ID");
                String nome = rs.getString("NOME");
                int edade = rs.getInt("EDADE");
                String rua = rs.getString("RUA");
                obj = new Object[]{id,nome,edade,rua};
                tabla.addRow(obj);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Operacion realizada con exito");
    }
    
    public void Updatear(){
        try {
            stmt = c.createStatement();
            String update = "UPDATE Alumno set EDADE = 24 where ID=2;";
            stmt.executeUpdate(update);
            c.commit();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
        }
    }
    
    public void Delete(){
        try {
            stmt = c.createStatement();
            String delete = "DELETE from Alumno where ID=2;";
            stmt.executeUpdate(delete);
            c.commit();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
