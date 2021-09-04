package demoSecurity.service;

import demoSecurity.model.ApUser;
import demoSecurity.repository.IApUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ApUserServie implements UserDetailsService {
    @Autowired
    IApUserRepository iApUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApUser user = iApUserRepository.findAllByUserName(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(user.getRole());

        UserDetails userDetails = new User(
                user.getUserName(),
                user.getPassWord(),
                authorities
        );

        return userDetails;
    }
}

