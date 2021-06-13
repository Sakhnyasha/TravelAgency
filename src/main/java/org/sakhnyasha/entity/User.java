package org.sakhnyasha.entity;


import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.validation.constraints.*;


@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "users")
@Data
public class User extends BaseEntity {

    @Column(name = "email", unique = true)
    @Email(message = "{user.email.invalid}")
    @NotEmpty(message = "Please enter your email")
    private String email;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("USER")
    @Column(name = "role", nullable = false)
    private Role role = Role.USER;

    @Column(name = "first_name")
    @Size(min = 3, max = 50, message = "{user.first_name.invalid}")
    @NotEmpty(message = "Please enter your first name")
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 3, max = 50, message = "{user.last_name.invalid}")
    @NotEmpty(message = "Please enter your last name")
    private String lastName;

    @Column(name = "password", nullable = false)
    private String password;
}
