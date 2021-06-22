package org.sakhnyasha.model;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.sakhnyasha.entity.City;
import org.sakhnyasha.entity.Country;
import org.sakhnyasha.entity.Room;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BookingModel {

    @NotNull(message = "Choose country", groups = {ValidationStepOne.class})
    private Long selectedCountryId;

    @NotNull(message = "Choose country", groups = {ValidationStepTwo.class})
    private Long selectedCityId;

    @NotBlank(message = "Choose checkIn date", groups = {ValidationStepTwo.class, ValidationStepThree.class})
    private String checkIn;

    @NotBlank(message = "Choose checkOut date", groups = {ValidationStepTwo.class, ValidationStepThree.class})
    private String checkOut;

    @NotNull
    @Min(value = 1, groups = {ValidationStepTwo.class})
    @Max(value = 10, groups = {ValidationStepTwo.class})
    private Integer capacity;

    private List<Room> availableRooms;

    @NotNull(message = "Choose your room", groups = {ValidationStepThree.class})
    private Long selectedRoom;

    public interface ValidationStepOne{}

    public interface ValidationStepTwo{}

    public interface ValidationStepThree{}


}


