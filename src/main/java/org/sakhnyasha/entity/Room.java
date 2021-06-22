package org.sakhnyasha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Room extends BaseEntity{

    @Column(name = "name")
    @Size(min = 3, max = 50, message = "{hotel.name.invalid}")
    @NotBlank(message = "Please enter hotel name")
    private String name;

    @Column(name = "price")
    @Min(0)
    private Double price;

    @Column(name = "capacity")
    @Min(1)
    @Max(10)
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;
}
