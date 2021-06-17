package org.sakhnyasha.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class HotelModel {

    private Long id;
    private String name;
    private String address;
    private String country;
    private String city;
}
