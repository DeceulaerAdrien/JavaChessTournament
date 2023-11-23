package com.example.models.dtos.security;

import com.example.models.entities.Member;
import com.example.models.entities.enums.security.RoleTypeEnum;
import lombok.*;

//Le token devant être SET par la suite, il n'est pas possible de faire un record la ou les données sont immuables
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "username", "role"})
@ToString(of = {"id", "username", "role"})
public class MemberTokenDTO {
    private long id;
    private String username;
    private RoleTypeEnum role;
    private String token;

    public static MemberTokenDTO fromEntity(Member member) {
        MemberTokenDTO dto = new MemberTokenDTO();
        dto.setId(member.getId());
        dto.setUsername(member.getUsername());
        dto.setRole(member.getRole());
        return dto;
    }

}
