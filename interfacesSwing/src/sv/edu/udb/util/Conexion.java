package sv.edu.udb.util;

import java.sql.*;

public class Conexion {
    //valores de conexion a mysql
    private static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String JDBC_URL="jdbc:mysql://localhost:3308:personabdd";
    private static String JDBC_USER="root";
    private static String JDBC_PASS="";
    private static Driver driver=null;

    //para que no hayan problemas al obtener la conexion de manera concurrente
    //se utiliza la palabra synchronized
    public static synchronized Connection getConnection() throws SQLException{
        Connection con = null;

        if (driver==null){
            try{
                Class.forName(JDBC_DRIVER);
            } catch (Exception e){
                System.out.println("Fallo en cargar el driver JDBC");
                e.printStackTrace();
            }
        } return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    } //cierre del resultset
    public static void close(ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
    //cieere del preparestatement
    public static void close(PreparedStatement stmt){
        try{
            if(stmt!=null){
                stmt.close();
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
    } //cierre de la conexion
    public static void close(Connection conn)
    {
        try{
            if (conn != null){
                conn.close();
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }}
