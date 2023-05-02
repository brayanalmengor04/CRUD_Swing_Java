
package dato;

import domain.Persona;
import java.sql.SQLException;
import java.util.*;


public interface IPerson {
    
    public List<Persona>SELECT ();
    public void INSERT(Persona persona); 
    public void UPDATE (Persona persona); 
    public void DELETE(Persona persona); 
       
}
