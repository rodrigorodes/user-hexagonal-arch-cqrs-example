package br.com.atmz.adapter.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.atmz.adapter.user.entity.UserJpa;
import br.com.atmz.adapter.user.repository.UserRepository;
import br.com.atmz.commons.cqrs.annotations.RepositoryAdapter;

@RepositoryAdapter
public class ReadAuthAdapter implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserJpa> userOptional = userRepository.findByMail(username);
		
		if(!userOptional.isPresent()) {
			throw new UsernameNotFoundException("User Not found !!!!");
		}
		
		return userOptional.get();
	}


}
