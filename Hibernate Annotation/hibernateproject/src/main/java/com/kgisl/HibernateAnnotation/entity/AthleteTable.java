package com.kgisl.HibernateAnnotation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AthleteTable {
    @Id
    private int athlete_id;
    @Column(name = "athlete_name", unique = true)
    private String athlete_name;
 
    public AthleteTable() {
    }
    public int getAthlete_id() {
        return athlete_id;
    }
    public void setAthlete_id(int athlete_id) {
        this.athlete_id = athlete_id;
    }
    public String getAthlete_name() {
        return athlete_name;
    }
    public void setAthlete_name(String athlete_name) {
        this.athlete_name = athlete_name;
    }
   
   
}
