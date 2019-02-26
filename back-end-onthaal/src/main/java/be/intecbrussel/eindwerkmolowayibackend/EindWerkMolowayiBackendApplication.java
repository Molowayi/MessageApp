package be.intecbrussel.eindwerkmolowayibackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = false)
public class EindWerkMolowayiBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(EindWerkMolowayiBackendApplication.class, args);
  }

  @Bean
  public WebSecurityConfigurer<WebSecurity> securityConfigurer() {
    return new WebSecurityConfigurerAdapter() {
      @Override
      protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Password for homer is also homer. Homer is ADMIN
        auth.inMemoryAuthentication()
          .passwordEncoder(new BCryptPasswordEncoder(8))
          .withUser("homer")
          .password("$2a$08$4df8tvQaueEBletINf9sd.lajIXxVyhKkz4T/nT.MQJ0AxYk.ZYya")
          .roles("ADMIN")
          .and()
          .withUser("guest")
          .password("$2a$08$4df8tvQaueEBletINf9sd.lajIXxVyhKkz4T/nT.MQJ0AxYk.ZYya")
          .roles("USER");
      }

      @Override
      protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests()
          .antMatchers("/ngongo/backoffice")
          .hasRole("ADMIN");
        http.csrf().disable();
      }
    };
  }
}
