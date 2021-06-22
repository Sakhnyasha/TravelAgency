package org.sakhnyasha.model;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CityModel {

    @NotBlank
    @Pattern(regexp = "[A-z \\-]+", message = "City must contain only A-z characters, space and -")
    private String name;

    @NotNull(message = "Country must be chosen")
    private Long countryId;
}
