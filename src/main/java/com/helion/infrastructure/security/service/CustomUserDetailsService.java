
package com.helion.infrastructure.security.service;

import com.helion.domain.ports.output.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepositoryPort patientRepositoryPort;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return patientRepositoryPort.findByEmail(username)
                .map(user -> new CustomUserDetails(
                        user.getEmail(),
                        user.getPassword(),
                        true, true, true, true,
                        List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole())),
                        user.getId(),
                        user.getRole(),
                        Map.of("identification",user.getIdentification(),
                                "firstName", user.getFirstName(),
                                "middleName", user.getMiddleName(),
                                "lastName", user.getLastName(),
                                "middleLastName", user.getMiddleLastName(),
                                "email", user.getEmail(),
                                "phoneNumber", user.getPhoneNumber(),
                                "password", user.getPassword()

                        )
                                
                ))
                        .orElseThrow(() ->
                                new UsernameNotFoundException("No user or organization with email: " + username)
                        );
    }
}