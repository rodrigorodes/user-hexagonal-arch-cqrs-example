package br.com.atmz.adapter.user.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.atmz.commons.cqrs.Bus;
import br.com.atmz.commons.cqrs.annotations.WebAdapter;
import br.com.atmz.user.read.application.queries.userall.UserAllQuery;
import br.com.atmz.user.read.application.queries.userbyid.UserByIdQuery;
import br.com.atmz.user.read.domain.UserAllRepresentation;
import br.com.atmz.user.read.domain.UserRepresentation;

@WebAdapter
@RequestMapping("v1/users")
public class ReadUserApi {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadUserApi.class);
	
	private Bus bus;
	
	public ReadUserApi(Bus bus) {
		this.bus = bus;
	}
	
	@GetMapping(value = "findAll")		
	public ResponseEntity<UserAllRepresentation> findAll() {
		
		LOGGER.info(" Init findAll ");
		
		return ResponseEntity.ok(bus.executeQuery(new UserAllQuery()));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserRepresentation> findById(
			@PathVariable("id") String id) {
		
		LOGGER.info(" Init FindById ");

		try {
			return ResponseEntity.ok(bus.executeQuery(new UserByIdQuery(id)));
		} catch (Exception e) {
			LOGGER.error("Id User not found " + id);
		}
		return ResponseEntity
				.notFound()
				.build();
	}


}
