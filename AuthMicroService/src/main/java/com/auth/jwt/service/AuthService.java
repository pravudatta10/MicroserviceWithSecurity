package com.auth.jwt.service;

import com.auth.jwt.dto.AUthRes;
import com.auth.jwt.dto.AuthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    public ResponseEntity<AUthRes> authenticate(AuthDto authDto) {
        Authentication authenticate;
        AUthRes aUthRes = new AUthRes();
        try {
            authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDto.getLoginId(), authDto.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException("Invalid UserName/Password");
        }
        if (authenticate.isAuthenticated()) {
            String token = jwtUtil.generateToken(authDto.getLoginId());
            aUthRes.setToken(token);
            return new ResponseEntity<>(aUthRes, HttpStatus.OK);

        } else {
            throw new RuntimeException("Invalid UserName/Password");
        }
    }
}