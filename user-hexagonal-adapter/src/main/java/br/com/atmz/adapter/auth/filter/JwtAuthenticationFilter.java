package br.com.atmz.adapter.auth.filter;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.atmz.auth.application.AuthCommand;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final long DATE_MILLS_EXP = System.currentTimeMillis() + 864000000;
	private final AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl(JwtConstantsProperties.AUTH_LOGIN_URL);
    }

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {

		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}
		
		AuthCommand authCommand = parseLogin(request);
		
		UsernamePasswordAuthenticationToken authenticationToken = 
				new UsernamePasswordAuthenticationToken(authCommand.getUsername(),
				authCommand.getPassword());
		
		return authenticationManager.authenticate(authenticationToken);
	}
	
	private AuthCommand parseLogin(HttpServletRequest request) {
	    try {
	        ObjectMapper mapper = new ObjectMapper();
	        return mapper.readValue(request.getInputStream(), AuthCommand.class);
	    } catch (IOException exception) {
	        return new AuthCommand();
	    }
	}
	
    @Override
    protected void successfulAuthentication(
    		HttpServletRequest request, 
    		HttpServletResponse response,
    		FilterChain filterChain, 
    		Authentication authentication) {
        UserDetails user = ((UserDetails) authentication.getPrincipal());

         List<String> roles = user.getAuthorities()
            .stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList());

          byte[] signingKey = JwtConstantsProperties.JWT_SECRET.getBytes();
          
          String token = Jwts.builder()
        		  			  .signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
					          .setHeaderParam("typ", JwtConstantsProperties.TOKEN_TYPE)
					          .setIssuer(JwtConstantsProperties.TOKEN_ISSUER)
					          .setAudience(JwtConstantsProperties.TOKEN_AUDIENCE)
					          .setSubject(user.getUsername())
					          .setExpiration(new Date(DATE_MILLS_EXP))
					          .claim("rol", roles)
					          .compact();

        response.addHeader(JwtConstantsProperties.TOKEN_HEADER, JwtConstantsProperties.TOKEN_PREFIX + token);
    }
}