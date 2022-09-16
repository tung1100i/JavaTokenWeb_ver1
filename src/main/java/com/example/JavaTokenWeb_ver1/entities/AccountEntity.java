package com.example.JavaTokenWeb_ver1.entities;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Account")
public class AccountEntity implements Comparable<AccountEntity>, UserDetails {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;



    @OneToMany(mappedBy = "usernameOder", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()
    private List<OderEntity> oderEntities;

//    @OneToMany(mappedBy = "usernameOder", cascade = CascadeType.ALL)
//    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
//    @ToString.Exclude // Khoonhg sử dụng trong toString()
//    private List<OderEntity> oderEntities;

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
