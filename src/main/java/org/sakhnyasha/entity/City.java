package org.sakhnyasha.entity;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City extends BaseEntity{

    @Column(name = "name", unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
