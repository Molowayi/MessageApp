package be.intecbrussel.eindwerkmolowayibackend.security;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

  /**
	 * 
	 */
	private static final long serialVersionUID = -5924163107155666786L;
private final String jwt;

  public AuthenticationResponse(String jwt) {
    this.jwt = jwt;
  }

  public String getJwt() {
    return jwt;
  }

  @Override
  public String toString() {
    return "AuthenticationResponse{" +
      "jwt='" + jwt + '\'' +
      '}';
  }
}
