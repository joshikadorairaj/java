package com.kgisl.JPAProject;

import java.util.*;  
  
import jakarta.persistence.*;  
@Entity  
  
public class Employee {  
  
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private int e_id;  
    private String e_name;  
      
    @ElementCollection  
    private List<Address> address=new ArrayList<Address>();  
  
      
    public int getE_id() {  
        return e_id;  
    }  
  
    public void setE_id(int e_id) {  
        this.e_id = e_id;  
    }  
  
    public String getE_name() {  
        return e_name;  
    }  
  
    public void setE_name(String e_name) {  
        this.e_name = e_name;  
    }  
  
    public List<Address> getAddress() {  
        return address;  
    }  
  
    public void setAddress(List<Address> address) {  
        this.address = address;  
    }

    @Override
    public String toString() {
        return "Employee [e_id=" + e_id + ", e_name=" + e_name + ", address=" + address + "]";
    }  
  
      
}  
