package org.djvmil.em.backend.security;

import org.djvmil.em.backend.config.UserInfoConfig;
import org.djvmil.em.backend.core.dto.UserDto;
import org.djvmil.em.backend.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EMUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDto userDto = userService.getByEmail(username);
        if (userDto == null) throw new UsernameNotFoundException("User with this username does't exist");

        List<GrantedAuthority> authorities = new ArrayList<>();
        userDto.getRoles().forEach(role -> authorities.add( new SimpleGrantedAuthority(role.getRole())));

        return new UserInfoConfig(userDto.getEmail(),
                userDto.getPassword(),
                authorities
        );
    }
}