package com.security.demo.service.impl;

import com.security.demo.commo.jwt.JwtTokenUtil;
import com.security.demo.commo.jwt.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserImpl {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsServiceImpl userDetailsService;


    public String login(String username,String password){
        JwtUser jwtUser= (JwtUser) userDetailsService.loadUserByUsername(username);
        if(jwtUser==null){
            System.err.println(jwtUser);
        }
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(jwtUser.getUsername(), password);
        Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenUtil.generateToken(userDetails);
    }
}
