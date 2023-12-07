package com.kgisl.JPAProject;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity  
public class Student {  
  
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private int s_id;  
    private int s_age;
    private String s_name;  
      
    // @ManyToOne  
    // private Library lib;  
      
    public int getS_id() {  
        return s_id;  
    }  
    public void setS_id(int s_id) {  
        this.s_id = s_id;  
    }  
    
    public String getS_name() {  
        return s_name;  
    }  
    public void setS_name(String s_name) {  
        this.s_name = s_name;  
    }  
    // public Library getLib() {  
    //     return lib;  
    // }  
    // public void setLib(Library lib) {  
    //     this.lib = lib;  
    
    public int getS_age() {
        return s_age;
    }
    public void setS_age(int s_age) {
        this.s_age = s_age;
    }
    @Override
    public String toString() {
        return "Student [s_id=" + s_id + ", s_age=" + s_age + ", s_name=" + s_name + "]";
    }
    
}  
      
