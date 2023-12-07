package com.kgisl.HibernateAnnotation.entity;

import java.sql.Date;

import org.hibernate.annotations.Check;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Check(constraints = "event_date > CURRENT_DATE")
@Entity
public class EventsTable {
    @Id
    private int event_id;
    @Column(name = "event_name", unique = true)
    private String event_name;
    @Column(name = "event_date", unique = true)
    private Date event_date;
    @Column(name = "location", unique = true)
    private String location;
    private String description;

    public EventsTable() {
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}