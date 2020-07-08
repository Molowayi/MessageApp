package be.intecbrussel.eindwerkmolowayibackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUserName(userName);

		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

		return user.map(MyUserDetails::new).get();
	}

	public User save(AuthenticationRequest user) {
		
		User newUser = new User();
		newUser.setUserName(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setActive(true);
		newUser.setRoles("ADMIN");
		newUser = userRepository.save(newUser);
		System.out.println(newUser);
		return newUser;
	}
}
