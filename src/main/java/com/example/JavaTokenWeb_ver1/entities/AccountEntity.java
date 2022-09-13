package com.example.JavaTokenWeb_ver1.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Account")
public class AccountEntity implements Comparable<AccountEntity>, UserDetails {

    @Id
    @Pattern(regexp = "^[a-zA-Z0-9]{5,}", message = "Username must be alphanumeric characters")
    @Column(name = "username")
    private String username;

    //    @Pattern(regexp = "^[\b]{1,}",message = "Password must be alphanumeric characters")
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{5,}$",message = "Password must be alphanumeric characters")
    @Column(name = "password")
    private String password;

    @Pattern(regexp = "^[a-zA-Z\s]*", message = "Fullname must be alphanumeric characters")
    @Column(name = "fullname")
    private String fullname;

    @Pattern(regexp = "^ADMIN|^USER$", message = "Role must be ADMIN or USER")
    @Column(name = "role")
    private String role;

//    @Pattern(regexp ="^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = "")
//    @Pattern(regexp = "^[0][0-9]{9}",message = "Role must be ADMIN or USER")
//    private String phone;

    public BCryptPasswordEncoder bCryptPasswordEncoder(String pass) {
        return new BCryptPasswordEncoder();
    }

    @Override
    public int compareTo(AccountEntity o) {
        return this.username.compareTo(o.getUsername());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.getRole()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
