
package dato;

import java.sql.*;

public class Conexion {
    
    public static final String MYSQL_URL ="jdbc:mysql://localhost:3306/datospersona?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String MYSQL_USER ="root"; 
    public static final String MYSQL_PASSWORD ="admin";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
    } 
    
    public static void closeflujo(Connection conn) throws SQLException{
        conn.close();
    } 
    
    public static void closeflujo (PreparedStatement stmn) throws SQLException{
        stmn.close();
    } 
    
    public static void closeflujo(ResultSet rs) throws SQLException{
        rs.close();
    }
            
    
    
}
