package pruebabd;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

public class Controlador {
    
    String url = "BDrelacional.bd";
    Connection c = null;
    Statement stmt = null;
    Alumno Al = new Alumno();
    Object [] obj = null;
    Button Boton;
    Interfaz I = new Interfaz();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection getC() {
        return c;
    }

    public void setC(Connection c) {
        this.c = c;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public Alumno getAl() {
        return Al;
    }

    public void setAl(Alumno Al) {
        this.Al = Al;
    }

    public Object[] getObj() {
        return obj;
    }

    public void setObj(Object[] obj) {
        this.obj = obj;
    }
    
    
    public void interfaz(){
        I.setVisible(true);
    }
    public void conectarse(ActionListener Boton){
        
    }
}
