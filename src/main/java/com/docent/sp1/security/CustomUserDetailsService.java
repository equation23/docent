package com.docent.sp1.security;

import com.docent.sp1.domain.DAdmin;
import com.docent.sp1.domain.DocentMember;
import com.docent.sp1.dto.DocentMemberDTO;
import com.docent.sp1.mapper.MemberMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       DAdmin dAdmin = mapper.selectOne(username);

//        List<SimpleGrantedAuthority> authList = dAdmin.getDAdminList().stream()
//                .map(adminAuth -> new SimpleGrantedAuthority("ROLE_"+adminAuth.getRolename()))
//                .collect(Collectors.toList());
       SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_"+dAdmin.getRolename());


        User admin = new User(dAdmin.getDid(),dAdmin.getDpw(), Collections.singleton(simpleGrantedAuthority));

        return admin;
    }
}