package org.sakhnyasha.model;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.sakhnyasha.entity.City;
import org.sakhnyasha.entity.Country;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class NewHotelModel {

    @NotNull(message = "Country must be chosen")
    private Long cityId;

    @NotBlank
    @Pattern(regexp = "[A-z0-9 \\-,.]+", message = "Hotel address must contain only A-z characters, 0-9, " +
            "space, -, . and comma")
    private String hotelAddress;

    @NotBlank
    @Pattern(regexp = "[A-z \\-]+", message = "Hotel name must contain only A-z characters, space and -")
    private String hotelName;

}
