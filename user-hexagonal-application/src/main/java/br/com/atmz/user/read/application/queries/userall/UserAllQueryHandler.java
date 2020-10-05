package br.com.atmz.user.read.application.queries.userall;

import javax.inject.Named;

import br.com.atmz.commons.cqrs.query.QueryHandler;
import br.com.atmz.user.read.domain.ReadUserRepository;
import br.com.atmz.user.read.domain.UserAllRepresentation;

@Named
public class UserAllQueryHandler implements QueryHandler<UserAllRepresentation, UserAllQuery>{
	
	private ReadUserRepository repository;

	public UserAllQueryHandler(ReadUserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserAllRepresentation handle(UserAllQuery query) {
		return repository.findAll();
	}

}
