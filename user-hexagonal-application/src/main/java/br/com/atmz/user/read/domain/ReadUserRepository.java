package br.com.atmz.user.read.domain;

public interface ReadUserRepository {

	UserQueryRepresentation findUserById(Long id);

	UserAllQueryRepresentation findAll();

}
