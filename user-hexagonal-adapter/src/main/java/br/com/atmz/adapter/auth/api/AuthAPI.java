package br.com.atmz.adapter.auth.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.atmz.auth.application.AuthCommand;
import br.com.atmz.commons.cqrs.annotations.WebAdapter;

@WebAdapter
@RequestMapping("v1/")
public class AuthAPI {
	
	@PostMapping("authenticate")
	public ResponseEntity<?> authenticate (
			@RequestBody 
			@Valid AuthCommand command){
		return ResponseEntity.ok().build();
	}
 
}
