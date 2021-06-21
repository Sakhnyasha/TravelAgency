package org.sakhnyasha.security;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.sakhnyasha.entity.Role;
import org.sakhnyasha.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//active user representation
@EqualsAndHashCode
@AllArgsConstructor
public class UserPrincipal implements UserDetails {

    @Getter
    private Long id;
    @Getter
    private String firstName;
    @Getter
    private String lastName;
    private String email;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = new LinkedList();

        if (user.getRole().equals(Role.MANAGER)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + Role.USER));
        }

        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

        return new UserPrincipal(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
