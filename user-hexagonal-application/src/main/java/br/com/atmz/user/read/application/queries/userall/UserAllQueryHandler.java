package br.com.atmz.user.read.application.queries.userall;

import javax.inject.Named;

import br.com.atmz.commons.cqrs.query.QueryHandler;
import br.com.atmz.user.read.domain.ReadUserRepository;
import br.com.atmz.user.read.domain.UserAllQueryRepresentation;

@Named
public class UserAllQueryHandler implements QueryHandler<UserAllQueryRepresentation, UserAllQuery>{
	
	private ReadUserRepository repository;

	public UserAllQueryHandler(ReadUserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserAllQueryRepresentation handle(UserAllQuery query) {
		return repository.findAll();
	}

}
