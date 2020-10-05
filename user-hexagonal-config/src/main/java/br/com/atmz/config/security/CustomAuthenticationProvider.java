package br.com.atmz.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import br.com.atmz.adapter.auth.service.ReadAuthAdapter;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private ReadAuthAdapter userService;	
 
    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        
    	final String name = authentication.getName();
    	final String password = authentication.getCredentials().toString();
    	
        UserDetails user = userService.loadUserByUsername(name);
        
        if(!Optional.of(user).isPresent()){
        	return null;
        }
        
        return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
    }
 
	@Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}