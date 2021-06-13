package org.sakhnyasha.entity;


import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity{

    @Column(name = "name", unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
