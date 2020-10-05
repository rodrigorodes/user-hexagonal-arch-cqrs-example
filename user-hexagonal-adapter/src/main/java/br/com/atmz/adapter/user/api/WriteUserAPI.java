package br.com.atmz.adapter.user.api;

import java.net.URI;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.atmz.commons.cqrs.Bus;
import br.com.atmz.commons.cqrs.annotations.WebAdapter;
import br.com.atmz.user.write.application.commands.create.CreateUserCommand;
import br.com.atmz.user.write.application.commands.create.CreateUserRepresentation;
import br.com.atmz.user.write.application.commands.update.UpdateUserCommand;
import br.com.atmz.user.write.application.commands.update.UpdateUserRepresentation;

@WebAdapter
@RequestMapping("v1/users")
public class WriteUserAPI {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(WriteUserAPI.class);
	
	private Bus bus;
	
	public WriteUserAPI(Bus bus) {
		this.bus = bus;
	}
	
	@PostMapping
	public ResponseEntity<CreateUserRepresentation> create(
			@Valid 
			@RequestBody 
			CreateUserCommand command,  
			UriComponentsBuilder uriBuilder) {
		
		LOGGER.info(" Init create User ");
		
		CreateUserRepresentation rep = bus.executeCommand(command);
		
		URI uri  = uriBuilder
				.path("/users/{id}")
				.buildAndExpand(rep.getUser().getId())
				.toUri();
		
		LOGGER.info(" Finish Create User  ");
		return ResponseEntity
				.ok()
				.location(uri)
				.build();
	}
	
	
	@PutMapping
	public ResponseEntity<UpdateUserRepresentation> update(
			@Valid 
			@RequestBody 
			UpdateUserCommand command) {
		
		LOGGER.info(" Init Update User ");
		
		bus.executeCommand(command);
		
		LOGGER.info(" Finish Update User  ");
		return ResponseEntity
				.ok()
				.build();
	}

}
