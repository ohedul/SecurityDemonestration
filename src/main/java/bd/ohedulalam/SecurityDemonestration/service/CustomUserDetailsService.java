package bd.ohedulalam.SecurityDemonestration.service;

import bd.ohedulalam.SecurityDemonestration.model.CustomUserDetails;
import bd.ohedulalam.SecurityDemonestration.model.users;
import bd.ohedulalam.SecurityDemonestration.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    userRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<users> optionalUsers = userRepository.findByName(username);

        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found!"));

        CustomUserDetails customUserDetails = optionalUsers.map(user -> {
            return new CustomUserDetails(user);
        }).get();

        return customUserDetails;

    }
}
