package com.kgisl.HibernateAnnotation.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class EventRegistrationsTable {
    @Id
    private int registration_id;

    @OneToOne
    @JoinColumn(name = "event_id", unique = true)
    private EventsTable event;

    @OneToOne
    @JoinColumn(name = "athlete_id", unique = true)
    private AthleteTable athlete;

    @Column(name = "registration_date", unique = true)
    private Date registration_date;

    public int getRegistration_id() {
        return registration_id;
    }

    public void setRegistration_id(int registration_id) {
        this.registration_id = registration_id;
    }

    public EventsTable getEvent() {
        return event;
    }

    public void setEvent(EventsTable event) {
        this.event = event;
    }

    public AthleteTable getAthlete() {
        return athlete;
    }

    public void setAthlete(AthleteTable athlete) {
        this.athlete = athlete;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }
}