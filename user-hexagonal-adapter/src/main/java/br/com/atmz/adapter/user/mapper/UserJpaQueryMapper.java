package br.com.atmz.adapter.user.mapper;

import br.com.atmz.adapter.user.entity.UserJpa;
import br.com.atmz.user.read.domain.UserAllRepresentation;
import br.com.atmz.user.read.domain.UserRepresentation;

public class UserJpaQueryMapper {

	public static UserRepresentation convertToQuery(UserJpa userJpa) {
		return new UserRepresentation(userJpa.getId(), userJpa.getName(), userJpa.getMail(),
				userJpa.getRoleName());
	}

	public static UserAllRepresentation convertToQueryAll(Iterable<UserJpa> findAll) {
		UserAllRepresentation userAllQueryRepresentation = new UserAllRepresentation();
		findAll.forEach(userJpa -> userAllQueryRepresentation.add(convertToQuery(userJpa)));
		return userAllQueryRepresentation;
	}
}
