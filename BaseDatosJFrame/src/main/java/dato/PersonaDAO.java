
package dato;

import domain.Persona;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PersonaDAO implements IPerson{

    public static final String MYSQL_INSERT ="INSERT INTO datospersona.person (name, lastname,age,gmail) VALUES (?, ?, ?,?)";
    
    public PersonaDAO (){
      
    }
    
    
    @Override
    public void INSERT(Persona persona){ 
        Connection conexion=null;
        PreparedStatement stament =null;
        try {
            conexion = Conexion.getConnection(); 
            System.out.println(conexion);  
            System.out.println("Conexion Establecida");
            stament = conexion.prepareStatement(MYSQL_INSERT);
            
            stament.setString(1, persona.getName()); 
            stament.setString(2, persona.getLastname());
            stament.setInt(3, persona.getAge());
            stament.setString(4, persona.getGmail());
            int resultado = stament.executeUpdate(); 
            
            JOptionPane.showMessageDialog(null, "Filas afectadas : "+resultado);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
}
