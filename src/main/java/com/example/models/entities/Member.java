package com.example.models.entities;

import com.example.models.entities.enums.MemberGenderEnum;
import com.example.models.entities.enums.security.RoleTypeEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.*;

@Entity
@Getter
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
@ToString(of = {"username", "password", "email", "role"})
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
    @Column(name = "member_elo")
    @Range(min = 0, max = 3000)
    private int elo = 1200;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "MEMBER_TOURNAMENT",
            joinColumns = @JoinColumn(name = "MEMBER_ID"),
            inverseJoinColumns = @JoinColumn(name = "TOURNAMENT_ID")
    )
    private Set<Tournament> tournamentSet = new HashSet<>();

    public Set<Tournament> getTournamentSet() {
        return Set.copyOf(this.tournamentSet);
    }

    public void addTournament(Tournament tournament){
        this.tournamentSet.add(tournament);
        tournament.addMember(this);
    }    public void removeTournament(Tournament tournament){
        this.tournamentSet.remove(tournament);
        tournament.removeMember(this);
    }

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