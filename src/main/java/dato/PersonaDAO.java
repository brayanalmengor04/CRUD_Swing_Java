
package dato;

import domain.Persona;
import java.sql.*;
import java.util.*; 
import javax.swing.JOptionPane;


public class PersonaDAO implements IPerson{
    
    public static final String MYSQL_SELECT="SELECT id_person, name, lastname, age ,gmail FROM datospersona.person ";
    public static final String MYSQL_INSERT ="INSERT INTO datospersona.person (name, lastname,age,gmail) VALUES (?, ?, ?,?)";
    public static final String MYSQL_UPDATE = "UPDATE datospersona.person SET name=?,lastname=?,age=?,gmail=? WHERE id_person=?";
    public static final String MYSQL_DELETE="DELETE FROM datospersona.person WHERE id_person=? ";
    public PersonaDAO (){
      
    } 
    
    @Override
    public List<Persona> SELECT() { 
        Connection conexion =null;  
        PreparedStatement stmn=null;
        ResultSet rs =null; 
        Persona persona = null; 
        
         List<Persona> personas = new ArrayList<>(); 
         
        try { 
            conexion = Conexion.getConnection();
            stmn = conexion.prepareStatement(MYSQL_SELECT); 
            rs = stmn.executeQuery(); 
               
            while (rs.next()){
                int id_persona = rs.getInt("id_person");
                String name = rs.getString("name"); 
                String lastname = rs.getString("lastname"); 
                int age = rs.getInt("age"); 
                String gmail = rs.getString("gmail"); 
                persona = new Persona(name, lastname, age, gmail, id_persona); 
                personas.add(persona); 
            }
            
            
        } catch (SQLException ex) { 
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                Conexion.closeflujo(rs);
                Conexion.closeflujo(stmn); 
                Conexion.closeflujo(conexion); 
                
            } catch (SQLException ex) { 
                ex.printStackTrace(System.out);
            }
        }
        
        
        return  personas;
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
         finally{
            try {
                Conexion.closeflujo(stament); 
                 Conexion.closeflujo(conexion);
            } catch (SQLException ex) { 
                ex.printStackTrace(System.out);
            }  
        }
        
    }

    @Override
    public void UPDATE(Persona persona) {
        Connection conexion = null;  
        PreparedStatement stament = null;  
        
        try { 
            conexion= Conexion.getConnection();
            stament = conexion.prepareStatement(MYSQL_UPDATE); 
             stament.setString(1, persona.getName()); 
            stament.setString(2, persona.getLastname());
            stament.setInt(3, persona.getAge());
            stament.setString(4, persona.getGmail());
            stament.setInt(5, persona.getId_person());
            int resultado = stament.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Se ha detectado  Fila afectada "+resultado);
            
        } catch (SQLException ex) { 
            ex.printStackTrace(System.out);
        }
         finally{
            try {
                Conexion.closeflujo(stament); 
                 Conexion.closeflujo(conexion);
            } catch (SQLException ex) { 
                ex.printStackTrace(System.out);
            }
           
        }
    }

    @Override
    public void DELETE(Persona persona) { 
        Connection conexion = null;  
        PreparedStatement stament = null;  
        
        try { 
            conexion= Conexion.getConnection();
            stament = conexion.prepareStatement(MYSQL_DELETE); 
            
            stament.setInt(1, persona.getId_person()); 
            int resultado = stament.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha detectado Fila :"+resultado+" afectada !");
            
        } catch (SQLException ex) { 
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                Conexion.closeflujo(stament); 
                 Conexion.closeflujo(conexion);
            } catch (SQLException ex) { 
                ex.printStackTrace(System.out);
            }
           
        }
    }

    

    
}
