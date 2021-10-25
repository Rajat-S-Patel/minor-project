package com.blog.controller.auth;

import com.blog.config.MyUserDetailsService;
import com.blog.controller.response.AuthenticationResponse;
import com.blog.requests.AuthenticationRequest;
import com.blog.util.JWTUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final MyUserDetailsService userDetailsService;
    private  final JWTUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthController(MyUserDetailsService userDetailsService, JWTUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/authenticate")
    ResponseEntity<?> createAuthToken(@RequestBody AuthenticationRequest authenticationRequest) throws BadCredentialsException{
        String username = authenticationRequest.getUsername();
        System.out.println("username: "+username);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,authenticationRequest.getPassword()));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
