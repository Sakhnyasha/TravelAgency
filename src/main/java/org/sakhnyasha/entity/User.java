package org.sakhnyasha.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
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
    @Size(min=3, max = 50, message = "{user.first_name.invalid}")
    @NotEmpty(message = "Please enter your first name")
    private String firstName;

    @Column(name = "last_name")
    @Size(min=3, max = 50, message = "{user.last_name.invalid}")
    @NotEmpty(message = "Please enter your last name")
    private String lastName;

    public User() {
    }

    public User(Long id, String email, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && email.equals(user.email) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstName, lastName);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
