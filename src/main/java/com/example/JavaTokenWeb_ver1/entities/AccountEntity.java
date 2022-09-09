package com.example.JavaTokenWeb_ver1.entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Account")
public class AccountEntity implements Serializable, Comparable<AccountEntity>, Cloneable, UserDetails {

    @Id
//    @Pattern(regexp = "^[a-zA-Z0-9]",message = "Username must be alphanumeric characters")
    @Column(name = "username")
    private String username;

//    @Pattern(regexp = "^[a-zA-Z0-9]",message = "Password must be alphanumeric characters")
    @Column(name = "password")
    private String password;

//    @Pattern(regexp = "^[a-zA-Z]",message = "Fullname must be alphanumeric characters")
    @Column(name = "fullname")
    private String fullname;

//    @Pattern(regexp = "^[A-Z]",message = "Role must be ADMIN or USER")
    @Column(name = "role")
    private String role;

    public BCryptPasswordEncoder bCryptPasswordEncoder(String pass) {
        return new BCryptPasswordEncoder();
    }

    @Override
    public int compareTo(AccountEntity o) {
        return this.username.compareTo(o.getUsername());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.getRole()));
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
