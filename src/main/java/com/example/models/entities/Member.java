package com.example.models.entities;

import com.example.models.entities.enums.MemberGenderEnum;
import com.example.models.entities.enums.security.RoleTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(callSuper = false)
@ToString(of = {"username", "password", "email", "role"})
@Getter
public class Member extends BaseEntity<Long> implements UserDetails {

    @Setter
    @Column(name = "member_Username",
            length = 50,
            unique = true,
            nullable = false)
    private String username;

    @Setter
    @Column(name = "member_Password",
            nullable = false)
    private String password;

    @Setter
    @Column(name = "member_Email",
            length = 50,
            unique = true,
            nullable = false)
    private String email;

    @Setter
    @Column(name = "member_Role",
            nullable = false,
            columnDefinition = "varchar default 'PLAYER'")
    @Enumerated(EnumType.STRING)
    private RoleTypeEnum role;

    @Setter
    @Column(name = "member_Gender", columnDefinition = "varchar default 'OTHER'")
    @Enumerated(EnumType.STRING)
    private MemberGenderEnum gender;

    @Setter
    @Column(name = "member_Birth_Date")
    private LocalDate birthDate;

    @Setter
    @Column(name = "member_elo",
            columnDefinition = "integer default 1200")
    private int elo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority Authority = new SimpleGrantedAuthority(this.role.toString());
        authorities.add(Authority);
        return authorities;
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
        return true;
    }

}