package com.db.library.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Magazines")
public class Magazine {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private java.util.Date date;

    @Column(name = "location")
    private String location;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }  

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public java.util.Date getDate() {
        return this.date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}

