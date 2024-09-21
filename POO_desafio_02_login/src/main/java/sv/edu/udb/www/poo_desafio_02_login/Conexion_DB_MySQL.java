package sv.edu.udb.www.poo_desafio_02_login;

import java.sql.*;

public class Conexion_DB_MySQL {
    private Connection conexion=null;
    private Statement s = null;
    private ResultSet rs=null;

    public Conexion_DB_MySQL() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/thetempertrap", "root", "");
            s = conexion.createStatement();
        }catch (ClassNotFoundException e1){
            System.out.println("ERROR: No se puede encontrar el driver de la DB"+e1.getMessage());
        }
    }
    public  ResultSet getRs(){
        return rs;
    }
    //Recibe un sql como parametro para el CRUD
    public void setQuery(String query) throws SQLException{
        this.s.executeUpdate(query);
    }
    //Cerramos la conexion
    public void CerrarConexion() throws SQLException{
        conexion.close();
    }
}
