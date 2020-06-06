package be.intecbrussel.eindwerkmolowayibackend.controllers;

import be.intecbrussel.eindwerkmolowayibackend.security.AuthenticationRequest;
import be.intecbrussel.eindwerkmolowayibackend.security.AuthenticationResponse;
import be.intecbrussel.eindwerkmolowayibackend.security.JwtUtil;
import be.intecbrussel.eindwerkmolowayibackend.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class GeneralController {
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtUtil jwtTokenUtil;

  @Autowired
  private MyUserDetailsService userDetailsService;

  @RequestMapping({"/hello"})
  public String firstPage() {
    return "Hello World";
  }

  @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
  public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

    try {
      authenticationManager.authenticate(
        new

          UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
      );
    } catch (BadCredentialsException e) {
      throw new Exception("Incorrect username or password", e);
    }


    final UserDetails userDetails = userDetailsService
      .loadUserByUsername(authenticationRequest.getUsername());

    final String jwt = jwtTokenUtil.generateToken(userDetails);

    return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }

}
