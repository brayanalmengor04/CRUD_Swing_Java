
package domain;


public class Persona {
    private String name ;
    private String lastname; 
    private int age ;  
    private String gmail; 
    private int id_person;  

    public Persona() {}
    
    // Constructor insertar
    public Persona(String name, String lastname, int age, String gmail) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.gmail = gmail;
    }
    // Constructor Update 
    public Persona(String name, String lastname, int age, String gmail, int id_person) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.gmail = gmail;
        this.id_person = id_person;
    }
    // Constructor Delete
    public Persona(int id_person) {
        this.id_person = id_person;
    } 
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGmail() {
        return this.gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public int getId_person() {
        return this.id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("name=").append(name);
        sb.append(", lastname=").append(lastname);
        sb.append(", age=").append(age);
        sb.append(", gmail=").append(gmail);
        sb.append(", id_person=").append(id_person);
        sb.append('}');
        return sb.toString();
    }
    
}
