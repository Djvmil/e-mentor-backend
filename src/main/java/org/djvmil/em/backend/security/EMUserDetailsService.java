package org.djvmil.em.backend.security;

import org.djvmil.em.backend.config.UserInfoConfig;
import org.djvmil.em.backend.core.dto.UserDto;
import org.djvmil.em.backend.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(EMUserDetailsService.class);

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("Entering in loadUserByUsername Method...");

        System.out.println("Entering in loadUserByUsername Method... :"+ username );
        UserDto userDto = userService.getUser(username);
        System.out.println("loadUserByUsername response "+ userDto);
        if (userDto == null) {
            logger.error("Username not found: " + username);
            throw new UsernameNotFoundException("User with this username does't exist");
        }

        System.out.println("loadUserByUsername response "+ userDto);
        List<GrantedAuthority> authorities = new ArrayList<>();
        userDto.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRole())));

        System.out.println("User Authenticated Successfully..!!!");
        logger.info("User Authenticated Successfully..!!!");
        return new UserInfoConfig(username,
                userDto.getPassword(),
                authorities
        );
    }
}