package br.com.atmz.user.read.application.queries.userbyid;

import javax.inject.Named;

import br.com.atmz.commons.cqrs.query.QueryHandler;
import br.com.atmz.user.read.domain.ReadUserRepository;
import br.com.atmz.user.read.domain.UserRepresentation;

@Named
public class UserByIdQueryHandler implements QueryHandler<UserRepresentation, UserByIdQuery>{
	
	private ReadUserRepository repository;

	public UserByIdQueryHandler(ReadUserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserRepresentation handle(UserByIdQuery query) {
		return repository.findUserById(query.getId());
	}

}
