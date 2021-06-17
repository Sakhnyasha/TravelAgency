package org.sakhnyasha.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordConfirmation;
}
