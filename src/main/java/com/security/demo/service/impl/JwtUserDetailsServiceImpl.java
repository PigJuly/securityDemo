package com.security.demo.service.impl;

import com.security.demo.commo.jwt.JwtUser;
import com.security.demo.entity.SysUser;
import com.security.demo.entity.Sysrole;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser=new SysUser();
        Set<Sysrole> sysroles=new HashSet<>();
        Sysrole sysrole=new Sysrole();
        sysrole.setName("ROLE_USER");
        sysroles.add(sysrole);
        sysUser.setRole(sysroles);
        List<SimpleGrantedAuthority> collect = sysUser.getRole().stream().map(Sysrole::getName).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return new JwtUser("17748789039", "$2a$10$RcHBHpLiuXok9G/LNzTMLuIl/kFxcLW.AYLar0..Y0QCUARopmFqG", 1, collect);
    }
}
