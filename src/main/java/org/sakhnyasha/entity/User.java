package org.sakhnyasha.entity;


import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;




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
    @NotBlank(message = "Please enter your email")
    private String email;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("USER")
    @Column(name = "role", nullable = false)
    private Role role = Role.USER;

    @Column(name = "first_name")
    @Length(min = 3, max = 50, message = "{user.first_name.invalid}")
    @NotBlank(message = "Please enter your first name")
    private String firstName;

    @Column(name = "last_name")
    @Length(min = 3, max = 50, message = "{user.last_name.invalid}")
    @NotBlank(message = "Please enter your last name")
    private String lastName;

    @Column(name = "password", nullable = false)
    @Length(min = 3, max = 90)
    private String password;
}
