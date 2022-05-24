package com.docent.sp1.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/sample")
public class SampleController {


    @GetMapping("/all")
    public void doAll(){

    }
    @PreAuthorize("hasAnyRole('ROLE_MEMBER','ROLE_ADMIN')")
    @GetMapping("/member")
    public void doMember(){

    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public void doAdmin(){

    }

}
