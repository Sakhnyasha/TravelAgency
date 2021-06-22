package org.sakhnyasha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel extends BaseEntity{

    @Column(name = "name")
    @Size(min = 3, max = 50, message = "{hotel.name.invalid}")
    @NotBlank(message = "Please enter hotel name")
    private String name;

    @Column(name = "address")
    @Size(min = 3, max = 150, message = "{hotel.address.invalid}")
    @NotBlank(message = "Please enter hotel local address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

}
