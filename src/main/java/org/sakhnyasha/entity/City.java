package org.sakhnyasha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Data
@Entity
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class City extends BaseEntity{

    @Column(name = "name", unique = true)
    @NotBlank(message = "Please enter city name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

}
