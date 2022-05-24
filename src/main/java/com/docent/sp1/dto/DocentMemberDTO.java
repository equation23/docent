package com.docent.sp1.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;
import java.util.Collection;
@Getter
@Setter
@ToString
public class DocentMemberDTO extends User{
    private String did, dpw, dname, nickname;
    private LocalDateTime regDate,updateDate;

    public DocentMemberDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username,password,authorities);
        this.did = username;
        this.dpw = password;
    }
}