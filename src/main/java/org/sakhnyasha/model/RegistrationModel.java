package org.sakhnyasha.model;


import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationModel {

    @NotBlank
    @Pattern(regexp = "[A-z]+", message = "First name must contain only A-z characters")
    @Length(min = 3, max = 50)
    private String firstName;

    @NotBlank
    @Pattern(regexp = "[A-z]+", message = "Last name must contain only A-z characters")
    @Length(min = 3, max = 50)
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Length(min = 3, max = 32)
    private String password;

    @NotBlank
    @Length(min = 3, max = 32)
    private String passwordConfirmation;
}
