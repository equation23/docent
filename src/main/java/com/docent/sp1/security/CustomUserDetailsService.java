package com.docent.sp1.security;

import com.docent.sp1.domain.DocentMember;
import com.docent.sp1.dto.DocentMemberDTO;
import com.docent.sp1.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("===========================");
        log.info("===========================");
        log.info(username);

        DocentMember docentMember = mapper.selectOne(username);

        log.info(docentMember);

        log.info("===========================");
        log.info("===========================");
        List<SimpleGrantedAuthority> authList = docentMember.getDocentAuthList().stream()
                .map(docentAuth -> new SimpleGrantedAuthority("ROLE_"+docentAuth.getRoleName()))
                .collect(Collectors.toList());

        User user = new User(docentMember.getDid(), docentMember.getDpw(),authList);
        return user;
    }
}