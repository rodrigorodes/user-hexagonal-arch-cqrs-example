package br.com.atmz.user.read.application.queries.userbyid;

import br.com.atmz.commons.cqrs.query.Query;
import br.com.atmz.user.read.domain.UserRepresentation;

public class UserByIdQuery implements Query<UserRepresentation> {

	private Long id;

	public UserByIdQuery(String id) {
		this.id = Long.valueOf(id);
	}

	public Long getId() {
		return id;
	}

}
