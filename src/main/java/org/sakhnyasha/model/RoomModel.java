package org.sakhnyasha.model;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RoomModel {

    @NotBlank
    @Pattern(regexp = "[A-z]+", message = "Room name must contain only A-z characters")
    private String name;

    @NotNull(message = "Price must be defined")
    @Min(0)
    private Double price;

    @NotNull(message = "Capacity must be between 1 to 10")
    @Min(1)
    @Max(10)
    private Integer capacity;
}
