package co.develhope.jwtFilterExample.services;

import co.develhope.jwtFilterExample.dtos.LoginUserDto;
import co.develhope.jwtFilterExample.dtos.RegisterUserDto;
import co.develhope.jwtFilterExample.entities.User;
import co.develhope.jwtFilterExample.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public User signup(RegisterUserDto input) {
        return userRepository.save(new User(input.getFullName(), input.getUsername(), passwordEncoder.encode(input.getPassword())));
    }

    public User authenticate(LoginUserDto input) {

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                input.getUsername(),
                input.getPassword()
            )
        );

        return userRepository.findByUsername(input.getUsername()).orElseThrow();
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}
