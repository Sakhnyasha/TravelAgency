package org.sakhnyasha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sakhnyasha.entity.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;

}
