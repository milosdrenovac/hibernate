package hibernate;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "employees")
public class Employee implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)       
    private int id;
    String name;
    private int age;
    private String address;
    private int income; 
    
    public Employee(){   
    }
    public Employee(int id, String name, int age, String address, int income){   
        this.id=id;
        this.name=name;
        this.age=age;
        this.address=address;
        this.income=income;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    
    public int getIncome(){
        return income;
    }
    public void setIncome(int income){
        this.income=income;
    }
        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Age: " + this.age + ", Address: " + this.address + ", Income: " + this.income + "$";
    }

    
}
