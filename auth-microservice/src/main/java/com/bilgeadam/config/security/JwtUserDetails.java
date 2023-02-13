package com.bilgeadam.config.security;

import com.bilgeadam.repository.entity.Auth;
import com.bilgeadam.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtUserDetails implements UserDetailsService {

    @Autowired
    AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails getUserByAuthId(Long authId){
        Optional<Auth> auth = authService.findById(authId);
        if (auth.isEmpty()) return null;
        String authority = auth.get().getRoles().toString();
        return User.builder()
                .username(auth.get().getEmail())
                .password(auth.get().getPassword())
                .accountLocked(false)
                .accountExpired(false)
                .authorities(authority)
                .build();
    }

}
