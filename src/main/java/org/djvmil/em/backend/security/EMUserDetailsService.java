package org.djvmil.em.backend.security;

import org.djvmil.em.backend.core.dto.UserDto;
import org.djvmil.em.backend.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class EMUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("except 9");
        UserDto userDto = userService.getByUsername(username);
        System.out.println("except 8");
        if (userDto == null) throw new UsernameNotFoundException("User with this username does't exist");

        List<GrantedAuthority> authorities = new ArrayList<>();
        /*userDto.getRoles().forEach(role -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getRole());
            authorities.add(authority);

                });*/

        System.out.println("except 5");
        userDto.getRoles().forEach(role -> authorities.add( new SimpleGrantedAuthority(role.getRole())));

        System.out.println("except 5-1");
        return new User(userDto.getUsername(),
                userDto.getPassword(),
                authorities
        );
    }
}
