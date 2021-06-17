package org.sakhnyasha.model;

import lombok.*;
import org.sakhnyasha.entity.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserModel {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;

}
