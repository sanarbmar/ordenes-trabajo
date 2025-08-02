package com.concesionario.ordenes_trabajo.service;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (username.equals("admin")) {
            return new User("admin", "{noop}admin123", Collections.emptyList());
        }
        throw new UsernameNotFoundException("Usuario no encontrado");
    }
}
