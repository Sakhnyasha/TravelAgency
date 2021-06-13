package org.sakhnyasha.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @Setter
    @Getter
    @GeneratedValue
    @Column(name = "id")
    protected Long id;
}
