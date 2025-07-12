package com.example.tweetnest.tweetnest.controller;

import com.example.tweetnest.tweetnest.config.JwtProvider;
import com.example.tweetnest.tweetnest.exception.UserException;
import com.example.tweetnest.tweetnest.model.User;
import com.example.tweetnest.tweetnest.model.Verification;
import com.example.tweetnest.tweetnest.repository.UserRepository;
import com.example.tweetnest.tweetnest.response.AuthResponse;
import com.example.tweetnest.tweetnest.service.CustomUserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private CustomUserDetailsServiceImplementation customUserDetailsServiceImplementation;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {

        String email = user.getEmail();
        String password = user.getPassword();
        String fullName = user.getFullName();
        String birthDate = user.getBirthDate();

        User isEmailExists = userRepository.findByEmail(email);
        if (isEmailExists !=null){
            throw new UserException("Email is already used with another account");
        }

        User createdUser = new User();
        createdUser.setEmail(email);
        createdUser.setFullName(fullName);
        createdUser.setPassword(passwordEncoder.encode(password));
        createdUser.setBirthDate(birthDate);
        createdUser.setVerification(new Verification());

        User savedUser = userRepository.save(createdUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(email,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);

        AuthResponse response = new AuthResponse(token,true);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signIn(@RequestBody User user){
        String username = user.getEmail();
        String password = user.getPassword();
        Authentication authentication = authenticate(username,password);

        String token = jwtProvider.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse(token,true);

        return new ResponseEntity<>(authResponse,HttpStatus.ACCEPTED);
    }

    private Authentication authenticate(String username, String password) {

        UserDetails userDetails = customUserDetailsServiceImplementation.loadUserByUsername(username);

        if (userDetails == null){
            throw new BadCredentialsException("Invalid Username");
        }
        if (!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("Invalid password");
        }
            return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());


    }


}
