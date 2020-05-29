package com.briller.Service;

import com.briller.Model.generalUserDetails;
import com.briller.Model.Users;
import com.briller.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = userRepository.findByUserName(username);
        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUsers.map(generalUserDetails::new).get();
    }
}
