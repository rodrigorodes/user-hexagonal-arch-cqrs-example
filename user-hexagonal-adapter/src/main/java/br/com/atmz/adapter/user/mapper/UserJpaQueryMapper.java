package br.com.atmz.adapter.user.mapper;

import br.com.atmz.adapter.user.entity.UserJpa;
import br.com.atmz.user.read.domain.UserAllQueryRepresentation;
import br.com.atmz.user.read.domain.UserQueryRepresentation;

public class UserJpaQueryMapper {

	public static UserQueryRepresentation convertToQuery(UserJpa userJpa) {
		return new UserQueryRepresentation(userJpa.getId(), userJpa.getName(), userJpa.getMail(),
				userJpa.getRoleName());
	}

	public static UserAllQueryRepresentation convertToQueryAll(Iterable<UserJpa> findAll) {
		UserAllQueryRepresentation userAllQueryRepresentation = new UserAllQueryRepresentation();
		findAll.forEach(userJpa -> userAllQueryRepresentation.add(convertToQuery(userJpa)));
		return userAllQueryRepresentation;
	}
}
