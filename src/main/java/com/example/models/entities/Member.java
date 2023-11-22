package com.example.models.entities;

import com.example.models.entities.enums.MemberGenderEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(of = {"username", "password", "email", "role"})
public class Member extends BaseEntity<Long> implements UserDetails {

    @Column(name = "Member_Username",
            length = 50,
            unique = true)
    @Setter
    private String username;

    @Column(name = "Member_Password")
    @Setter
    private String password;

    @Column(name = "Member_Email",
            length = 50,
            unique = true)
    @Setter
    private String email;

    @Column(name = "Member_Role")
    @Setter
    private String role;

    @Column(name = "Member_Gender",columnDefinition = "VARCHAR DEFAULT 'OTHER'")
    @Enumerated(EnumType.STRING)
    @Setter
    private MemberGenderEnum gender;

    @Column(name = "Member_Birth_Date")
    @Setter
    private LocalDate birthDate;

    @Column(name = "Member_Elo", columnDefinition = "int DEFAULT 1200")
    @Range(min = 0, max = 3000)
    @Setter
    private int elo;

    @Setter
    private Boolean isActive;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(this.role);
        authorities.add(grantedAuthority);
        return authorities;
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
        return this.isActive;
    }
}